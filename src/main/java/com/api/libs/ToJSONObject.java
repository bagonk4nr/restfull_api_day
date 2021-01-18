/**
 * 
 */
package com.api.libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * @author Bagus Anggoro
 *
 */
public class ToJSONObject {
	
	private static String line;
	private static StringBuffer jb;  
	private JSONObject jsonObject;

	
	public ToJSONObject() {
		super();
		line = null;
		jb = new StringBuffer();
		jsonObject = null;
	}
	
	public JSONObject toJSONObject(BufferedReader reader) throws IOException {
		
		while ((line = reader.readLine()) != null)
		      jb.append(line);
		
		jsonObject = new JSONObject(jb.toString());
		return jsonObject;
	}
	
	public JSONObject toJSONObjectDupKey(BufferedReader reader) throws IOException {
		
		while ((line = reader.readLine()) != null)
		      jb.append(line);
		
		jsonObject = new JSONObject(repeatedKeysToArrays(jb.toString()));
		return jsonObject;
	}
	
	
	public static String repeatedKeysToArrays(String jsonIn) throws JSONException 
	{
	    
		// https://stackoverflow.com/questions/24416960/convert-json-object-with-duplicate-keys-to-json-array adamF
		//This assumes that the json is flat
		
		
	    String jsonString = jsonIn.substring(2, jsonIn.length() - 2);

	    JSONObject obj = new JSONObject();
	    for (String values : jsonString.split("\",\"")) {
	        String[] keyValue = values.split("\":\"");
	        String key = keyValue[0];
	        String value = ""; 
	        if (keyValue.length>1) value = keyValue[1];

	        if (!obj.has(key)) {
	            obj.put(key, value);
	        } else {
	            Object Oold = obj.get(key);
	            ArrayList<String> newlist = new ArrayList<String>();

	            //Try to cast as JSONArray. Otherwise, assume it is a String
	            if (Oold.getClass().equals(JSONArray.class)) {
	                JSONArray old = (JSONArray)Oold;
	                //Build replacement value
	                for (int i=0; i<old.length(); i++) {
	                    newlist.add( old.getString(i) );
	                }
	            }
	            else if (Oold.getClass().equals(String.class)) newlist = new ArrayList<String>(Arrays.asList(new String[] {(String)Oold})); 
	            newlist.add(value);

	            JSONArray newarr = new JSONArray( newlist );
	            obj.put(key,newarr);                
	        }
	    }
	    return obj.toString();
	}

}
