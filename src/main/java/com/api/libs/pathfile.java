/**
 * 
 */
package com.api.libs;

/**
 * @author ramad
 *
 */
public class pathfile {
	
	private static String paths="";
	private static String paths1="";
	private static String pathsOCR="";
	
	public static void setPathFile(String pathnya){
		paths = pathnya;
	}
	
	public static String getPathFile(){
		return paths;
	}
	
	public static void setPathFile1(String pathnya1){
		paths1 = pathnya1;
	}
	
	public static String getPathFile1(){
		return paths1;
	}
	
	public static void setPathFileOCR(String pathocr){
		pathsOCR = pathocr;
	}
	
	public static String getPathFileOCR(){
		return pathsOCR;
	}

}
