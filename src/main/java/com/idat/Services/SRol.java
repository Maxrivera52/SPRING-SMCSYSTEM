package com.idat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Interfaces.IRol;
import com.idat.Models.Rol;

@Service
public class SRol {

	@Autowired
	IRol data;
		
	public List<Rol> findAll(){
		return (List<Rol>)data.findAll();
	}
	public Optional<Rol>findById(int id){
		return data.findById(id);
	}
	public Rol save(Rol t) {
		return data.save(t);
	}
	/*
	public Rol update(Rol t) {
		return data.save(t);
	}*/
	public void deleteById(int id) {
		data.deleteById(id);
		//return "Id Eliminado con éxito";
	}
}
