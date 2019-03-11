package test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

import elements.Aircraft;

public class ServerObjectTestDrive {
	
	private  final int SERVER_PORT = 5153;
	private HashMap<String, Object> fClientList = new HashMap<String, Object>();
	
	
	
	public static void main(String[] args) {
		
	ServerObjectTestDrive	myMain = new ServerObjectTestDrive();
	myMain.doStart();
		
		

	}
	
	private void doStart() {
		
		createSocket();
		
	}
	
	public void createSocket() {
		
		try {
			
			//Create Server Socket			
			ServerSocket server = new ServerSocket(SERVER_PORT);
			
			// Waiting Signal
			while(true) {
				System.out.println("Waiting Client...");
				Socket l_socket = server.accept(); // waiting
				// create Thread and Run
				System.out.println("Someone comes in!!");				
				ConnectionThread l_newClient = new ConnectionThread(l_socket, fClientList);
				l_newClient.start();
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	
	private class ConnectionThread extends Thread{
		Socket         		fSocket;
		ObjectInputStream fBr     		= null;
		String         fClientInfo 	= null;
		
		public ConnectionThread(Socket a_socket, HashMap<String,Object> a_clientList) {
			// Set Object
			fSocket = a_socket;						
			
			// Initial connection
			try {
				fBr 				= new ObjectInputStream(a_socket.getInputStream());
					
			}catch(Exception e) {
				
			}
			
		}
		
		public void run() {
			Aircraft l_ac = null;
			Object obj = null;
			
			try {
				
				while((obj = fBr.readObject()) != null) {
//					Aircraft a = (Aircraft) obj;
					HashMap<Integer, Aircraft> a = (HashMap<Integer, Aircraft>) obj;
					System.out.println("Data : " + a);
					System.out.println("Size : " + a.size());
					
					
				}
				
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
