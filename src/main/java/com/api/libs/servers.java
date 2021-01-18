/**
 * 
 */
package com.api.libs;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author ramad
 *
 */

public class servers {
	
	
	private static String hostName = "";
	
	public static void setHostname(String hostnames){
		
		hostName = hostnames;
	}

	public static String getHostname(){
		
		return hostName;
	}
}
