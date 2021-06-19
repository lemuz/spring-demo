package com.omnisport.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisport.hello.model.Product;
import com.omnisport.hello.repository.ProductRepository;

@Service
public class ProductService implements CrudService<Product>{
	
	@Autowired
	ProductRepository repo;
	
	public ProductService() {
		
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return repo.list();
	}

	public Optional<Product> getById() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product create(Product object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product update(Product object, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
