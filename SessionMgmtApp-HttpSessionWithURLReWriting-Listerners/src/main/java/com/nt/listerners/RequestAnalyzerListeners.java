package com.nt.listerners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestAnalyzerListeners implements ServletRequestListener {
		private long start,end;

		public RequestAnalyzerListeners() {
			System.out.println("RequestAnalyzerListeners::0-param constructor");
		}
		
		@Override
		public void requestInitialized(ServletRequestEvent sre) {
			System.out.println("RequestAnalyzerListeners.requestInitialized()");
			start = System.currentTimeMillis();
		}
		@Override
		public void requestDestroyed(ServletRequestEvent sre) {
				System.out.println("RequestAnalyzerListeners.requestDestroyed()");
				end=System.currentTimeMillis();
				// get HttpServletRequest object
				HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
				// get ServletContext object
				ServletContext sc = req.getServletContext();
				sc.log(req. getRequestURI()+" has taken"+(end-start)+" ms time take to proces the request");
				System.out.println(req.getRequestURI()+" has taken"+(end-start)+" ms time take to process the request");
			
		}
		
}
