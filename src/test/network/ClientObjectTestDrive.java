package test.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import elements.Aircraft;

public class ClientObjectTestDrive {
	private final String SERVER_IP   = "25.12.56.47";
	private final int	 SERVER_PORT = 5153;
	private final String ID			 = "SJ";
	
	Socket fClinetSocket             = null;
	ObjectOutputStream    fPw				 = null;
	
	
	public static void main(String[] args) {
		ClientObjectTestDrive myMain = new ClientObjectTestDrive();
		myMain.doStart();
		
	}
	
	private void doStart() {
		connetToServer();
	}
	
	private void connetToServer() {
		// Create Socket
		try {
			
			// Connect
			fClinetSocket = new Socket(SERVER_IP, SERVER_PORT);
			
			// Stream
			fPw = new ObjectOutputStream(fClinetSocket.getOutputStream());
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String typing = null;
			while((typing = keyboard.readLine()) !=null ) {
				if(typing.equalsIgnoreCase("1")) {
					System.out.println("WOW");
//					int[] a = {1,2,3};
//					fPw.writeObject(a);
					fPw.writeObject(new Aircraft(new Date(),"Initial","Initial",0,0,0,(short) 0));
					fPw.flush();

				}
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
