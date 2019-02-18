package test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerTestDrive {
	
	private  final int SERVER_PORT = 5153;
	private HashMap<String, Object> fClientList = new HashMap<String, Object>();
	
	
	
	public static void main(String[] args) {
		
	ServerTestDrive	myMain = new ServerTestDrive();
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
		Socket         fSocket;
		BufferedReader fBr     		= null;
		String         fClientInfo 	= null;
		
		public ConnectionThread(Socket a_socket, HashMap<String,Object> a_clientList) {
			// Set Object
			fSocket = a_socket;						
			
			// Initial connection
			try {
				PrintWriter l_pw 	= new PrintWriter(new OutputStreamWriter(a_socket.getOutputStream()));				
				fBr 				= new BufferedReader(new InputStreamReader(a_socket.getInputStream()));
				fClientInfo			= fBr.readLine();
				a_clientList.put(fClientInfo,l_pw);
				
				System.out.println("=======================");
				System.out.println(fClientInfo + " Connected");
				System.out.println(fSocket.getInetAddress());
				System.out.println(fSocket.getChannel());
				System.out.println(fSocket.getLocalAddress());
				System.out.println(fSocket.getLocalSocketAddress());
				System.out.println(fSocket.getRemoteSocketAddress());
				
				
			}catch(Exception e) {
				
			}
			
		}
		
		public void run() {
			String l_aline = null;
			
			try {
				
				while((l_aline = fBr.readLine()) != null) {
					System.out.println("Data : " + l_aline);
					
					
					
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
