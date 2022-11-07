package com.nt.listerners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionAnalyzer implements HttpSessionListener {
		private long start,end;
		
		public SessionAnalyzer() {
			System.out.println("SessionAnalyzer::0-param constructor");
		}
		
		@Override
		public void sessionCreated(HttpSessionEvent se) {
		start = System.currentTimeMillis();
		System.out.println("Session started at::"+new Date());
		// get ServletContext obj
		ServletContext sc = se.getSession().getServletContext();
		sc.log("Session started at :"+new Date());
		}
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {
			
			end = System.currentTimeMillis();
			System.out.println("Session ended at :: "+new Date());
			// get Access to ServletContext
			ServletContext sc = se.getSession().getServletContext();
			sc.log("Session ended at ::"+new Date());
			System.out.println("Session duration :: "+(end-start)+" ms");
			sc.log("Session duration "+(end-start)+" ms");
		}
}
