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

import com.idat.Interfaces.IDia;
import com.idat.Models.Dia;

@RestController
@RequestMapping("/rest_dia")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 120)
public class CDia {
	
	@Autowired
	private IDia data;
	
	@GetMapping
	private List<Dia> getAll(){
		return (List<Dia>) data.findAll();
	}
	
	@GetMapping(value = "/{iddia}")
	private Optional<Dia> getById(@PathVariable("iddia") int iddia){
		return data.findById(iddia);
	}
	
	@PostMapping
	private Optional<Dia> save(@RequestBody Dia dia){
		Dia dias = data.save(dia);
		return data.findById(dias.getIddia());
	}
	
	@PutMapping
	private int update(@RequestBody Dia dia) {
		int res = 0;
		Dia dias = data.save(dia);
		if (dias != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{iddia}")
	private void delete(@RequestParam("iddia") int iddia) {
		data.deleteById(iddia);
	}

}
