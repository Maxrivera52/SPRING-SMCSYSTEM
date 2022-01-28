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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Interfaces.IDetalleProfesorSeccion;
import com.idat.Models.DetalleProfesorSeccion;

@RestController
@RequestMapping("/profesorSeccion")
@CrossOrigin("http://localhost:4200")
public class CDetalleProfesorSeccion {

	@Autowired
	private IDetalleProfesorSeccion data;
	
	@GetMapping
	private List<DetalleProfesorSeccion> getAll(){
		return (List<DetalleProfesorSeccion>) data.findAll();
	}
	
	@GetMapping(value = "/{id}")
	private Optional<DetalleProfesorSeccion> getById(@PathVariable("id") int id){
		return data.findById(id);
	}
	
	@PostMapping
	private DetalleProfesorSeccion save(@RequestBody DetalleProfesorSeccion tb){
		return data.save(tb);
	}
	
	@PutMapping
	private DetalleProfesorSeccion update(@RequestBody DetalleProfesorSeccion tb) {
		return data.save(tb);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@RequestParam("id") int id) {
		data.deleteById(id);
	}
	
}
