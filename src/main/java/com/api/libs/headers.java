/**
 * 
 */
package com.api.libs;

/**
 * @author Bagus Anggoro
 *
 */
public class headers {
	
	protected static String[] headers;

	public static void setHeader(String[] header){
		headers = header;
	}
	
	public static String[] getHeader(){
		return headers;
	}

}
