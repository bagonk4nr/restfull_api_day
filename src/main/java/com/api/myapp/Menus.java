package com.api.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.api.cfg.dbtoquery;
import com.api.libs.ToJSONObject;

/**
 * Servlet implementation class Menus
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/menu" })
public class Menus {
	private static final long serialVersionUID = 1L;
	private BufferedReader reader;
	private ToJSONObject toObjectJson;
	private JSONObject jsonObject;
	private Object resAkhir;   
	private dbtoquery dbtoquerys;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menus() {
        super();
        // TODO Auto-generated constructor stub
        reader = null;
        toObjectJson = null;
        jsonObject = null;
        resAkhir = null;
        dbtoquerys = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(Object result, HttpServletResponse response1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response1.getWriter().append(result.toString());
		response1.reset();
		response1.getWriter().flush();
		response1.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public Object doPost(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		reader = request1.getReader();
		toObjectJson = new ToJSONObject();
		jsonObject = toObjectJson.toJSONObject(reader);
		try {
			dbtoquerys = new dbtoquery();
			resAkhir = dbtoquerys.getMenu(jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.reset();
		reader.close();
		request1.getReader().close();
		request1.logout();
		return resAkhir;
	}

}
