package com.omnisport.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omnisport.hello.config.HelloAppConfig;
import com.omnisport.hello.service.ProductService;

public class HelloApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloAppConfig.class);
		ProductService service = ctx.getBean(ProductService.class);
		System.out.println(service.list());
	}
	
}
