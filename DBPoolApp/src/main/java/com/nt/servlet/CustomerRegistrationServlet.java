package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
				private static final String CUSTOMER_INSERT_QUERY="INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter Object
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form data (req param value)
		String name = req.getParameter("cname");
		String addrs = req.getParameter("cadd");
		float billAmt = Float.parseFloat(req.getParameter("billAmt"));
		long mobileNo = Long.parseLong(req.getParameter("mobNo"));
		
		//get Pooled JDBC con object
		try(Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);
				){
				// set values to query param values
			ps.setString(1,name);
			ps.setString(2, addrs);
			ps.setFloat(3, billAmt);
			ps.setLong(4, mobileNo);
			// execute Query
			int result =ps.executeUpdate();
			//process the result
			if(result==1)
					pw.println("<h1 style='color:green>Customer is registered</h1>");
			else
				pw.println("<h1 style='color:green>Customer is not registered</h1>");
		// add hyperlink
			pw.println("<br><br><a href='customer_registeration.html>Home</a>");
		// close stream
			pw.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:green'>Internal Problem-- try again"+se.getMessage()+"</h1>");
			// add hyperlink
			pw.println("<br><br><a href='customer_registeration.html>Home</a>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:green'>Internal Problem-- try again"+e.getMessage()+"</h1>");
			// add hyperlink
			pw.println("<br><br><a href='customer_registeration.html>Home</a>");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
	//helper method
	private Connection getPooledConnection() throws Exception{
		// create initialCOntext object
		InitialContext ic = new InitialContext();
		// get DataSource obj ref through lookup operation
		//DataSource ds =(DataSource)ic.lookup("DsJndi");
		// get Ds Jndi name from servlet Init param
		String jndiName =getServletConfig().getInitParameter("Jndi");
		DataSource ds = (DataSource)ic.lookup(jndiName);
		// get Pooled JDBC connection
		Connection conn = ds.getConnection();
		return conn;
	}
}
