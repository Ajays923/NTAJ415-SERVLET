// PlainServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class  PlainServlet extends HttpServlet{
	
	static {
		System.out.println("PlainServlet.static block");
	}
	
	public PlainServlet() {
		System.out.println("PlainServlet:0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("PlainServlet.init(ServletConfig cg)");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	// set response content type
	res.setContentType("text/plain");
	// get printWriter Stream
	PrintWriter pw = res.getWriter();
	// write output content to browser
	pw.println("<table border='1' align='center'>");
	pw.println("<tr><th>Player name</th> <th> Medal</th> <th> Category </th></tr>");
	pw.println("<tr><td>Niraj Chopra</td> <td>Gold</td> <td>JawlingThrow</td></tr>");
	pw.println("<tr><td>Meera Bai chanu</td> <td>Silver</td> <td>Weight Lifting</td></tr>");
	pw.println("<tr><td>Ravi kumar dahiya</td> <td>Silver</td> <td>Wrestling</td></tr>");
	pw.println("<tr><td>P.V.Sindhu</td> <td>Brownz</td> <td>Batminton</td></tr>");
	pw.println("<tr><td>Lovlina</td> <td>Bronze</td> <td>Boxing</td></tr>");
	pw.println("<tr><td>Hocky</td> <td>Bronze</td> <td>Mens Hokey</td></tr>");
	pw.println("<tr><td>Bajarang</td> <td>Bronze</td> <td>Wresling</td></tr>");
	pw.println("</table>");
	//close stream
	pw.close();
	
	}// service(-,-)
}// class
