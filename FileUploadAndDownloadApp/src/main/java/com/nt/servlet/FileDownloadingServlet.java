package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/downloadurl")
public class FileDownloadingServlet extends HttpServlet {
		private static final String GET_RESUME_PATH_BY_NO="SELECT RESUME_PATH FROM UPLOAD_EMPLOYEE WHERE EID=?";
		private static final String GET_PHOTO_PATH_BY_NO="SELECT PHOTO_PATH FROM UPLOAD_EMPLOYEE WHERE EID=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// check which download hyperlink is clicked (resume or photo)
		String query= null;
		int eno = 0;
		if(req.getParameter("resumeId")!=null) {// for resume
			query = GET_RESUME_PATH_BY_NO;
			eno = Integer.parseInt(req.getParameter("resumeId"));
		}
		else { // for photoE
			query = GET_PHOTO_PATH_BY_NO;
			eno = Integer.parseInt(req.getParameter("photoId"));
		}
		// load the class jdbc driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cfe) {
			cfe.printStackTrace();
		}
		String filePath=null;
		try (Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Admin");
				PreparedStatement ps = con.prepareStatement(query)){
			// set value to query param
			ps.setInt(1, eno);
			// execute the query
			try(ResultSet rs=ps.executeQuery()) {
				if(rs.next())
					filePath=rs.getString(1);
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//get Length of the file and make it response content length
		File file= new File(filePath);
		res.setContentLengthLong(file.length());
		// get file content type(MIME type )make it response content type
		ServletContext sc = getServletContext();
		String mimetype=sc.getMimeType(filePath);
		mimetype=mimetype!=null?mimetype:"application/octet	-stream";
		res.setContentType(mimetype);
		// give instruction to browser to make receive content as the downloadable file content
		res.setHeader("content-Disposition","attachment;fileName"+file.getName());
		// create InputStream pointing to file
		InputStream is = new FileInputStream(filePath);
		// create OutputStream pointing to the 	response object
		OutputStream os = res.getOutputStream();
		// copy file content to response obj (this completes file downloading
		IOUtils.copy(is, os);
		// close stream
		is.close();
		os.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
