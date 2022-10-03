package com.nt.country;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get PrintWriter obj
		PrintWriter pw = resp.getWriter();
		// set response content type
		resp.setContentType("text/html");
		// read country data 
		int country = Integer.parseInt(req.getParameter("country"));
		// get capital and country name
		String capital[] = new String[] {"New Delhi","Islmabad","Washington DC","Beijing"};
		String countries[] = new String[] {"India","Pakistan","USA","China"};
		pw.println("<h1 style='color:red;text-align:center'>Capital Name of Country "+ countries[country]+" is :: <u><b style='color:Blue'> "+capital[country]+"</b></u></h1>");
		//add home hyperlink
		pw.println("<a href='page.html'>Home</a>");
		// close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
