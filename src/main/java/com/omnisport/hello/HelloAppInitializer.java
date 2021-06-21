package com.omnisport.hello;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import com.omnisport.hello.config.HelloAppMvcConfigure;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class HelloAppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(HelloAppMvcConfigure.class);
		ctx.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("HelloAppDispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/api/v1/*");
	}
}