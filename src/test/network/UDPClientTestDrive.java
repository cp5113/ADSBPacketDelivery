package test.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import elements.Aircraft;

public class UDPClientTestDrive {

	public static void main(String args[]) {
		
		try {

			int port					=	5153;
			DatagramSocket	 clientSock = new DatagramSocket();

			InetAddress		ip			= InetAddress.getByName("25.12.56.47");
			int c						=	0;
			
			
			// Create Stream

			while(true) {			
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream	oos	  = new ObjectOutputStream(bos);
				
				oos.writeObject(new Aircraft(new Date(),"Initial","Initial",c,c,c++,(short) 0));
				oos.flush();

				//Create Packet
				byte[] data = bos.toByteArray();
				DatagramPacket	packet		= new DatagramPacket(data, data.length,ip,port);

				// Send
				clientSock.send(packet);
				oos.close();
				
				Thread.sleep(100);
				

			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
