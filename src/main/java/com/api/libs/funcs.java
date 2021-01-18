/**
 * 
 */
package com.api.libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




/**
 * @author pangeran.jack@4nr
 *
 */
public class funcs {
	
	private static JSONArray json, json1;
	private static JSONObject obj, obj1;
	private static ResultSetMetaData rsmd, rsmd1;
	private static int value;
	
	public static String writeResultJSON(ResultSet resultSets) throws JSONException, SQLException, IOException{
		
		json = new JSONArray();
		rsmd = resultSets.getMetaData();
	    int numColumns = rsmd.getColumnCount();

	    while(resultSets.next())             //iterate rows
	    {
	    	
	        obj = new JSONObject();      //extends HashMap
	        for (int i = 1; i <= numColumns; ++i)           //iterate columns
	        {
	            String column_name = rsmd.getColumnName(i);
	            String type = rsmd.getColumnTypeName(i).toString();
//	            System.out.println(column_name + " - " +type + " </br>");
        		if(type.contains("BLOB")) {
        			final Blob myblob = resultSets.getBlob(column_name);
        			if(myblob != null && !myblob.equals(null) && !myblob.toString().isEmpty()) {
	        			InputStream inStream = myblob.getBinaryStream();
	        			String encoded = "";
	        			InputStreamReader inStreamReader = new InputStreamReader(inStream);
	        			BufferedReader reader = new BufferedReader(inStreamReader );
	        			StringBuffer buf = new StringBuffer();
	        			while((encoded = reader.readLine()) != null){
	        				buf.append(encoded);
	        			}
	        		    
	        			obj.put(column_name, buf);
	        			myblob.free();
        			}else continue;
        		}else if(resultSets.getObject(column_name) == null){
	            	obj.put(column_name, "null");
	            }else{
	            	obj.put(column_name, resultSets.getString(column_name));
	            }
        		type = "";
	            column_name = "";
	        }
	        json.put(obj.toString());
	    }
	    
	    return json.toString();
	}
	
	
	public static List<Map<String, Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		int a = 1;
		int count =0;
		while (rs.next()) {
		      // Represent a row in DB. Key: Column name, Value: Column value
		      Map<String, Object> row = new HashMap<String, Object>();
		      
		      for (int i = 1; i <= columnCount; i++) {
		           // Note that the index is 1-based
		           
		    	   String colName = rsmd.getColumnName(i);
		           Object colVal = rs.getObject(i);
		           if(colVal == null)
		        	   row.put(colName, "uyee");
		           else row.put(colName, colVal);
		      }
		      rows.add(row);
		}
		return rows;
	}
	
	
	public static ArrayList<String> writeResultArray(ResultSet resultSets) throws SQLException{
		
		ArrayList<String> rowValues = new ArrayList<String>();
		rsmd = resultSets.getMetaData();
	    int numColumns = rsmd.getColumnCount();
	    String[] columnNames = new String[numColumns];
        for (int idx=1; idx<=numColumns; ++idx) {
            columnNames[idx - 1] = resultSets.getMetaData().getColumnName(idx);
        }
        
        while (resultSets.next()) {
            for (String columnName: columnNames) {
            		String type = resultSets.getObject(columnName).getClass().getTypeName();
            		
            		if(type.contains("BLOB") || type.contains("[B")) {
            			final String s = resultSets.getObject(columnName).toString();
            			final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
            			rowValues.add(Base64.getEncoder().encode(authBytes).toString());
            		}
            		else rowValues.add(resultSets.getObject(columnName).toString());
            	
            }
        }
      
        return rowValues;
	}
	
	public static String[] resultDataList(ResultSet resultSets)throws SQLException{
		
		int ids=0;
		rsmd = resultSets.getMetaData();
	    int numColumns = rsmd.getColumnCount();
	    String[] rowValues = new String[numColumns];
	    String[] columnNames = new String[numColumns];
        for (int idx=1; idx<=numColumns; ++idx) {
            columnNames[idx - 1] = resultSets.getMetaData().getColumnName(idx);
        }
        
        while (resultSets.next()) {
        	
            for (String columnName: columnNames) {
            	
            	rowValues[ids++] = resultSets.getString(columnName);	
            }
        }
        

        return rowValues;
	}

	public static boolean equalsInt(Object obj) {
	    if (obj instanceof Integer) {
	        return value == ((Integer)obj).intValue();
	    }
	    return false;
	}
}
