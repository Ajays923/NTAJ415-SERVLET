package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyFoodRoutine extends HttpServlet {
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter obj
					PrintWriter pw = res.getWriter();
					// set content type
					res.setContentType("text/html");
					// Write b.logic
					LocalDateTime ltd = LocalDateTime.now();
					int hour = ltd.getHour();
						
					pw.println("<h1 style='color:pink;text-align:center;background-color:blue;'>Today Date and Time ::"+new java.util.Date()+"</h1>");
					
					if(hour < 7 && hour < 8)
						pw.println("<h1 style='color:red;text-align=center'>Tea Time</h1>");
					else if(hour < 10 && hour <= 11)
						pw.println("<h1 style='color:orange;text-align=center'>BreakFast Time</h1>");
					else if(hour < 12 || hour <= 14)
						pw.println("<h1 style='color:pink;text-align=center'>Lunch Time</h1>");
					else if(hour < 15 || hour <=16)
						pw.println("<h1 style='color:pink;text-align=center'>Study Time</h1>");
					else if(hour < 17 || hour <=19)
						pw.println("<h1 style='color:yellow;text-align=center'>Snack Time</h1>");
					else if(hour < 20 || hour<22)
							pw.println("<h1 style='black:red;text-align=center'>Dinner Time</h1>");
					else
						pw.println("<h1 style='color:pink;text-align=center>Sleeping</h1>");
	}
}
