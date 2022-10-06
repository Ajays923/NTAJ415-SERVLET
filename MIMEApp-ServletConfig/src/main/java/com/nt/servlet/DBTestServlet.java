package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DBTestServlet extends HttpServlet {
		
		static {
			System.out.println("DBTestServlet.static block");
		}
		
		public DBTestServlet() {
			System.out.println("DBTestServlet:0-param constructor");
		}
		
		
		@Override
		public void init() throws ServletException {
				System.out.println("DBTestServlet.init()");
				ServletConfig config =getServletConfig();
				System.out.println("Driver Class Name: "+config.getInitParameter("driverName"  ));
				System.out.println("Url : "+config.getInitParameter("url"));
		}
		
		  @Override 
		  public void init(ServletConfig config) throws ServletException {
			  System.out.println("DBTestServlet.init(ServletConfig cg)");
			  
			  // read init param values from ServletConfig obj
			  System.out.println("Driver Class Name: "+config.getInitParameter("driverName"));
			  System.out.println("Url : "+config.getInitParameter("url"));
			  System.out.println("db user : "+config.getInitParameter("dbuser"));
			  System.out.println("db password : "+config.getInitParameter("dbpwd"));
			  
			  // write jdbc code here .. using jdbc properties available in ServletConfig }
			  
			  }
			 

		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

			ServletConfig config =getServletConfig();	
			System.out.println("Driver Class Name: "+config.getInitParameter("driverName"  ));
			 System.out.println("Url : "+config.getInitParameter("url"));
			// generate printWriter obj
			PrintWriter pw = res.getWriter();
			// set content type
			res.setContentType("text/html");
			// get System Date  and time 
			pw.println("<h1 style='color:red;text-align:center'>Date and Time :: "+new java.util.Date()+" </h1>");
			System.out.println("LcTestServlet.service(req,res)");
			// close container
			pw.close();
		}
	
		
		@Override
		public void destroy() {
			System.out.println("DBTestServlet.destroy()");
		}
}
