package test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import jdk.nashorn.internal.parser.JSONParser;

public class SimpleHTTPRequestTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream is = new URL("192.168.10.10/").openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			
			int adata;
			StringBuilder fulldata = new StringBuilder();
			
			while((adata=rd.read()) != -1) {
				fulldata.append((char) adata);
			}

//			JSONParser parser = new JSONParser();
//			)
//			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
