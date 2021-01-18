/**
 *
 */
package com.api.cfg;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.api.libs.*;
import org.json.JSONArray;


import com.api.cfg.dbmysql;

/**
 * @author pangeran.jack@4nr
 *
 */
public class dbquery extends dbmysql{
	private String[] _table, _query1;
	private String[] _whereparams, _joinparams;
	private String[] _header, _keys, _pathfile;
	private String _querys, _query2, _groupby, _orderby, _passdetail;
	private String _typeresults,_pathfileocr;
	private String _qry, _whereParams, _jenis_query;
	private dbmysql objMySql;
	private PreparedStatement preStatement;
	private String _typeqry, _namaqry;
	private ResultSet resultSet;
	private List<Map<String, Object>> resHasil1;
	private Object resHasil;
	private int resultNya;


	public dbquery() {
		super();
		objMySql = new dbmysql();
		resultSet = null;
		resHasil =null;

	}

	public void dbquerysdata(List<Map<String, Object>> querynya) {


		System.out.println(querynya.get(0).get("jenis_query").toString());
		if(querynya.get(0).get("jenis_query").toString().contains("sp")) {


				_query1 = querynya.get(0).get("query1").toString().split("@");

				if(!querynya.get(0).get("typeresults").equals("uyee") && querynya.get(0).get("typeresults") != "uyee")
					_typeresults = querynya.get(0).get("typeresults").toString();

				if(!querynya.get(0).get("pathFile").equals("uyee") && querynya.get(0).get("pathFile") != "uyee") {
					_pathfile = querynya.get(0).get("pathFile").toString().split(", ");
					if(_pathfile.length > 1) {
					pathfile.setPathFile(_pathfile[0]);
					pathfile.setPathFile1(_pathfile[1]);
					}
				}

				if(!querynya.get(0).get("passworduser").equals("uyee") && querynya.get(0).get("passworduser") != "uyee")
					_passdetail = querynya.get(0).get("passworduser").toString();


		}else {
			_querys = querynya.get(0).get("querys").toString();

			if(!querynya.get(0).get("query1").equals("uyee") && querynya.get(0).get("query1") != "uyee")
				_query1 = querynya.get(0).get("query1").toString().split("@");


			if(!querynya.get(0).get("query2").equals("uyee") && querynya.get(0).get("query2") != "uyee")
				_query2 = querynya.get(0).get("query2").toString();

			if(!querynya.get(0).get("tables").equals("uyee") && querynya.get(0).get("tables") != "uyee")
				_table = querynya.get(0).get("tables").toString().split(", ");

			if(!querynya.get(0).get("whereParams").equals("uyee") && querynya.get(0).get("whereParams") != "uyee")
				_whereparams = querynya.get(0).get("whereParams").toString().split("@");


			if(!querynya.get(0).get("joinParams").equals("uyee") && querynya.get(0).get("joinParams") != "uyee")
				_joinparams = querynya.get(0).get("joinParams").toString().split(",");

			if(!querynya.get(0).get("groupByParams").equals("uyee") && querynya.get(0).get("groupByParams") != "uyee")
				_groupby = querynya.get(0).get("groupByParams").toString();
			else _groupby ="";

			if(!querynya.get(0).get("orderByParams").equals("uyee") && querynya.get(0).get("orderByParams") != "uyee")
				_orderby = querynya.get(0).get("orderByParams").toString();
			else _orderby ="";

			if(!querynya.get(0).get("pathocr").equals("uyee") && querynya.get(0).get("pathocr") != "uyee") {
				_pathfileocr = querynya.get(0).get("pathocr").toString();
				pathfile.setPathFileOCR(_pathfileocr);
			}

			if(!querynya.get(0).get("pathFile").equals("uyee") && querynya.get(0).get("pathFile") != "uyee") {
				_pathfile = querynya.get(0).get("pathFile").toString().split(", ");
				if(_pathfile.length > 1) {
				pathfile.setPathFile(_pathfile[0]);
				pathfile.setPathFile1(_pathfile[1]);
				}
			}

			if(!querynya.get(0).get("headers").equals("uyee") && querynya.get(0).get("headers") != "uyee") {
				_header = querynya.get(0).get("headers").toString().split("@");
				headers.setHeader(_header);
			}

			if(!querynya.get(0).get("keys").equals("uyee") && querynya.get(0).get("keys") != "uyee") {
				_keys = querynya.get(0).get("keys").toString().split("@");
				keys.setKey(_keys);
			}

			if(!querynya.get(0).get("typeresults").equals("uyee") && querynya.get(0).get("typeresults") != "uyee")
				_typeresults = querynya.get(0).get("typeresults").toString();

			if(!querynya.get(0).get("type_query").equals("uyee") && querynya.get(0).get("type_query") != "uyee")
				_typeqry = querynya.get(0).get("type_query").toString();

			if(!querynya.get(0).get("nama_query").equals("uyee") && querynya.get(0).get("nama_query") != "uyee")
				_namaqry = querynya.get(0).get("nama_query").toString();

			if( !_whereparams[0].matches("uyee") && _whereparams[0] != "uyee" && !_whereparams[0].isEmpty()) {
				if(_typeqry.matches("find")){
					_whereParams =  _whereparams[0] + " = '" + findurl.getParamURL() + "' " ;

				}else _whereParams = "";
			}else _whereParams = "";
		}

	}

