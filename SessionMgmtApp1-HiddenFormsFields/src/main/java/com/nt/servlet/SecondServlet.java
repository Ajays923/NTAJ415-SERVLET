package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// get PrintWriter Object
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form1/req1 data
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String address=req.getParameter("haddrs");
		String ms=req.getParameter("hms");
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");
		
		// display form1/req1 data
		pw.println("<h1 style='color:red'>Two form/request data</h1>");
		pw.println("<br><b> form1/req1 data :: "+name+"....."+fname+"......"+address+"......."+ms+"</b>");
		pw.println("<br><b> form2/req2 data :: "+f2val1+"......."+f2val2);
		
		// add home hyperlink
		pw.println("<br><a href='person_details.html'>Home</a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
