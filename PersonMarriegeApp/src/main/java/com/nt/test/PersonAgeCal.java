package com.nt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonAgeCal extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set content type
		resp.setContentType("text/html");
		//create PrintWriter obj
		PrintWriter pw = resp.getWriter();
		//read form data
		String pname = req.getParameter("pname");
		int pAge = Integer.parseInt(req.getParameter("page"));
		
		String radio = req.getParameter("Gender");
	    
		if(pAge > 18 || pAge > 21)
			pw.println("<h1 style='color:Green;text-align:center'>Mr/Miss. "+pname+" <u><b>You are eligible for marriege, Happily you can go..</u></b></h1>");
		else 
			pw.println("<h1 style='color:Green;text-align:center'>Mr/Miss. "+pname+" <u><b>You are not eligible marriege, Why are you botherd about marriege..</u></b></h1>");
		
		pw.println("<a href='PersonAge.html'>Back To Home Page</a>");
	}
	
}
