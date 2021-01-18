/**
 * 
 */
package com.api.libs;

/**
 * @author pangeran.jack@4nr
 *
 */
public class setgetcust {
	
private static String kodecust= "", autoid="", values="", namecol="";
	
	public static void setAutoID(String autoidnya){
		autoid = autoidnya;
	}
	public static void setKodeCust(String kodecustnya){
		kodecust = kodecustnya;
	}
	public static void setValue(String valuesnya){
		values = valuesnya;
	}
	public static void setNameCol(String namecolnya){
		namecol = namecolnya;
	}
	
	
	
	public static String getAutoID(){
		return autoid;
	}
	public static String getKodeCust(){
		return kodecust;
	}
	public static String getValue(){
		return values;
	}
	public static String getNameCol(){
		return namecol;
	}
}
