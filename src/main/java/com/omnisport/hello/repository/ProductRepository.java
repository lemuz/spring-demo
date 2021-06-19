package com.omnisport.hello.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.omnisport.hello.model.Product;

@Repository
public class ProductRepository implements CrudRepository{

	public List list() {
		return new ArrayList<Product>();
	}

	public Optional getById() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object create(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object update(Object object, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
