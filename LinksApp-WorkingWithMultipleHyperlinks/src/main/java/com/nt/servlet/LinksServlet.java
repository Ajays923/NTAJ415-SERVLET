package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Get PrintWriter Object
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// read additional req param value(p1)
		String pval = req.getParameter("p1");
		// get All Available Locale
		Locale locales[] = Locale.getAvailableLocales();
		//Differentiate logics for hyperlinks
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1> All Languages Are :: </h1>");
			for(Locale l : locales)
				pw.println(l.getDisplayLanguage()+" ");
		}
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All Countries are :: </h1>");
			for(Locale l:locales)
				pw.println(l.getDisplayCountry()+" ");
		}
		else {
			pw.println("<h1> System Date and Time :: "+LocalDateTime.now()+"</h1>");
		}
		// add home hyperlink
		pw.println("<a href='Links.html'>Home</a>");
		
		// close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}// doPost(-,-)
