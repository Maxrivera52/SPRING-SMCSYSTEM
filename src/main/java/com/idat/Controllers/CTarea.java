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

import com.idat.Interfaces.ITarea;
import com.idat.Models.Tarea;

@RestController
@RequestMapping("/tareaAlumno")
@CrossOrigin(value = "http://localhost:4200",maxAge = 200)
public class CTarea {
	@Autowired
	private ITarea data;
	
	@GetMapping
	private Collection<Tarea> getAll(){
		return (List<Tarea>) data.findAll();
	}
	
	@GetMapping(value = "/{id}")
	private Optional<Tarea> getById(@PathVariable("id") int id){
		return data.findById(id);
	}
	
	@GetMapping(value = "/idAlumno/{id}")
	private Collection<Tarea> getByIdAlumno(@PathVariable("id") int id){
		//System.out.println("$$$$$ "+ (id+1));
		return data.getTareasByIdAlumno(id);
	} 
	
	@PostMapping
	private Tarea save(@RequestBody Tarea et){
		return data.save(et);
	}
	
	@PutMapping
	private Tarea update(@RequestBody Tarea et) {
		return data.save(et);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@RequestParam("id") int id) {
		data.deleteById(id);
	}
	

}
