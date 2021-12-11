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

import com.idat.Interfaces.IGrado;
import com.idat.Models.Grado;

@RestController
@RequestMapping("/rest_grados")
@CrossOrigin("http://localhost:4200")
public class CGrado {
	
	@Autowired
	private IGrado data;
	
	@GetMapping
	private List<Grado> getAll(){
		return (List<Grado>) data.findAll();
	}
	
	@GetMapping(value = "/{idgrado}")
	private Optional<Grado> getById(@PathVariable("idgrado") int idgrado){
		return data.findById(idgrado);
	}
	
	@PostMapping
	private Optional<Grado> save(@RequestBody Grado gra){
		Grado grado = data.save(gra);
		return data.findById(grado.getIdgrado());
	}
	
	@PutMapping
	private int update(@RequestBody Grado gra) {
		int res = 0;
		Grado grado = data.save(gra);
		if (grado != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idgrado}")
	private void delete(@RequestParam("idgrado") int idgrado) {
		data.deleteById(idgrado);
	}
	

}
