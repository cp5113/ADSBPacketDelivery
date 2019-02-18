package test.network;

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

public class PacketCaptureWebTestDrive {

	public static void main(String[] args) {
		
		ArrayList<PcapIf> allDevs = new ArrayList<PcapIf>(); 
		// ����̽��� ���� ������ ArrayList�� ����
		StringBuilder errbuf = new StringBuilder();	
		// ����ó��
		
		int r = Pcap.findAllDevs(allDevs, errbuf);	
		// ���ٰ����� ����̽��� ù ��°���ڿ� ��´�, �� ��°���ڴ� ����ó��
		
		if (r==Pcap.NOT_OK || allDevs.isEmpty()) {
			System.out.println("��Ʈ��ũ ��ġ ã�� ����." + errbuf.toString());
			return;
		}	// ����ó��
		
		System.out.println("< Ž���� ��Ʈ��ũ Device >");
		int i = 0;	// Device Numbering �뵵
		
		for(PcapIf device : allDevs) 
		{	// Ž���� ��� ���
			String description = (device.getDescription() != null) ? device.getDescription() : "��� ���� ������ �����ϴ�.";
			System.out.printf("[%d��]: %s [%s]\n", ++i, device.getName(), description);
		}
		
		PcapIf device = allDevs.get(0);
		System.out.printf("���õ� ��ġ: %s\n", (device.getDescription() != null) ?
				device.getDescription() : device.getName());

		int snaplen = 64 * 1024; //65536Byte��ŭ ��Ŷ�� ĸ��
		int flags = Pcap.MODE_NON_PROMISCUOUS; // ���������
		int timeout = 10 *1000; // timeout 10second
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);
		
		if (pcap == null) {
			System.out.printf("Network Device Access Failed. Error: " + errbuf.toString());
			return;
		}
		
		// ���⼭ ���� ������ ��ü ����
		Ethernet eth = new Ethernet();
		Ip4 ip = new Ip4();
		Tcp tcp = new Tcp();
		Payload payload = new Payload();
		PcapHeader header = new PcapHeader(JMemory.POINTER);
		JBuffer buf = new JBuffer(JMemory.POINTER);
		
		int id = JRegistry.mapDLTToId(pcap.datalink());	// pcap�� datalink ������ jNetPcap�� �������� ID�� ����
		
		while(pcap.nextEx(header, buf) == Pcap.NEXT_EX_OK) // ����� ���۸� �Ǿ
		{
			PcapPacket packet = new PcapPacket(header, buf);
			
			packet.scan(id); //���ο� ��Ŷ�� ��ĵ�Ͽ� ���� �� ����� ã���ϴ�
			System.out.printf("[ #%d ]\n", packet.getFrameNumber());
			System.out.println("##################################### Packet #####################################");
			if (packet.hasHeader(eth)) {
				System.out.printf("����� MAC �ּ� = %s\n������ MAC �ּ� = %s\n", 
						FormatUtils.mac(eth.source()), FormatUtils.mac(eth.destination()));
			}
			if (packet.hasHeader(ip)) {
				System.out.printf("����� IP �ּ� = %s\n������ IP �ּ� = %s\n", 
						FormatUtils.ip(ip.source()), FormatUtils.ip(ip.destination()));
			}
			if (packet.hasHeader(tcp)) {
				System.out.printf("����� TCP �ּ� = %d\n������ TCP �ּ� = %d\n", 
						tcp.source(), tcp.destination());
			}
			if (packet.hasHeader(payload)) {
				System.out.printf("���̷ε��� ���� = %d\n", payload.getLength()); 
				System.out.print(payload.toHexdump());	// ���̾��ũ���� ���̴� hexdump�� ���
			}
		}
		pcap.close();
	}
}