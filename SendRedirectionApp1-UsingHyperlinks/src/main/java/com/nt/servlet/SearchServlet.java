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
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>Click here to Search In goolge search engine</a>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>Click here to Search In bing search engine</a>");
		else
			pw.println("<h1 style='color:blue;text-align:center'><a href='https://in.search.yahoo.com/search?p="+ss+"'>Click here to Search In Yahoo search engine</a>");
		
		// close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}