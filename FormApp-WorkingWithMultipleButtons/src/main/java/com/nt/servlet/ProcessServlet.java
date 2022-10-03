package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter Object
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// read special request param value(s1)
		String s1val = req.getParameter("s1");
		// read form data (text box value)
		int val1=0, val2=0;
		// read text box value only when request is not coming from hyperlinks
		if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
				val1 = Integer.parseInt(req.getParameter("t1"));
				val2 = Integer.parseInt(req.getParameter("t2"));
		}
		// differentiate logic for submit buttons and hyperlinks
		if(s1val.equalsIgnoreCase("add"))
			pw.println("<h1>Sum of "+val1+" and "+val2+" is ::"+(val1+val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("sub"))
			pw.println("<h1>Sub of "+val1+" and "+val2+" is ::"+(val1-val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("mul"))
			pw.println("<h1>Mul of "+val1+" and "+val2+" is ::"+(val1*val2)+"</h1>");	
		else if(s1val.equalsIgnoreCase("div"))
			pw.println("<h1>Div of "+val1+" and "+val2+" is ::"+((float)val1/val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1>System Properties are </h1>");
			pw.println("b"+System.getProperties()+"</b>");
		}
		else {
			pw.println("<h1>System Date and Time"+LocalDateTime.now()+"</h1>");
		}
		// add home hyperlinks
		pw.println("<a href='form.html'>Home</a>");
		
		// close stream
		pw.close();
		
	}// doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
	
}
