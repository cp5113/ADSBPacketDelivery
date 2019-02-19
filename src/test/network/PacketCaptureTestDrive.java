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
	
	
	// 정적으로 jnetpcap.dll 파일 로드 
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
		int l_snapLen 	= 64*1024; //65536Byte 캡쳐
		int l_flags 	= Pcap.MODE_NON_PROMISCUOUS;// 무차별 모드
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
		int 		l_id		= JRegistry.mapDLTToId(l_aPcap.datalink()); // Data Link 유형
		
		while(l_aPcap.nextEx(l_header,l_buffer) == Pcap.NEXT_EX_OK) {
			// Extract Packet from PCAP
			PcapPacket	packet	= new PcapPacket(l_header,l_buffer);
			
			packet.scan(l_id);// 새로운 패킷을 스캔하여, 헤더를 찾는다.
			System.out.println("--------------------------------");
			System.out.println(packet.getFrameNumber());
			System.out.println("--------------------------------");
			
			if(packet.hasHeader(l_ipv4)) { // ip 헤더를 가지고 있다면
				System.out.println("출발지 : " + FormatUtils.ip(l_ipv4.source())+ "     목적지 : " + FormatUtils.ip(l_ipv4.destination()));
			}
			
			if(packet.hasHeader(l_tcp)) { // tcp 헤더를 가지고 있다면
				System.out.println("출발지 Port : " + l_tcp.source()+ "     목적지 Port : " + l_tcp.destination());
			}
			if(packet.hasHeader(l_payload)) { // Payload 헤더를 가지고 있다면
				System.out.print(l_payload.toHexdump());
			}
			
		}
		
		
		
	}
	
}




//Backup
//// Set initial info
//StringBuilder 	l_errbuf 	= new StringBuilder();
//int 			l_snaplen 	= 64 * 1024; //65536Byte
//int 			l_flags 	= Pcap.MODE_NON_PROMISCUOUS; // 무차별모드
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
//int 		id          = JRegistry.mapDLTToId(l_pcap.datalink());	// pcap의 datalink 유형을 jNetPcap의 프로토콜 ID에 맵핑
//
//while(l_pcap.nextEx(header, buf) == Pcap.NEXT_EX_OK) // 헤더와 버퍼를 피어링
//{
//	PcapPacket packet = new PcapPacket(header, buf);
//	
//	packet.scan(id); //새로운 패킷을 스캔하여 포함 된 헤더를 찾습니다
//	System.out.printf("[ #%d ]\n", packet.getFrameNumber());
//	System.out.println("##################################### Packet #####################################");
//	if (packet.hasHeader(ethernet)) {
//		System.out.printf("출발지 MAC 주소 = %s\n도착지 MAC 주소 = %s\n", 
//				FormatUtils.mac(ethernet.source()), FormatUtils.mac(ethernet.destination()));
//	}
//	if (packet.hasHeader(ip)) {
//		System.out.printf("출발지 IP 주소 = %s\n도착지 IP 주소 = %s\n", 
//				FormatUtils.ip(ip.source()), FormatUtils.ip(ip.destination()));
//	}
//	if (packet.hasHeader(tcp)) {
//		System.out.printf("출발지 TCP 주소 = %d\n도착지 TCP 주소 = %d\n", 
//				tcp.source(), tcp.destination());
//	}
//	if (packet.hasHeader(payload)) {
//		System.out.printf("페이로드의 길이 = %d\n", payload.getLength()); 
//		System.out.print(payload.toHexdump());	// 와이어샤크에서 보이는 hexdump를 출력
//	}
//}
//l_pcap.close();
//
//
//































