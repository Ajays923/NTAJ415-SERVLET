package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
		ServletConfig cg = getServletConfig();
		pw.println("<br><b>ServletConfig object class Name : "+cg.getClass()+"</b>");
		
		pw.println("<br><b>Servlet name : "+cg.getServletName()+"</b>");
		
		pw.println("<br><b> Db password :: 	"+cg.getInitParameter("dbpwd")+"</b>");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
