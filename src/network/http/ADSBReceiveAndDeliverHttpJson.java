package network.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import elements.Aircraft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import json.JsonParserSJ;

public class ADSBReceiveAndDeliverHttpJson {

	private static String 										fUrlHttpJson 		= "http://25.12.56.47/aircraftList.json";
	private static boolean										fProcessRun	 		= false;
	private static boolean										fJsonSending 		= false;
	private static double										fReciveRate  		= 1;
	private static Map<String,Aircraft>							fAircraftListMap	= new HashMap<String,Aircraft>();
	private static volatile ADSBReceiveAndDeliverHttpJson 		instance			= new ADSBReceiveAndDeliverHttpJson();
	private static ObjectOutputStream							fJsonSendingStream  = null;
	private static ToggleButton									fDeliverySendingButton;
	private static int											fworkingCount		= 0;
	private TableView<Aircraft> 								fAircraftTableView;
	
	private ADSBReceiveAndDeliverHttpJson() {
	
	}
	
	public static ADSBReceiveAndDeliverHttpJson getInstance() {
		if(instance==null) {
			instance = new ADSBReceiveAndDeliverHttpJson();
		}
		return instance;
	}
	
	public void receiveADSBJson() {
		receiveADSBJson(fUrlHttpJson);		
	}
	
	public void receiveADSBJson(TableView<Aircraft> aAircraftTableView) {
		fAircraftTableView = aAircraftTableView;
		receiveADSBJson(fUrlHttpJson);		
	}
	
	public void receiveADSBJson(TableView<Aircraft> aAircraftTableView, String aUrl) {
		fAircraftTableView = aAircraftTableView;
		fUrlHttpJson	   = aUrl;
		receiveADSBJson(fUrlHttpJson);		
	}
	
	public void receiveADSBJson(TableView<Aircraft> aAircraftTableView,ToggleButton aDeliverySendingButton, String aUrl) {
		fAircraftTableView = aAircraftTableView;
		fUrlHttpJson	   = aUrl;
		fDeliverySendingButton = aDeliverySendingButton;
		receiveADSBJson(fUrlHttpJson);		
	}
	public void receiveADSBJson(String aUrl) {		
		receiveProcess(aUrl);
	}
	
