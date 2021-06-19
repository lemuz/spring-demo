package com.omnisport.hello.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<CLASS> {
	
	List<CLASS> list();
	
	Optional<CLASS> getById();
	
	CLASS create(CLASS object);
	
	CLASS update(CLASS object, int id);
	
	boolean delete(int id);
}
