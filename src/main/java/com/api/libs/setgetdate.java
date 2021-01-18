/**
 * 
 */
package com.api.libs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author ramad
 *
 */
public class setgetdate {
	
	private static String datefrom = "";
	private static String dateto = "";
	private static DateFormat dateFormat;
	private static Calendar cal;
	private static String dateNow="";
	private static String yearnya="";
	private static String monthnya="";
	private static String monthPrintednya="";
	
	public static void setDateFrom(String datefroms){
		if(datefroms.matches("1970-01-01")) datefrom = giveDateNow();
		else datefrom = datefroms;
	}
	public static void setDateTo(String datetos){
		if(datetos.matches("1970-01-01")) dateto = giveDateNow();
		else dateto = datetos;
	}
	
	public static String getDateFrom(){
		return datefrom;
	}
	public static String getDateTo(){
		return dateto;
	}
	
	public static String giveDateNow(){
		dateFormat = new SimpleDateFormat("YYYY-MM-dd",Locale.getDefault());
		cal = Calendar.getInstance();
//		now = new Date();
		dateNow = dateFormat.format(cal.getTime()).toString();
		System.out.println(cal);
		return dateNow;
	}
	
	public static String giveDateNowReport(){
		dateFormat = new SimpleDateFormat("YYYY-MM-dd",Locale.getDefault());
		cal = Calendar.getInstance();
//		now = new Date();
		dateNow = dateFormat.format(cal.getTime()).toString();
		System.out.println(cal);
		return dateNow;
	}
	
	public static void setYear(String years) {
		yearnya = years;
	}
	
	public static String getYear() {
		return yearnya;
	}
	
	public static void setMonth(String months) {
		monthnya = months;
	}
	
	public static String getMonth() {
		return monthnya;
	}
	
	public static void setMonthPrinted(String monthprinted) {
		monthPrintednya = monthprinted;
	}
	
	public static String getMonthPrinted() {
		return monthPrintednya;
	}
}
