/**
 * 
 */
package com.api.libs;

/**
 * @author ramad
 *
 */
public class setgetpo {
	
	private static String kodepo= "", kodeitem="", values="", namecol="";
	
	public static void setKodePO(String kodeponya){
		kodepo = kodeponya;
	}
	public static void setKodeItem(String kodeitemnya){
		kodeitem = kodeitemnya;
	}
	public static void setValue(String valuesnya){
		values = valuesnya;
	}
	public static void setNameCol(String namecolnya){
		namecol = namecolnya;
	}
	
	
	public static String getKodePO(){
		return kodepo;
	}
	public static String getKodeItem(){
		return kodeitem;
	}
	public static String getValue(){
		return values;
	}
	public static String getNameCol(){
		return namecol;
	}

}
