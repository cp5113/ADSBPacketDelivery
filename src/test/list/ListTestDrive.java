package test.list;

import java.util.HashMap;
import java.util.Map;

import elements.Aircraft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;


public class ListTestDrive {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> a = new HashMap<String,String>();
//		ObservableList<String> w = (ObservableList<String>) a;
		ObservableMap<String, String> w = FXCollections.observableMap(a);
		
		a.put("ID", "Property");
		System.out.println(w.get("ID"));
		
	}

}
