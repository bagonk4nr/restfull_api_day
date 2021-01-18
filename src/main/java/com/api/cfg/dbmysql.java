/**
 * @author pangeran.jack@4nr
 *
 */
package com.api.cfg;

import java.sql.*;

import org.json.JSONObject;

public class dbmysql {

	private static Connection connect;
	private static dbserver configs;
	private static JSONObject datatxt;

	private static String db;
    private static String USERNAME;
    private static String PASSWORD;
    private static String DRIVER;
    private static String URL;

	public dbmysql(){
		super();
	}

	public static Connection koneksi() throws Exception{
		configs = new dbserver();
		datatxt = new JSONObject(configs.getKoneksi());

		db = datatxt.get("dbname").toString();
		URL = datatxt.get("dburl").toString() + db + "?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
		USERNAME = datatxt.get("user").toString();
		PASSWORD = datatxt.get("password").toString();
		DRIVER = datatxt.get("dbdriver").toString();

		Class.forName(DRIVER);

		connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		return connect;
	}

	public static void close() throws Exception{
		connect.close();
	}


}
