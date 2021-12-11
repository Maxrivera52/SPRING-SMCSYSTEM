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

import com.idat.Interfaces.ICurso;
import com.idat.Models.Curso;

@RestController
@RequestMapping("/rest_cursos")
@CrossOrigin("http://localhost:4200")
public class CCurso {
	
	@Autowired
	private ICurso data;
	
	@GetMapping
	private List<Curso> getAll(){
		return (List<Curso>) data.findAll();
	}
	
	@GetMapping(value = "/{idcurso}")
	private Optional<Curso> getById(@PathVariable("idcurso") int idcurso){
		return data.findById(idcurso);
	}
	
	@PostMapping
	private Optional<Curso> save(@RequestBody Curso cur){
		Curso curso = data.save(cur);
		return data.findById(curso.getIdcurso());
	}
	
	@PutMapping
	private int update(@RequestBody Curso cur) {
		int res = 0;
		Curso curso = data.save(cur);
		if (curso != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idcurso}")
	private void delete(@RequestParam("idcurso") int idcurso) {
		data.deleteById(idcurso);
	}
	
	

}