	private void receiveProcess(String aUrl) {
		ReceivingJsonThread newThread = new ReceivingJsonThread(aUrl);
		Thread a = new Thread(newThread);
		a.start();
	}
	

	
	class ReceivingJsonThread implements Runnable{
		private String fUrl;
		public ReceivingJsonThread(String aUrl) {
			fUrl = aUrl;
		}
		@Override
		public void run() {
			try {
				fAircraftListMap.clear();
			}catch(Exception e) {
				System.out.println("ListMap Cleaning is failed");
			}
			fworkingCount = 0;
			while(fProcessRun) {
//				System.out.println("Working..");
				try {
					// Read HTTP for Json
					InputStream is = new URL(fUrl).openStream();
					BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
					
					// Read All Data
					int l_Data = -1;
					StringBuilder l_AllData = new StringBuilder();
					while((l_Data=rd.read()) != -1) {
						l_AllData.append((char) l_Data);					
					}
					rd.close();
					is.close();
					
					// Parsing Json
					Object[] l_dataObject = JsonParserSJ.parsingJsonWithDelaredFieldsInClass(Aircraft.class, l_AllData);
					
					// Converting Object to Aircraft
					Map<String, Aircraft> l_aircraftList = new HashMap<String,Aircraft>();
					for(int i = 0; i<l_dataObject.length;i++) {
						l_aircraftList.put(((Aircraft)l_dataObject[i]).getHex(),(Aircraft)l_dataObject[i]);							
					}
					
					// Cleaning Aircraft List Map
					Iterator<String> l_itorator1 = fAircraftListMap.keySet().iterator();
					while(l_itorator1.hasNext()) {
						String l_key = l_itorator1.next();
						fAircraftListMap.get(l_key).setIsNew(0);
//						if((new Date().getTime() - fAircraftListMap.get(l_key).getDat().getTime())/1000  > 3600*9+10) {
//							fAircraftListMap.remove(l_key);
//						}
					}
					
				
					// Insert into Global Aircraft List Map
					for(String l_loopKey : l_aircraftList.keySet()) {
						if(fAircraftListMap.containsKey(l_loopKey)) {						
							if(fAircraftListMap.get(l_loopKey).getDat().before(l_aircraftList.get(l_loopKey).getDat())) {
								// New trajectory
								fAircraftListMap.put(l_loopKey, l_aircraftList.get(l_loopKey));
								fAircraftListMap.get(l_loopKey).setIsNew(1);
								if(fJsonSending) {
									fJsonSendingStream.writeObject(l_aircraftList.get(l_loopKey));
									fJsonSendingStream.flush();	
//									fJsonSendingStream.reset();
								}
							}else{
								// Old trajectory
							}						
						}else {
							// New trajectory
							fAircraftListMap.put(l_loopKey, l_aircraftList.get(l_loopKey));
							fAircraftListMap.get(l_loopKey).setIsNew(1);
							if(fJsonSending) {
								fJsonSendingStream.writeObject(l_aircraftList.get(l_loopKey));
								fJsonSendingStream.flush();
//								fJsonSendingStream.reset();
							}
						}
					}
					
					if(fJsonSending && fworkingCount%100 == 0) {
						fJsonSendingStream.reset();
					}
					
					
					// Remove Old Trajectory over 10 seconds
					fAircraftListMap.entrySet().removeIf(e ->(new Date().getTime()- e.getValue().getDat().getTime())/1000>3600*9+10);
					
					// Insert AircraftList to Tableviewer
					if(fAircraftTableView!=null) {
						ObservableList<Aircraft> l_aircraftListView =  FXCollections.observableArrayList();
						Iterator<String> l_itorator2 = fAircraftListMap.keySet().iterator();
						while(l_itorator2.hasNext()) {
							l_aircraftListView.add(fAircraftListMap.get(l_itorator2.next()));
						}
						fAircraftTableView.setItems(l_aircraftListView);
						
					}
					
					
					// Sleep
					Thread.sleep((long) (fReciveRate*1000));
				}catch(SocketException e) {
					System.out.println("Socket Lost in Delivery Client");
					fDeliverySendingButton.fire();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					fAircraftListMap.put("000000", new Aircraft(new Date(),"NoData","Check Internet Connection",0,0,0,(short) 0));
					ObservableList<Aircraft> l_aircraftListView =  FXCollections.observableArrayList();
					l_aircraftListView.add(fAircraftListMap.get(0));
					fAircraftTableView.setItems(l_aircraftListView);
				}

			} // while(true) {
			
//			System.out.println("Done!!");
		}
		
	}



	public static synchronized boolean isProcessRun() {
		return fProcessRun;
	}
	
	public static synchronized void setProcessRun(boolean aProcessRun) {
		ADSBReceiveAndDeliverHttpJson.fProcessRun = aProcessRun;
	}
	
	public static synchronized boolean isJsonSending() {
		return fJsonSending;
	}
	
	public static synchronized void setJsonSending(boolean aJsonSending) {
		ADSBReceiveAndDeliverHttpJson.fJsonSending = aJsonSending;
	}
	
	

	public static synchronized ObjectOutputStream getfJsonSendingStream() {
		return fJsonSendingStream;
	}

	public static synchronized void setfJsonSendingStream(ObjectOutputStream aJsonSendingStream) {
		ADSBReceiveAndDeliverHttpJson.fJsonSendingStream = aJsonSendingStream;
	}

	public static synchronized double getReciveRate() {
		return fReciveRate;
	}

	public static synchronized void setReciveRate(double fReciveRate) {
		ADSBReceiveAndDeliverHttpJson.fReciveRate = fReciveRate;
	}

	public static synchronized Map<String, Aircraft> getAircraftListMap() {
		return fAircraftListMap;
	}

	public static synchronized void setAircraftListMap(Map<String, Aircraft> fAircraftListMap) {
		ADSBReceiveAndDeliverHttpJson.fAircraftListMap = fAircraftListMap;
	}
	
//	public static void main(String args[]) {
//		ADSBReceiverHttpJson.getInstance().receiveADSBJson();
//		
//		try {
//			Thread.sleep(10000);
//			
//			ADSBReceiverHttpJson.getInstance().fProcessRun = false;
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
