package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter Object
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form data
		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");
		
		// send hyperlinks to browser having url to complete sendRedirection
		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else
			url="https://in.search.yahoo.com/search?p="+ss;		
		
		System.out.println("before res.sendRedirect(-)");
		pw.println("<b>hello</b>");
		res.sendRedirect(url);
		System.out.println("after res.sendRedirect(-)");
		pw.println("<b>hii</b>");
		// close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
