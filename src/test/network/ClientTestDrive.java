package test.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTestDrive {
	private final String SERVER_IP   = "25.12.56.47";
	private final int	 SERVER_PORT = 5153;
	private final String ID			 = "SJ";
	
	Socket fClinetSocket             = null;
	BufferedReader fBr				 = null;
	PrintWriter    fPw				 = null;
	
	
	public static void main(String[] args) {
		ClientTestDrive myMain = new ClientTestDrive();
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
			fPw = new PrintWriter(new OutputStreamWriter(fClinetSocket.getOutputStream()));
			fBr = new BufferedReader(new InputStreamReader(fClinetSocket.getInputStream()));
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			// Say Hello
			fPw.println(ID);
			fPw.flush();
			
			String typing = null;
			while((typing = keyboard.readLine()) !=null ) {
				fPw.println(typing);
				fPw.flush();
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
