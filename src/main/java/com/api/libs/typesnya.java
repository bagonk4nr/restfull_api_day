/**
 * 
 */
package com.api.libs;

/**
 * @author pangeran.jack@4nr
 *
 */
public class typesnya {

	private static String types="";
	private static String modal="";
	private static String typesDoc="";
	
	public static void setType(String typenya){
		types = typenya;
	}
	
	public static String getType(){
		return types;
	}
	
	public static void setModalID(String modalidnya){
		modal = modalidnya;
	}
	
	public static String getModalID(){
		return modal;
	}
	
	public static void setTypeDoc(String typenyaDoc){
		typesDoc = typenyaDoc;
	}
	
	public static String getTypeDoc(){
		return typesDoc;
	}
}
