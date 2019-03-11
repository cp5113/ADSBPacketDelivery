package network.http;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import elements.Aircraft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class AircraftReceiverServer implements Runnable{
	private static int 								SERVER_PORT				= 5152;	
	private static volatile AircraftReceiverServer	instance				= new AircraftReceiverServer();
	private static volatile boolean					isRunning				= false;
	private static volatile ServerSocket			serverSocket			;
	private static Object 							lockSignal				= new Object();
	private static ArrayList<ObjectInputStream>		objectInputStreamList   = new ArrayList<ObjectInputStream>();
	private static TableView<Aircraft> 				aircraftTableView		;
	private static SimpleDateFormat					simpleDateFormat		= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static synchronized	AircraftReceiverServer getInstance() {
		if(instance!=null) {
			instance = new AircraftReceiverServer();
		}
		return instance;
	}

	@Override
	public void run() {
		
		runAircraftReceiverServer();
	}
	
	public static void closeServerSocket() {
		synchronized(lockSignal) {
			try {
				serverSocket.close();
				for(int i = 0; i < objectInputStreamList.size(); i++) {
					objectInputStreamList.get(i).close();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void runAircraftReceiverServer() {
		
		try {
			
			//Create Server Socket			
			serverSocket = new ServerSocket(SERVER_PORT);
			
			// Waiting Signal
			while(isRunning) {
				System.out.println("Waiting Client in Port : " + SERVER_PORT);
				try {
					Socket l_socket = serverSocket.accept(); // waiting

					synchronized (lockSignal) {
						System.out.println("Synchronized Closed");
						if(!isRunning) {
							serverSocket.close();
						}
					}


					// create Thread and Run
					System.out.println("Connected with : " + l_socket.getInetAddress());				
					ConnectionThread l_newClient = new ConnectionThread(l_socket,aircraftTableView);
					Thread 			 l_newThread = new Thread(l_newClient);
					l_newThread.start();
				} catch(SocketException e) {
					System.out.println("Socket Exception in runAircraftReceiverServer");
				}
				
			}
			
			System.out.println("Server is closed");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	class ConnectionThread implements Runnable{
		Socket         						fSocket;
		BufferedInputStream					fJsonBufferedInputStream;
		ObjectInputStream 					fJsonInputStream;
		TableView<Aircraft> 				fAircraftTableViewInThread;
		HashMap<String, Aircraft> 			fAircraftReceiveMap = new HashMap<String,Aircraft>();
		public ConnectionThread(Socket a_socket,TableView<Aircraft> aAircraftTableViewInThread){
			// Set Object
			fSocket = a_socket;						
			fAircraftTableViewInThread = aAircraftTableViewInThread;
			// Initial connection
			try {
				fJsonBufferedInputStream = new BufferedInputStream(fSocket.getInputStream());
				fJsonInputStream         = new ObjectInputStream(fJsonBufferedInputStream);
				objectInputStreamList.add(fJsonInputStream);
			}catch(Exception e) {
				
			}
			
		}
		
		public void run() {
			
			Aircraft l_anAircraft = null;
			System.out.println("Running...");
				try {
					while((l_anAircraft = (Aircraft) fJsonInputStream.readObject()) != null) {
						System.out.println("Current Time : " + simpleDateFormat.format(new Date()));
						System.out.println("Aircraft     : " + l_anAircraft.toString());
						System.out.println("Time Gap     : " + ((new Date().getTime() - l_anAircraft.getDat().getTime())/1000-(long)(3600*9)));
						// Receive Aircraft						
//						System.out.println("Data : " + l_anAircraft);
						fAircraftReceiveMap.put(l_anAircraft.getHex(), l_anAircraft);
						
						// Cleaning 10 seconds
						fAircraftReceiveMap.entrySet().removeIf(e ->(new Date().getTime()- e.getValue().getDat().getTime())/1000>3600*9+100);
						
						
						// For Display in TableView
						ObservableList<Aircraft> l_aircraftListView =  FXCollections.observableArrayList();
						Iterator<String> l_itorator2 = fAircraftReceiveMap.keySet().iterator();
						while(l_itorator2.hasNext()) {
							Aircraft l_inListAC = fAircraftReceiveMap.get(l_itorator2.next());
							if(!l_inListAC.equals(l_anAircraft)) {
								l_inListAC.setIsNew(0);
							}
								
							l_aircraftListView.add(l_inListAC);
						}						
						
						fAircraftTableViewInThread.setItems(l_aircraftListView);
						Thread.sleep(10);
					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					try {
						fJsonInputStream.close();
						fSocket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					e.printStackTrace();
					System.out.println("Json Input Stream of Connection Thread in Server is closed");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		}
		
		
	}

	public static synchronized boolean isRunning() {
		return isRunning;
	}

	public static synchronized void setRunning(boolean isRunning) {
		AircraftReceiverServer.isRunning = isRunning;
	}

	public static void setPort(int parseInt) {
		// TODO Auto-generated method stub
		SERVER_PORT = parseInt;
	}

	public static void setTableView(TableView<Aircraft> aAircraftTableView) {
		// TODO Auto-generated method stub
		aircraftTableView = aAircraftTableView;
	}
	
	

}

