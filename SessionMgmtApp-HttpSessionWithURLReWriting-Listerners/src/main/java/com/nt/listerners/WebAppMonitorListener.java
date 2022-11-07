package com.nt.listerners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppMonitorListener implements ServletContextListener {
	private long start=0,end=0;
		public WebAppMonitorListener() {
			System.out.println("WebAppMonitorListener::0-param constructor");
		}
		
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			System.out.println("WebAppMonitorListener.contextInitialized()");
			start = System.currentTimeMillis();
			// get Servletcontext obj
			ServletContext sc = sce.getServletContext();
			sc.log("Web application is deployed/reloaded/redeployed at: "+new Date());
			System.out.println("Web application is deployed / reloaded/ redeployed at :: "+new Date());
		}
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			System.out.println("WebAppMonitorListener.contextDestroyed()");
			end = System.currentTimeMillis();
			// get Servletcontext object
			ServletContext sc = sce.getServletContext();
			sc.log("Web application is undeployed/stop at :: "+new Date());
			System.out.println("Web application is undeployed/stop at :: "+new Date());
		}
}
