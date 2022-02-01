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

import com.idat.Interfaces.IAlumno;
import com.idat.Models.Alumno;

@RestController
@RequestMapping("/rest_alumnos")
@CrossOrigin("http://localhost:4200")
public class CAlumno {
	
	@Autowired
	private IAlumno data;
	
	@GetMapping
	private List<Alumno> getAll(){
		return (List<Alumno>) data.findAll();
	}
	
	@GetMapping(value = "/{idalumno}")
	private Optional<Alumno> getById(@PathVariable("idalumno") int idalumno){
		return data.findById(idalumno);
	}
	
	@GetMapping(value="/seccion/{id}")
	public List<Alumno> getByIdSeccion(@PathVariable("id") int id){
		return data.findBySeccion(id);
	}
	
	@PostMapping
	private Optional<Alumno> save(@RequestBody Alumno alu){
		Alumno alumno = data.save(alu);
		return data.findById(alumno.getIdalumno());
	}
	
	@PutMapping
	private int update(@RequestBody Alumno alu) {
		int res = 0;
		Alumno alumno = data.save(alu);
		if (alumno != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idalumno}")
	private void delete(@RequestParam("idalumno") int idalumno) {
		data.deleteById(idalumno);
	}
	
	
	////
	@GetMapping("/iduser/{id}")
	private Optional<Alumno> getByUserId(@PathVariable int id){
		return data.findByUserId(id);
	}
	

}
