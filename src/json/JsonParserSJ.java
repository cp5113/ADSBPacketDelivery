package json;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonParserSJ {

	public static Object[] parsingJsonWithDelaredFieldsInClass(Class aClass,StringBuilder aJSONStringBuilder) {
		
		// Parse line by line
		String[] l_aLine = aJSONStringBuilder.toString().split("\\n");
		if(l_aLine.length<1) {
			return null;
		}
		
		// Parse Json line by line
		Object[] objectArray = new Object[l_aLine.length];
		for(int l_loopLine = 0; l_loopLine < l_aLine.length; l_loopLine++) {
			try {
				objectArray[l_loopLine] = parsingJsonWithDelaredFieldsInClass(aClass.getConstructor().newInstance(), l_aLine[l_loopLine]);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for(int l_loopLine = 0; l_loopLine < l_aLine.length; l_loopLine++) {
		
		return objectArray;
	}
	
	public static Object  parsingJsonWithDelaredFieldsInClass(Object aObject, String aJSONStringAnAircraft) {
		// Get Declared Fields
		Field[] l_fields = aObject.getClass().getDeclaredFields();
		
		// Parsing Json with Declared Field Information
		for(int l_loopFields = 0; l_loopFields < l_fields.length;l_loopFields++) {
			// Create Search pattern
			String searchPattern1 = "" + l_fields[l_loopFields].getName()+"";
			String searchPattern2 = ",";
			String searchPattern3 = "}";
			String searchPattern4 = ":";
			
			// Ignore when it doesn't have Class Field
			if(aJSONStringAnAircraft.lastIndexOf(searchPattern1)<0) {
				continue;
			}
			
			// Find Location of Fields
			int l_startIndex1 = aJSONStringAnAircraft.lastIndexOf(searchPattern1) + searchPattern1.length();
			int l_startIndex  = aJSONStringAnAircraft.substring(l_startIndex1, aJSONStringAnAircraft.length()).indexOf(searchPattern4)+l_startIndex1+1;
			
			int l_endIndex1   = aJSONStringAnAircraft.substring(l_startIndex, aJSONStringAnAircraft.length()).indexOf(searchPattern2);
			int l_endIndex2   = aJSONStringAnAircraft.substring(l_startIndex, aJSONStringAnAircraft.length()).indexOf(searchPattern3);
			int l_endIndex    = l_startIndex;
			if(l_endIndex1<=l_endIndex2 && l_endIndex1>0) {
				l_endIndex = l_endIndex1;
			}else {
				l_endIndex = l_endIndex2;
			}
			
			
			// Extract Data
			String l_dataInField = aJSONStringAnAircraft.substring(l_startIndex, l_startIndex+l_endIndex);

			String bakcup = l_dataInField;
			l_dataInField = l_dataInField.replaceAll("\\\\", "");
			l_dataInField = l_dataInField.replaceAll("\"", "");
//			l_dataInField        = l_dataInField.replaceAll("\\", "");
			
//			System.out.print(l_dataInField + ", ");
			setField(aObject, l_fields[l_loopFields].getName(), l_fields[l_loopFields].getType().toString(), l_dataInField);
//			System.out.println(l_fields[l_loopFields].);
			
			
		}// for(int l_loopFields = 0; l_loopFields < l_fields.length;l_loopFields++) {
		
		return aObject;
	}
	
	private static synchronized void setField(Object aObject, String aFieldName, String aFieldType, String aInputData) {
		try {
			
			aObject.getClass().getDeclaredField(aFieldName).setAccessible(true);
			Field field = aObject.getClass().getDeclaredField(aFieldName);
			if(Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
			}
			
			
			if(aFieldType.equalsIgnoreCase("short")) {
				if(aInputData.length()==0) {
					field.set(aObject, Short.parseShort("0"));
				}else {
					field.set(aObject, Short.parseShort(aInputData));
				}								
			}else if(aFieldType.equalsIgnoreCase("int")) {
				if(aInputData.length()==0) {
					field.set(aObject, Integer.parseInt("0"));
				}else {
					field.set(aObject, Integer.parseInt(aInputData));
				}				
			}else if(aFieldType.equalsIgnoreCase("long")) {
				if(aInputData.length()==0) {
					field.set(aObject, Long.parseLong("0"));
				}else {
					field.set(aObject, Long.parseLong(aInputData));
				}				
			}else if(aFieldType.equalsIgnoreCase("double")) {
				if(aInputData.length()==0) {
					field.set(aObject, Double.parseDouble("0"));
				}else {
					field.set(aObject, Double.parseDouble(aInputData));
				}	
			}else if(aFieldType.equalsIgnoreCase("float")) {
				if(aInputData.length()==0) {
					field.set(aObject, Float.parseFloat("0"));
				}else {
					field.set(aObject, Float.parseFloat(aInputData));
				}	
			}else if(aFieldType.equalsIgnoreCase("class java.lang.String")) {
				field.set(aObject, aInputData);
			}else if(aFieldType.equalsIgnoreCase("class java.util.Date")) {

				if (aInputData.contains("-")) {
					SimpleDateFormat l_tempFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date l_tempDate			      = l_tempFormat.parse(aInputData);
					field.set(aObject, l_tempDate);
				} else {
					SimpleDateFormat l_tempFormat = new SimpleDateFormat("HH:mm:ss");
					Date l_tempDate			      = l_tempFormat.parse(aInputData);
					field.set(aObject, l_tempDate);	
				}
			}
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
