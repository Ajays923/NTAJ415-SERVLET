// WordServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class  WordServlet extends HttpServlet{
	
	static {
		System.out.println("WordServlet.static block");
	}
	
	public WordServlet() {
		System.out.println("WordServlet:0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("WordServlet.init(ServletConfig cg)");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	// sert response content type
	res.setContentType("application/msword");
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
