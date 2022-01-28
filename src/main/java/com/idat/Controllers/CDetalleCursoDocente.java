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

import com.idat.Interfaces.IDetalleCursoDocentes;
import com.idat.Models.DetalleCursoDocente;

@RestController
@RequestMapping("/detalle_curso_docente")
@CrossOrigin(value = "http://localhost:4200")
public class CDetalleCursoDocente {

	@Autowired
	private IDetalleCursoDocentes data;
	
	@GetMapping
	private List<DetalleCursoDocente> getAll(){
		return (List<DetalleCursoDocente>) data.findAll();
	}
	
	@GetMapping(value = "/{id}")
	private Optional<DetalleCursoDocente> getById(@PathVariable("id") int id){
		return data.findById(id);
	}

	@GetMapping(value = "/querydocente/{nivel}/{docente}")
	private Collection<DetalleCursoDocente> getDetalleByDocenteNivel(@PathVariable("nivel") String nivel, @PathVariable("docente") String docente){
		return data.getDetalleCursosDocenteByDocenteNivel(nivel, docente);
	}
	
	
	@PostMapping
	private DetalleCursoDocente save(@RequestBody DetalleCursoDocente cur){
		return data.save(cur);
	}
	
	@PutMapping
	private DetalleCursoDocente update(@RequestBody DetalleCursoDocente cur) {
		return data.save(cur);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@RequestParam("id") int id) {
		data.deleteById(id);
	}
	


}
