/**
 *
 */
package com.api.cfg;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.api.cfg.dbmysql;
import com.api.libs.findurl;
import com.api.libs.funcs;
import com.api.libs.servers;
import com.api.libs.setgetbarang;
import com.api.libs.setgetcust;
import com.api.libs.setgetdate;
import com.api.libs.setgetpo;
import com.api.libs.typesnya;
import com.api.libs.users;




/**
 * @author pangeranjack.4nr
 *
 */
public class dbtoquery extends dbquery{
	private dbserver configs;
	private String qry, whereparams;
	private PreparedStatement preStatement;
	private ResultSet resultSet;
	private Object resAkhir;
	private List<Map<String, Object>> resAppQuery, resHasil;
	private dbquery dbquerys;

	public dbtoquery() {
		super();
		qry = "";
		whereparams="";


	}

	public void setServer(boolean id, String _users, String _passwords, String _dbdrivers, String _urls, String _dbnames) {

		if(id == false) {
			configs = new dbserver();
			configs.dbserverconfig("", "", "", "", "");
		}else{
			configs = new dbserver();
			configs.dbserverconfig(_users, _passwords, _dbdrivers, _urls, _dbnames);
		}

	}


	private List<Map<String, Object>> qrySelectToApp(String param1, String param2) throws SQLException, Exception {

		whereparams = "type_query = '" + param1 + "' AND nama_query = '" + param2 + "'";

		qry = "SELECT *  FROM app_query_day WHERE " + whereparams + " LIMIT 1;";
		System.out.println(qry);
		preStatement = dbmysql.koneksi().prepareStatement(qry);
		resultSet = preStatement.executeQuery();
		resHasil = funcs.resultSetToArrayList(resultSet);
		dbmysql.close();
		return resHasil;
	}


	public Object findUrls(JSONObject param) throws SQLException, Exception {

		setServer(false, "","","","","");

		findurl.setParamURL(param.get("url").toString());
		resAppQuery = qrySelectToApp("find", "findURL");
		dbquerys = new dbquery();
		dbquerys.dbquerysdata(resAppQuery);
		resAkhir = dbquerys.qrySelectData();
		if (resAkhir.toString().equals("[]")) resAkhir = false;
		return resAkhir;
	}

	public Object getMenu(JSONObject param1) throws SQLException, Exception {
		System.out.println(param1.toString());
		setServer(false, "","","","","");

		resAppQuery = qrySelectToApp("menu", "menu");
		dbquerys = new dbquery();
		dbquerys.dbquerysdata(resAppQuery);
		resAkhir = dbquerys.qrySelectData();
		return resAkhir;
	}

}
