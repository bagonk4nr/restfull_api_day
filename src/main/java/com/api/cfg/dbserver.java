/**
 * 
 */
package com.api.cfg;

import org.json.JSONObject;

/**
 * @author Bagus Anggoro
 *
 */
public class dbserver {
	
	private static String _user;
	private static String _password;
	private static String _dbname;
	private static String _dbconfig;
	private static String _dbdriver;
	private static String _url;
	
	public dbserver() {
		super();
	}
	
	public void dbserverconfig(String _users, String _passwords, String _dbdrivers, String _urls, String _dbnames) {
		
		if(_users.isEmpty() && _passwords.isEmpty() && _dbdrivers.isEmpty() && _urls.isEmpty()) {
			
			_user = "root";
			_password = "123456789";
			_dbdriver = "com.mysql.cj.jdbc.Driver";
			_url = "jdbc:mysql://localhost:3306/";
			
			
		}else {
			
			_user = _users;
			_password = _passwords;
			_dbdriver = _dbdrivers;
			_url = _urls;
			
		}
		
		if(!_dbnames.isEmpty()) _dbname = _dbnames;
		else _dbname = "myapp_admin";
		
		
	}
	
	public String getKoneksi() {
		
		_dbconfig = "{'user': '" + _user + "', 'password': '" + _password + "', 'dbname': '" + _dbname + "', 'dbdriver': '" + _dbdriver + "', 'dburl': '" + _url +"'}";
		
		return  _dbconfig;
	}



	

}
