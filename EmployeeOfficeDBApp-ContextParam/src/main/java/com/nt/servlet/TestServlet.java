package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter obj
		PrintWriter pw = res.getWriter();
		
		// get Servlet config obj
		ServletContext sc= getServletContext();
		pw.println("<br><b> Server name : "+sc.getServerInfo()+"</b>");
		pw.println("<br><b> Servlet version : "+sc.getMajorVersion()+"<b>");
		pw.println("<br><b> MIME type of version : "+sc.getMajorVersion()+"<b>");
		
		// get Servlet config object
		ServletConfig cg = getServletConfig();
		pw.println("<br><b>ServletConfig object class Name : "+cg.getClass()+"</b>");
		pw.println("<br><b>Servlet name : "+cg.getServletName()+"</b>");
		pw.println("<br><b>DB password :: "+cg.getInitParameter("dbpwd")+"</b>");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
