package com.api.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.libs.logApps;
import com.api.myapp.FindUrls;
import com.api.myapp.Menus;

/**
 * Servlet implementation class index
 */

@WebServlet(asyncSupported = true, urlPatterns = { "/" })
public class restfull_api_day extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FindUrls findurls;
	private Menus menu;

	private Object getData;
	private String path, clientOrigin, htmlResponse;
    private final logApps logs = new logApps();

    private PrintWriter writer;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public restfull_api_day() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	public void doGet(Object request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.toString());


		// Set to expire far in the past.
		response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.setHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", clientOrigin);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, observe");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Expose-Headers", "Authorization");
		response.setHeader("Access-Control-Expose-Headers", "WWW-Authenticate");
		response.setHeader("Access-Control-Expose-Headers", "Server-Authorization");
		response.setHeader("Access-Control-Expose-Headers", "responseType");
		response.setHeader("Access-Control-Expose-Headers", "observe");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		response.setHeader("Accept", "application/json, text/plain, */*");

		writer = response.getWriter();
		writer.println(request);

		writer.flush();
		writer.close();

		response.getWriter().flush();
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		clientOrigin = request.getHeader("origin");

		System.out.println("CORSFilter HTTP Request Bagus: " + request.getMethod());

        setAccessControlResponseHeaders(response, clientOrigin);
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		path = "";
		if (req.getServletPath() != null ) { path += req.getServletPath(); }
		else { path += req.getPathInfo(); }
		path = path.replace("null", "");
//		System.out.println("getPath: " + path);
		switch (path) {
			case "/findurl" : {
				findurls = new FindUrls();
				getData = findurls.doPost(req, resp);
				doGet(getData, resp);
			}
			case "/menu" : {
				menu = new Menus();
				System.out.println("Uhuyy ");
				getData = menu.doPost(req, resp);
				System.out.println(getData);
				doGet(getData, resp);
			}
			default : {
				Object datadef = req.getContextPath().toString();
				doGet(datadef, resp);
			}
		}

	    // do something else
	  }

	private void setAccessControlResponseHeaders(HttpServletResponse resp, String clientOrigins) {

		// Set to expire far in the past.
		resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.setHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Access-Control-Allow-Origin", clientOrigins);
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, observe");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Expose-Headers", "Authorization");
		resp.setHeader("Access-Control-Expose-Headers", "WWW-Authenticate");
		resp.setHeader("Access-Control-Expose-Headers", "Server-Authorization");
		resp.setHeader("Access-Control-Expose-Headers", "responseType");
		resp.setHeader("Access-Control-Expose-Headers", "observe");
		resp.setHeader("Content-Type", "text/html");
		resp.setHeader("Accept", "application/json, text/plain, */*");
		// Set to expire far in the past.
		resp.addHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		resp.addHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		resp.addHeader("Pragma", "no-cache");
		resp.addHeader("Access-Control-Allow-Origin", clientOrigins);
        resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.addHeader("Access-Control-Allow-Methods", "GET, POST");
		resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
		resp.addHeader("Access-Control-Max-Age", "3600");
		resp.addHeader("Access-Control-Expose-Headers", "Authorization");
		resp.addHeader("Access-Control-Expose-Headers", "WWW-Authenticate");
		resp.addHeader("Access-Control-Expose-Headers", "Server-Authorization");
		resp.addHeader("Access-Control-Expose-Headers", "responseType");
		resp.addHeader("Access-Control-Expose-Headers", "observe");
		resp.addHeader("Content-Type", "text/html");
		resp.addHeader("Accept", "application/json, text/plain, */*");
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {

		// logs.showLog(index.class, "CORSFilter HTTP Request: " + req.getMethod());
		clientOrigin = req.getHeader("origin");

		setAccessControlResponseHeaders(resp, clientOrigin);

	}



}
