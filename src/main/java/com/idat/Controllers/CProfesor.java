package com.idat.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Models.Profesor;
import com.idat.Services.SProfesor;

@RestController
@RequestMapping("/profesor")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 120)
public class CProfesor {
	@Autowired
	SProfesor servicio;
	
	@GetMapping("/listar")
	public List<Profesor> listar(){
		return servicio.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Profesor> findById(@PathVariable int id){
		return servicio.findById(id);
	}
	
	@PostMapping("/save")
	public Profesor guardar(@RequestBody Profesor t) {
		 return servicio.save(t);
	}
	
	@PutMapping("/update")
	public Profesor modificar(@RequestBody Profesor t) {
		return servicio.save(t);
	}
	
	@DeleteMapping("/delete/{id}")
	public void modificar(@PathVariable int id) {
		 servicio.deleteById(id);;
	}

}
