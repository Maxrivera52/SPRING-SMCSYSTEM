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

import com.idat.Interfaces.ISeccion;
import com.idat.Models.Seccion;

@RestController
@RequestMapping("/seccion")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 200)
public class CSeccion {
	@Autowired
	ISeccion servicio;
	
	@GetMapping("/listar")
	public List<Seccion> listar(){
		return (List<Seccion>) servicio.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Seccion> findById(@PathVariable int id){
		return servicio.findById(id);
	}
	
	@PostMapping("/save")
	public Seccion guardar(@RequestBody Seccion t) {
		 return servicio.save(t);
	}
	
	@PutMapping("/update")
	public Seccion modificar(@RequestBody Seccion t) {
		return servicio.save(t);
	}
	
	@DeleteMapping("/delete/{id}")
	public void modificar(@PathVariable int id) {
		 servicio.deleteById(id);;
	}


}
