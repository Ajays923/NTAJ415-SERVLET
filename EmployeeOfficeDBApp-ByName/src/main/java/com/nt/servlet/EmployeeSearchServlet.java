package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet{
		private static final String GET_EMP_BY_ENAME="SELECT EMPNO,ENAME,JOB,MGR,SAL,DEPTNO FROM EMP WHERE ENAME=?";
	
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// get PrintWriter object
			PrintWriter pw = res.getWriter();
			//set content type
			res.setContentType("text/html");
			// read form data
			//int no = Integer.parseInt(req.getParameter("eno"));
			String name = req.getParameter("ename").toUpperCase();
			// Write JDBC code
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
			try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
					PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENAME)){
					if(ps!=null)
							ps.setString(1, name);
					try(ResultSet rs = ps.executeQuery()){
						if(rs!=null) {
							if(rs.next()){
								pw.println("<table style='border:1px solid white;align:center'>");
								pw.println("<h1 style='color:blue;text-align:center'>Employee Details are :: </h1>");
								pw.println("<p style='text-align:center'><b>Employee Number ::"+rs.getInt(1)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Name 	 ::" +rs.getString(2)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Desg 		 ::"+rs.getString(3)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Salary 	 ::"+rs.getFloat(4)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Mgr No  :: "+rs.getFloat(5)+"</b><br>");
								pw.println("<p style='text-align:center'><b>Employee Dept No :: "+rs.getFloat(6)+"</b><br></p>");
								pw.println("</table>");
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
