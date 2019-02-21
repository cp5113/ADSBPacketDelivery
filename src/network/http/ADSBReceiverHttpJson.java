package network.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import elements.Aircraft;
import json.JsonParserSJ;

public class ADSBReceiverHttpJson {

	private final String 	fUrlHttpJson 					= "http://192.168.10.10/aircraftlist.json";
	private static boolean	fProcessRun	 					= true;
	private static double	fReciveRate  					= 1;
	private static volatile ADSBReceiverHttpJson instance	= new ADSBReceiverHttpJson();
	
	private ADSBReceiverHttpJson() {
	
	}
	
	public static ADSBReceiverHttpJson getInstance() {
		if(instance==null) {
			instance = new ADSBReceiverHttpJson();
		}
		return instance;
	}
	
	public static Object receiveADSBJson() {
		return null;
		
	}
	public static Object receiveADSBJson(String aUrl) {
		return null;
		
	}
	
	private static Object receiveProcess(String aUrl) {
		
		while(fProcessRun) {
			try {
				// Read HTTP for Json
				InputStream is = new URL(aUrl).openStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				
				// Read All Data
				int l_Data = -1;
				StringBuilder l_AllData = null;
				while((l_Data=rd.read()) != -1) {
					l_AllData.append((char) l_Data);					
				}
				
				// Parsing Json
				Aircraft[] aircraftArray = (Aircraft[])JsonParserSJ.parsingJsonWithDelaredFieldsInClass(Aircraft.class, l_AllData);
				
				
				
				// Sleep
				Thread.sleep((long) (fReciveRate*1000));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		} // while(true) {
		
		return null;
				
	}
	
	
}
