package com.omnisport.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnisport.hello.model.Product;
import com.omnisport.hello.service.ProductService;

@RestController
@RequestMapping("/producto")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping()
	public ResponseEntity<List<Product>> get() {
		try {
			return ResponseEntity.ok(service.list());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}