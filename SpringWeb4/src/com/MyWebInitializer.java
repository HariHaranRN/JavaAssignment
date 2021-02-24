package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//this file will replace your web.xml file

public class MyWebInitializer implements WebApplicationInitializer{
@Override
public void onStartup(ServletContext servletContext) throws ServletException {
	// TODO Auto-generated method stub
	AnnotationConfigWebApplicationContext webCtx=new AnnotationConfigWebApplicationContext();
	webCtx.register(SpringConfig.class);
	webCtx.setServletContext(servletContext);
	
	ServletRegistration.Dynamic dispatcherServlet=
			servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
	
	dispatcherServlet.addMapping("/");
	dispatcherServlet.setLoadOnStartup(1);
}
}

