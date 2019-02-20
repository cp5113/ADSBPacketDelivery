package test.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class SimpleHTTPRequestTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			try {
				InputStream is = new URL("http://192.168.10.10/aircraftlist.json").openStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

				int adata;
				StringBuilder fulldata = new StringBuilder();

				while((adata=rd.read()) != -1) {
					fulldata.append((char) adata);
				}

				//			JSONParser parser = new JSONParser();
				//			)
				//		
				
				
				System.out.println(fulldata);
				System.out.println("=================================");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
