package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet{
		private static final String GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,MGR,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// get PrintWriter object
			PrintWriter pw = res.getWriter();
			//set content type
			res.setContentType("text/html");
			//get access to ServletContext obj
				ServletContext cg = getServletContext();
			System.out.println("EmployeeSearchServlet: ServletConfig object : "+cg.hashCode());
			//System.out.println("EmployeeSearchServlet:: Servlet object");
			//read servlet init param values
			String driver = cg.getInitParameter("driverClass");
			String url= cg.getInitParameter("url");
			String user= cg.getInitParameter("dbuser");
			String pwd= cg.getInitParameter("dbpwd");
			
			// read form data
			int no = Integer.parseInt(req.getParameter("eno"));
			// Write JDBC code
			try {
				Class.forName(driver);
			}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			try(Connection con = DriverManager.getConnection(url,user,pwd);
					PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENO)){
					if(ps!=null)
							ps.setInt(1, no);
					try(ResultSet rs = ps.executeQuery()){
						if(rs!=null) {
							if(rs.next()){
								pw.println("<h1 style='color:blue;text-align:center'>Employee Details are :: </h1>");
								pw.println("<p style='text-align:center'><b>Employee Number :: "+rs.getInt(1)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Name 	 :: "+rs.getString(2)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Desg 		 :: "+rs.getString(3)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Salary 	 :: "+rs.getFloat(4)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Mgr No  :: "+rs.getFloat(5)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Dept No :: "+rs.getFloat(6)+"</b><br></p>");
							}//if
							else {
								pw.println("<h1 style='color:red;text-align:center'>Employee Record Not Found</h1>");
							}// else
						}//if
						pw.println("<br><br><p style='text-align:center'><a href='search.html'>Home</a></p>");
					}//try2		
			}// try
			catch(SQLException se) {
				se.printStackTrace();
			}
			// close stream
			pw.close();			
		}
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				doGet(req, res);
		}
}
