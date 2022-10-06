package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorurl")
public class ErrorServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter obj
		PrintWriter pw = res.getWriter();
		// set content response type
		res.setContentType("text/html");
		//
		pw.println("<h1 style='color:red;text-align:center'>Internal Problem--> Try again</h1>");
		// close strem
		//pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
