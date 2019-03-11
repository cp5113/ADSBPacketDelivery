package test.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import elements.Aircraft;

public class UDPServerTestDrive {

	public static void main(String args[]) {
		
		try {

			int port					=	5153;
			DatagramSocket	 serverSocket = new DatagramSocket(port);
			
			
			//Create Packet
			byte[] data = new byte[582];
			DatagramPacket	packet		= new DatagramPacket(data, data.length);
			
			// Receive
			while(true){
				System.out.println("Waiting");
				serverSocket.receive(packet);
				System.out.println("Received : " + packet.getLength());
				byte[] receiveData = packet.getData();
				
				ByteArrayInputStream bis = new ByteArrayInputStream(receiveData);
				ObjectInputStream	ois  = new ObjectInputStream(bis);
				
				Aircraft anAircraft = (Aircraft) ois.readObject();
				System.out.println(anAircraft);
			}
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
