package com.idat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Interfaces.IProfesor;
import com.idat.Interfaces.IUsuario;
import com.idat.Models.Profesor;

@Service
public class SProfesor {

	@Autowired
	IProfesor data;
	@Autowired
	IUsuario dataUser;
	
	public List<Profesor> findAll(){
		return (List<Profesor>)data.findAll();
	}
	public Optional<Profesor>findById(int id){
		return data.findById(id);
	}
	public Profesor save(Profesor t) {
		return data.save(t);
	}
	public Profesor update(Profesor t) {
		return data.save(t);
	}
	public void deleteById(int id) {
		data.deleteById(id);
	}
	
}
