package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
			String tage = req.getParameter("page");
			String csvStatus = req.getParameter("vflag");
			System.out.println(name+" "+addrs+" "+tage+" "+csvStatus);
			int age= Integer.parseInt(tage);
			if(csvStatus.equals("no")) {
			//form validation logics (server side)
			System.out.println("Server Side validations..");
			List<String> errorList = new ArrayList();
			if(name==null || name.length()==0 || name.equalsIgnoreCase("")) // Person rules on name
				errorList.add("Person name is required");
			
			if(addrs==null || addrs.length()==0 || addrs.equalsIgnoreCase("")) // Person rules on addrs
				errorList.add("Person addrs is required");
			else if(addrs.length() < 10) // minimum length of addrs
				errorList.add("Person Addrs must have take min 10 char");
			/*
			 * else if(addrs.equals(addrs))
			 * errorList.add("Person addrs must have character Not Number");
			 */
			
			if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(""))
				errorList.add("Person age is required");
			else {
				try {
					age = Integer.parseInt(tage);
					if(age <= 0 || age > 125)
						errorList.add("Person Age must be range between 1 to 125"); // age range rule
				}
				catch (NumberFormatException nfe) {
					errorList.add("Age should be Numberic value"); // age should be numberic
				}
			}//else
			if(errorList.size()>0) {
				pw.println("<ul style='color:red'");
			for(String errMsg : errorList)
				pw.println("<li>"+errMsg+"</li>");
			pw.println("</ul>");
			return ; // block control going further execution
			}
		}
			//int age = Integer.parseInt(tage); 
			// b.logic
			if(age < 18)
				pw.println("<h1 style='color:Green;text-align:center'>Mr/Miss. <b>"+name+"</b><u><b> You are not eligible for Vaccination , Wait some more Days</u></b></h1>");
			else
				pw.println("<h1 style='color:Green;text-align:center'>Mr/Miss. "+name+" You are eligible for Vaccination, Make happy</h1>");
			
			//pw.println("<a href='http://localhost:2525/CoronoVaccineApp/Corona_Vaccine.html'><img src='images/images.jpg'></a>");
			pw.println("<a href='welcomeurl'><img src='images/images.jpg'></a>");
			
			// close stream
			pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
