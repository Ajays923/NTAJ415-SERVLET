package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
import javazoom.upload.UploadParameters;
import oracle.net.nt.ConnectDescription;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet{
		private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO UPLOAD_EMPLOYEE VALUES(EID_SEQ.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 // get PrintWriter object
		PrintWriter pw = res.getWriter();
	// set response content type
		res.setContentType("text/html");
		
		Connection con =null;
		PreparedStatement ps = null;
		try {
		// create Special request object
		MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);
		// read form data
		String name = nreq.getParameter("ename");
		String addrs = nreq.getParameter("eaddrs");
		// create upload bean class obj
		UploadBean upb = new UploadBean();
		upb.setFolderstore("E:/store");
		upb.setOverwrite(false);
		upb.setFilesizelimit(50*1024);
		// complete file uploading process
		upb.store(nreq);
		pw.println("<b> Files are uploaded Successfully </b>");
		//get the name of the upload files 
			Vector<UploadParameters> vector = upb.getHistory();
			ArrayList<String> filesList = new ArrayList<>();
			vector.forEach(up -> {
				filesList.add("E:/store/"+up.getFilename());
			});
			// write jdbc code to form data and files location to db tables as record
			// Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin");
			// create preparedStatement obj
			ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY); 
			// set values to query param
			ps.setString(1,name);
			ps.setString(2, addrs);
			ps.setString(3,filesList.get(1));
			ps.setString(4, filesList.get(0));
			// execute query
			int count=ps.executeUpdate();
			if(count==1)
				pw.println("<h1 style='color:red;text-align:center'>Employee Registered </h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Employee not Registered </h1>");
		} 
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<b> Problem in file uploading </b>");
		}
		finally {
			// close jdbc connecton
			try{
				if(ps!=null) 
					ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try{
				if(con!=null) 
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		// add hyperlink
		pw.println("<a href='employee_registration.html'>Home</a>");
		
		// close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
