package test.network;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;

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
			fPw = new ObjectOutputStream(new BufferedOutputStream(fClinetSocket.getOutputStream()));
			BufferedReader response = new BufferedReader(new InputStreamReader(fClinetSocket.getInputStream()));
			
//			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//			String typing = null;
			System.out.println("WOW");

			int c = 0;
			while(true) {
//			while((typing = keyboard.readLine()) !=null ) {
//				if(typing.equalsIgnoreCase("1")) {
					System.out.println(c);
//					int[] a = {1,2,3};
//					fPw.writeObject(a);
//					fPw.writeObject(new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));
//					Thread.sleep(300);
					
					
					HashMap<Integer, Aircraft> aa= new HashMap<Integer, Aircraft>();
					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));

					aa.put(c++,new Aircraft(new Date(),"Initial","Initial",c,c,c,(short) 0));
					fPw.writeObject(aa);
					fPw.flush();
					fPw.reset();
					
					
					// read
					System.out.println(response.readLine());
					
					//					fPw.reset();
					c++;
					if (c%10==0) {
//						Thread.sleep(3000);

					}
					
//				}
//			}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
