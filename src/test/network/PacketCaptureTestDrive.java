// https://javatutorial.net/capture-network-packages-java

package test.network;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

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
	}
	
	
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

	
	
}
