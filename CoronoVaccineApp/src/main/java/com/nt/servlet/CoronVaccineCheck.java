package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronVaccineCheck extends HttpServlet {
		
	@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// get printWriter obj
			PrintWriter pw = resp.getWriter();
			// set response content type 
			resp.setContentType("text/html");
			// read form data(req parameter values)
			String name =req.getParameter("pname");
			String addrs= req.getParameter("paddrs");
			int age = Integer.parseInt(req.getParameter("page"));
			// b.logic
			if(age < 18)
				pw.println("<h1 style='color:blue;text-align:center'>Mr/Miss. "+name+"<u><b> You are not eligible for Vaccination , Wait some more Days</u></b></h1>");
			else
				pw.println("<h1 style='color:Cyan;text-align:center'>Mr/Miss. "+name+" You are eligible for Vaccination, Make happy</h1>");
			
			//pw.println("<a href='http://localhost:2525/CoronoVaccineApp/Corona_Vaccine.html'><img src='images/images.jpg'></a>");
			pw.println("<a href='Corona_Vaccine.html'><img src='images/images.jpg'></a>");
			
			// close stream
			pw.close();
	}
		
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}
}
