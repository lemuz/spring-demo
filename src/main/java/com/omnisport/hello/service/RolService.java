package com.omnisport.hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.omnisport.hello.model.Rol;

public class RolService implements CrudService<Rol>{

	@Override
	public List<Rol> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Rol> getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol create(Rol object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol update(Rol object, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Rol> findByUsuarios(long idUsuario){
		return new ArrayList<Rol>();
	}
}