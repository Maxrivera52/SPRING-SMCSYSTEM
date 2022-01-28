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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Interfaces.ICalificacion;
import com.idat.Models.Calificacion;

@RestController
@RequestMapping("/calificacionesAlumno")
@CrossOrigin(value = "http://localhost:4200",maxAge = 200)
public class CCalificacion {
	@Autowired
	private ICalificacion data;
	
	@GetMapping
	private Collection<Calificacion> getAll(){
		return (List<Calificacion>) data.findAll();
	}
	
	@GetMapping(value = "/{id}")
	private Optional<Calificacion> getById(@PathVariable("id") int id){
		return data.findById(id);
	}
	
	@GetMapping(value = "/byIdPeriodo/{id}")
	private Optional<Calificacion> getByIdPeriodo(@PathVariable("id") int id){
		return data.getCalificacionByIdPeriodo(id);
	}
	
	@PostMapping
	private Calificacion save(@RequestBody Calificacion et){
		return data.save(et);
	}
	
	@PutMapping
	private Calificacion update(@RequestBody Calificacion et) {
		return data.save(et);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@RequestParam("id") int id) {
		data.deleteById(id);
	}
	


}
