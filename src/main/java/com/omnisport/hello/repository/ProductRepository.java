package com.omnisport.hello.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.omnisport.hello.model.Product;

@Repository
public class ProductRepository implements CrudRepository<Product>{
	
	public List<Product> list() {
		return new ArrayList<Product>();
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
