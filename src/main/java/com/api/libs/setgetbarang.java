/**
 * 
 */
package com.api.libs;

/**
 * @author Bagus Anggoro
 *
 */
public class setgetbarang {
	private static String kodebarang= "", autoid="", values="", namecol="";
	
	public static void setAutoID(String autoidnya){
		autoid = autoidnya;
	}
	public static void setKodeBarang(String kodebarangnya){
		kodebarang = kodebarangnya;
	}
	
	public static void setValue(String valuesnya){
		values = valuesnya;
	}
	public static void setNameCol(String namecolnya){
		namecol = namecolnya;
	}
	
	public static String getValue(){
		return values;
	}
	public static String getNameCol(){
		return namecol;
	}
	
	public static String getAutoID(){
		return autoid;
	}
	public static String getKodeBarang(){
		return kodebarang;
	}
	
}
