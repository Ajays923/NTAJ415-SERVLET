package com.nt.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstLoginApp extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set content type
		res.setContentType("text/html");
		// get PrintWriter obj
		PrintWriter pw = res.getWriter();
		// set form values
		String uname = req.getParameter("uname");
		String pwd  = req.getParameter("pwd");
		
		if(uname.equals("ajay") && pwd.equals("ajay"))
			pw.println("<h1 style='color:Blue;text-align:center;'>Login Successfully</h1>");
		else
			pw.println("<h1 style='color:Green;text-align:center;'>Incorrect Username and Password</h1>");
		
		pw.println("<a href='LoginApp.html'>home</a>");
		// close stream
		pw.close();
		
	}// doPost(-,-);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req, res);
		/*
		 * // set content type res.setContentType("text/html"); // get PrintWriter obj
		 * PrintWriter pw = res.getWriter(); // set form values String uname =
		 * req.getParameter("uname"); String pwd = req.getParameter("pwd");
		 * 
		 * if(uname.equals("ajay") && pwd.equals("ajay")) pw.
		 * println("<h1 style='color:Blue;text-align:center;'>Login Successfully</h1>");
		 * else pw.
		 * println("<h1 style='color:Green;text-align:center;'>Incorrect Username and Password</h1>"
		 * );
		 * 
		 * pw.println("<a href='LoginApp.html'>home</a>"); // close stream pw.close();
		 */
		
	}// doGet(-,-);
}
