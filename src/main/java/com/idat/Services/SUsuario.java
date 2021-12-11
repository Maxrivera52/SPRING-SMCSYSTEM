package com.idat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Interfaces.IUsuario;
import com.idat.Models.Usuario;

@Service
public class SUsuario {
	
	@Autowired
	IUsuario data;
	
	public List<Usuario> findAll(){
		return (List<Usuario>)data.findAll();
	}
	public Optional<Usuario>findById(int id){
		return data.findById(id);
	}
	public Usuario save(Usuario t) {
		return data.save(t);
	}
	public Usuario loginUser(String correo,String clave){
		return data.loginUserMailPass(correo, clave);
	}
	/*
	public Usuario update(Usuario t) {
		return data.save(t);
	}*/
	public void deleteById(int id) {
		data.deleteById(id);
		//return "Id Eliminado con éxito";
	}
	
}
