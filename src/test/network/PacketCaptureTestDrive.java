// https://javatutorial.net/capture-network-packages-java

package test.network;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapHeader;
import org.jnetpcap.PcapIf;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.nio.JMemory;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.Payload;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;

public class PacketCaptureTestDrive {
	
	List<PcapIf> fDeviceList = null;
	
	
	// �������� jnetpcap.dll ���� �ε� 
	static { 
		try { 
			// native Library Load 
			System.out.println("Load Dll for JnetPcap....");
			System.load(new File("./Lib/jnetpcap.dll").getAbsolutePath()); 
			System.out.println(new File("./Lib/jnetpcap.dll").getAbsolutePath()); 
		} catch (UnsatisfiedLinkError e) { 
			System.out.println("Native code library failed to load.\n" + e); System.exit(1); 
		} 
	}



	
	
	public static void main(String args[]) {
		
		PacketCaptureTestDrive myMain = new PacketCaptureTestDrive();
		myMain.doStart();
		
		
	}
	
	private void doStart() {
		
		findNetworkAdaptorList();
		capturePacket(5);
		
	}
	
	
	@SuppressWarnings("deprecation")
	private void findNetworkAdaptorList() {
		
		// Initialize variables
		fDeviceList = new ArrayList<PcapIf>(); // Will be filled with NICs		
		StringBuilder errbuf = new StringBuilder(); // For any error msgs
		
		// Find device
		int r = Pcap.findAllDevs(fDeviceList, errbuf);
		
		// Error Check
		if (r == Pcap.NOT_OK || fDeviceList.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}
		
		// Show List
		System.out.println("Network devices found:");
		int i = 0;
		for (PcapIf device : fDeviceList) {
			String description = (device.getDescription() != null) ? device
					.getDescription() : "No description available";
			System.out.printf("#%d: %s [%s]\n", i++, device.getName(),
					description);
		}
	}

	private void capturePacket(int a_DeviceNumber) {
		// Select Device
		PcapIf l_ThisDevice = fDeviceList.get(a_DeviceNumber);
		System.out.println("You choose " + l_ThisDevice.getDescription());
		

		
		// Set initial info
		int l_snapLen 	= 64*1024; //65536Byte ĸ��
		int l_flags 	= Pcap.MODE_NON_PROMISCUOUS;// ������ ���
		int l_timeOut   = 1*1000;// 10 seconds
		
		// get pcap
		StringBuilder 	l_errBuf  	= new StringBuilder();
		Pcap 			l_aPcap = null;
		try {
		l_aPcap		= Pcap.openLive(l_ThisDevice.getName(), l_snapLen, l_flags, l_timeOut, l_errBuf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// Decoding Setup
		Ethernet 	l_ethernet 	= new Ethernet();
		Ip4			l_ipv4		= new Ip4();		
		Udp 		l_udp		= new Udp();
		Tcp 		l_tcp		= new Tcp();
		Payload		l_payload	= new Payload();
		PcapHeader 	l_header 	= new PcapHeader(JMemory.POINTER);
		JBuffer		l_buffer	= new JBuffer(JMemory.POINTER);		
		int 		l_id		= JRegistry.mapDLTToId(l_aPcap.datalink()); // Data Link ����
		
		while(l_aPcap.nextEx(l_header,l_buffer) == Pcap.NEXT_EX_OK) {
			// Extract Packet from PCAP
			PcapPacket	packet	= new PcapPacket(l_header,l_buffer);
			
			packet.scan(l_id);// ���ο� ��Ŷ�� ��ĵ�Ͽ�, ����� ã�´�.
			System.out.println("--------------------------------");
			System.out.println(packet.getFrameNumber());
			System.out.println("--------------------------------");
			
			if(packet.hasHeader(l_ipv4)) { // ip ����� ������ �ִٸ�
				System.out.println("����� : " + FormatUtils.ip(l_ipv4.source())+ "     ������ : " + FormatUtils.ip(l_ipv4.destination()));
			}
			
			if(packet.hasHeader(l_tcp)) { // tcp ����� ������ �ִٸ�
				System.out.println("����� Port : " + l_tcp.source()+ "     ������ Port : " + l_tcp.destination());
			}
			if(packet.hasHeader(l_payload)) { // Payload ����� ������ �ִٸ�
				System.out.print(l_payload.toHexdump());
			}
			
		}
		
		
		
	}
	
}




//Backup
//// Set initial info
//StringBuilder 	l_errbuf 	= new StringBuilder();
//int 			l_snaplen 	= 64 * 1024; //65536Byte
//int 			l_flags 	= Pcap.MODE_NON_PROMISCUOUS; // ���������
//int 			l_timeout 	= 10 *1000; // 10second
//Pcap 			l_pcap 		= Pcap.openLive(l_ThisDevice.getName(), l_snaplen, l_flags, l_timeout, l_errbuf);
//				
//
//// Decoding Setup
//Ethernet 	ethernet 	= new Ethernet();
//Ip4 		ip 			= new Ip4();
//Tcp 		tcp 		= new Tcp();
//Udp			udp			= new Udp();
//Payload 	payload 	= new Payload();
//PcapHeader 	header 		= new PcapHeader(JMemory.POINTER);
//JBuffer 	buf 		= new JBuffer(JMemory.POINTER);
//
//int 		id          = JRegistry.mapDLTToId(l_pcap.datalink());	// pcap�� datalink ������ jNetPcap�� �������� ID�� ����
//
//while(l_pcap.nextEx(header, buf) == Pcap.NEXT_EX_OK) // ����� ���۸� �Ǿ
//{
//	PcapPacket packet = new PcapPacket(header, buf);
//	
//	packet.scan(id); //���ο� ��Ŷ�� ��ĵ�Ͽ� ���� �� ����� ã���ϴ�
//	System.out.printf("[ #%d ]\n", packet.getFrameNumber());
//	System.out.println("##################################### Packet #####################################");
//	if (packet.hasHeader(ethernet)) {
//		System.out.printf("����� MAC �ּ� = %s\n������ MAC �ּ� = %s\n", 
//				FormatUtils.mac(ethernet.source()), FormatUtils.mac(ethernet.destination()));
//	}
//	if (packet.hasHeader(ip)) {
//		System.out.printf("����� IP �ּ� = %s\n������ IP �ּ� = %s\n", 
//				FormatUtils.ip(ip.source()), FormatUtils.ip(ip.destination()));
//	}
//	if (packet.hasHeader(tcp)) {
//		System.out.printf("����� TCP �ּ� = %d\n������ TCP �ּ� = %d\n", 
//				tcp.source(), tcp.destination());
//	}
//	if (packet.hasHeader(payload)) {
//		System.out.printf("���̷ε��� ���� = %d\n", payload.getLength()); 
//		System.out.print(payload.toHexdump());	// ���̾��ũ���� ���̴� hexdump�� ���
//	}
//}
//l_pcap.close();
//
//
//































