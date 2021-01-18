/**
 * 
 */
package com.api.libs;

/**
 * @author ramad
 *
 */
public class users {
	private static String emails="", pass="", autoID = "", nikUsers="", passDetail="", userRoles="";
	
	public static void setEmail(String emailUsers){
		emails = emailUsers;
	}
	
	public static String getEmails(){
		return emails;
	}
	
	public static void setPassword(String passUsers){
		pass = passUsers;
	}
	
	public static String getPass(){
		return pass;
	}
	
	public static void setAutoId(String autoIDs){
		autoID = autoIDs;
	}
	
	public static String getAutoId(){
		return autoID;
	}
	
	public static void setNikKaryawan(String nikUser){
		nikUsers = nikUser;
	}
	
	public static String getNikKaryawan(){
		return nikUsers;
	}
	
	public static void setPassDetail(String passdetail){
		passDetail = passdetail;
	}
	
	public static String getPassDetail(){
		return passDetail;
	}
	
	public static void setUserRolel(String userrole){
		userRoles = userrole;
	}
	
	public static String getUserRole(){
		return userRoles;
	}
	
}
