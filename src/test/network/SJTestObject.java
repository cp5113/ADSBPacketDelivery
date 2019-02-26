package test.network;

import java.io.Serializable;

public class SJTestObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name = "SJ";
	private static String age = "33";
	private static final int WOW = 2323;
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public static synchronized String getAge() {
		return age;
	}
	public static synchronized void setAge(String age) {
		SJTestObject.age = age;
	}
	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}
	public static synchronized int getWow() {
		return WOW;
	}
	

}
