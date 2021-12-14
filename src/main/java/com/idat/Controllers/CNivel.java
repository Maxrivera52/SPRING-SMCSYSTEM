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

import com.idat.Interfaces.INivel;
import com.idat.Models.Nivel;

@RestController
@RequestMapping("/rest_nivel")
@CrossOrigin("http://localhost:4200")
public class CNivel {
	
	@Autowired
	private INivel data;
	
	@GetMapping
	private List<Nivel> getAll(){
		return (List<Nivel>) data.findAll();
	}
	
	@GetMapping(value = "/{idnivel}")
	private Optional<Nivel> getById(@PathVariable("idnivel") int idnivel){
		return data.findById(idnivel);
	}
	
	@PostMapping
	private Optional<Nivel> save(@RequestBody Nivel niv){
		Nivel nivel = data.save(niv);
		return data.findById(nivel.getIdnivel());
	}
	
	@PutMapping
	private int update(@RequestBody Nivel niv) {
		int res = 0;
		Nivel nivel = data.save(niv);
		if (nivel != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idnivel}")
	private void delete(@RequestParam("idnivel") int idnivel) {
		data.deleteById(idnivel);
	}
	


}
