package com.lti.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.*;

/**	`````````````````````````````````````````````````````````````````````````````````````````````````````
 * Servlet implementation class Addvalue
 */
public class Addvalue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addvalue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String eid = request.getParameter("txtEmpId");
		String ename= request.getParameter("txtEmpName");
		PrintWriter out = response.getWriter();
		out.println(eid+"  "+ename);
		InputStream is=getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties prop=new Properties();
		prop.load(is);
		
		String driver = (String)prop.get("db.driver");
		String url = (String)prop.get("db.url");
		String user = (String)prop.get("db.user");
		String pass = (String)prop.get("db.pass");
		 try {
	            Class.forName("driver");
	            Connection con = DriverManager.getConnection(
	                    "url,user,pass");
	 
	            PreparedStatement ps = con
	                    .prepareStatement("insert into Emp2 values(?,?)");
	 
	            ps.setString(1, eid);
	            ps.setString(2,ename);
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	                out.print("You are successfully registered...");
	 
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
	 
	        out.close();
	  	
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//}

