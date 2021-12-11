package com.idat.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Models.Rol;
import com.idat.Services.SRol;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 120)
public class CRol {
	@Autowired
	SRol servicio;
	
	@GetMapping("/listar")
	public List<Rol> listAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Rol> findById(@PathVariable int id){
		return servicio.findById(id);
	}
	
	@PostMapping("/save")
	public Rol save(@RequestBody Rol t) {
		 return servicio.save(t);
	}
	/*
	@PutMapping("/update")
	public void modificarUsuario(@RequestBody Usuario t) {
		servicio.save(t);
	}*/
	
}
