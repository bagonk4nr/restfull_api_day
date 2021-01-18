/**
 * 
 */
package com.api.libs;

/**
 * @author Bagus Anggoro
 *
 */
public class findurl {
	private static String urlnya="";
	
	public static void setParamURL(String urls){
		urlnya = urls;
	}
	
	public static String getParamURL(){
		return urlnya;
	}
}
