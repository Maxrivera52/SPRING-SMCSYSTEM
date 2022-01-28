package com.idat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.idat.Interfaces.IUsuario;
import com.idat.Models.Usuario;

@Service
public class SUsuario {
	
	@Autowired
	IUsuario data;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public List<Usuario> findAll(){
		return (List<Usuario>)data.findAll();
	}
	public Optional<Usuario>findById(int id){
		return data.findById(id);
	}
	public Usuario save(Usuario t) {
		t.setClave(passwordEncoder.encode(t.getClave()));
		return data.save(t);
	}
	public Usuario loginUser(String correo,String clave){
		Usuario ob = data.loginUserMailPass(correo);
		if(ob==null) {
			return ob;
		}
		boolean ismatch = passwordEncoder.matches(clave, ob.getClave());
		
		if (ismatch) {
			return ob;
		}
		return null; 
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
