package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyRoutine extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// get PrintWriter obj
			PrintWriter pw = res.getWriter();
			// set content type
			res.setContentType("text/html");
			// Write b.logic
			LocalDateTime ltd = LocalDateTime.now();
			int hour = ltd.getHour();
				
			pw.println("<h1 style='color:pink;text-align:center'>Today Date and Time ::"+new java.util.Date()+"</h1>");
			
			if(hour < 7)
				pw.println("<h1 style='color:red;text-align=center'>Workout Time</h1>");
			else if(hour < 9)
				pw.println("<h1 style='color:red;text-align=center'>Ready</h1>");
			else if(hour < 18)
				pw.println("<h1 style='color:red;text-align=center'>Office Time</h1>");
			else if(hour < 19)
				pw.println("<h1 style='color:red;text-align=center'>Gym Time</h1>");
			else if(hour < 21)
					pw.println("<h1 style='color:red;text-align=center'>Gaming</h1>");
			else
				pw.println("<h1 style='color:red;text-align=center>Sleeping</h1>");
				
		}
}
