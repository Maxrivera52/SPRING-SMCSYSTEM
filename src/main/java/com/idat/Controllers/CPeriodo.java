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

import com.idat.Interfaces.IPeriodo;
import com.idat.Models.Periodo;

@RestController
@RequestMapping("/rest_periodos")
@CrossOrigin("http://localhost:4200")
public class CPeriodo {
	
	@Autowired
	private IPeriodo data;
	
	@GetMapping
	private List<Periodo> getAll(){
		return (List<Periodo>) data.findAll();
	}
	
	@GetMapping(value = "/{idperiodo}")
	private Optional<Periodo> getById(@PathVariable("idperiodo") int idperiodo){
		return data.findById(idperiodo);
	}
	
	@PostMapping
	private Optional<Periodo> save(@RequestBody Periodo peri){
		Periodo periodo = data.save(peri);
		return data.findById(periodo.getIdperiodo());
	}
	
	@PutMapping
	private int update(@RequestBody Periodo peri){
		int res = 0;
		Periodo periodo = data.save(peri);
		if (periodo != null) {
			res=1;
		}
		return res;
		
	}
	
	@DeleteMapping("/{idperiodo}")
	private void delete(@RequestParam("idperiodo") int idperiodo) {
		data.deleteById(idperiodo);
	}
	
	

}
