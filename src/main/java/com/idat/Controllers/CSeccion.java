package com.idat.Controllers;

import java.util.Collection;
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
import com.idat.Models.Grado;
import com.idat.Models.Seccion;

@RestController
@RequestMapping("/seccion")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 200)
public class CSeccion {
	@Autowired
	ISeccion data;
	
	@GetMapping("/listar")
	public List<Seccion> listar(){
		return (List<Seccion>) data.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Seccion> findById(@PathVariable int id){
		return data.findById(id);
	}
	@GetMapping("/grado/{id}")
	public Collection<Seccion> findByidgrado(@PathVariable int id){
		Grado ob = new Grado();
		ob.setIdgrado(id);
		return data.findByidgrado(ob);
	}
	
	
	@PostMapping("/save")
	public Seccion guardar(@RequestBody Seccion t) {
		 return data.save(t);
	}
	
	@PutMapping("/update")
	public Seccion modificar(@RequestBody Seccion t) {
		return data.save(t);
	}
	
	@DeleteMapping("/delete/{id}")
	public void modificar(@PathVariable int id) {
		data.deleteById(id);;
	}


}