	public Object qrySelectDataFromSP() throws SQLException, Exception{

		if(!users.getNikKaryawan().isEmpty()) {

			_qry =  _query1[0] + "'" + users.getNikKaryawan() + "'" +  _query1[1] + "'" +  setgetdate.getMonth() + "'" +  _query1[2] + "'" +  setgetdate.getYear() + "'" +  _query1[3];

		}else {
			if(_passdetail.matches(users.getPassDetail().toString()) || users.getPassDetail().toString() == "null" || users.getPassDetail().toString().equals("null"))
			_qry =  _query1[0] + "'" + users.getPassDetail() + "', '" + users.getUserRole() + "'" +  _query1[1];

		}

		return toDB(_qry, _typeresults);
	}

	public Object qrySelectData() throws SQLException, Exception{
		_qry =  _querys + _table[0].toString();

		for(int i=1; i < _table.length; i++){

			_qry += _query1[0].toString() + _table[i].toString()  + _query1[1]  +  _joinparams[ i - 1] + _query1[2].toString();

		}

		_qry += _whereParams;
	    _qry += _groupby;
		_qry += _orderby;
		_qry +=  " ;";

		return toDB(_qry, _typeresults);
	}

	public Object qryUpdateData() throws SQLException, Exception{
		if(typesnya.getType().matches("po")){
			_qry = _querys + _table[0].toString()
					+ _query1[0].toString() + setgetpo.getNameCol() + " = '" + setgetpo.getValue() + "' " +
					_whereParams ;
		}else if(typesnya.getType().matches("cust")){

			_qry = _querys + _table[0].toString()
					+ _query1[0].toString() + setgetcust.getNameCol() + " = '" + setgetcust.getValue() + "' " +
					_whereParams ;
		}else if(typesnya.getType().matches("barang")){

			_qry = _querys + _table[0].toString()
					+ _query1[0].toString() + setgetbarang.getNameCol() + " = '" + setgetbarang.getValue() + "' " +
					_whereParams ;
		}

		_qry +=  " ;";
		System.out.println(_qry);
//		System.exit(0);
		return toDB(_qry, "2");
	}

	public Object qryInsertData(String tables, String paramstablesnya, String params) throws SQLException, Exception{
		_qry = "INSERT INTO " + tables + " " + paramstablesnya + " VALUES " + params ;
//		System.out.println(_qry);
//		System.exit(0);
		return toDB(_qry, "3");
	}

	private Object toDB(String qrys, String typeRes) throws SQLException, Exception {
		System.out.println(qrys);
		System.out.println(typeRes);
//		System.exit(0);
		preStatement = dbmysql.koneksi().prepareStatement(qrys);

		if(typeRes.matches("3")) {
			resultNya = preStatement.executeUpdate();
			if(resultNya == 1)resHasil = " Berhasil !!!";
			else resHasil = " Tidak Berhasil !!!";
			dbmysql.close();
		}else if(typeRes.matches("0")) {

			resultSet = preStatement.executeQuery();
			resHasil = funcs.writeResultJSON(resultSet);
			dbmysql.close();
		}else if(typeRes.matches("2")){
			resultNya = preStatement.executeUpdate();
			if(resultNya == 1)resHasil = " Berhasil !!!";
			else resHasil = " Tidak Berhasil !!!";
			dbmysql.close();
		}

		return resHasil;
	}
}
