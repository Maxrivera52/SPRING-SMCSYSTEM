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

import com.idat.Interfaces.IAnioEscolar;
import com.idat.Models.AnioEscolar;

@RestController
@RequestMapping("/rest_anios")
@CrossOrigin("http://localhost:4200")
public class CAnioEscolar {
	
	@Autowired
	private IAnioEscolar data;
	
	@GetMapping
	private List<AnioEscolar> getAll(){
		return (List<AnioEscolar>) data.findAll();
	}
	
	@GetMapping(value = "/{idanio}")
	private Optional<AnioEscolar> getById(@PathVariable("idanio") int idanio){
		return data.findById(idanio);
	}
	
	@PostMapping
	private Optional<AnioEscolar> save(@RequestBody AnioEscolar anio){
		AnioEscolar anioes = data.save(anio);
		return data.findById(anioes.getIdanio());
	}
	
	@PutMapping
	private int update(@RequestBody AnioEscolar anio) {
		int res = 0;
		AnioEscolar anioes = data.save(anio);
		if (anioes != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idanio}")
	private void delete(@RequestParam("idanio") int idanio) {
		data.deleteById(idanio);
	}
	
	

}
