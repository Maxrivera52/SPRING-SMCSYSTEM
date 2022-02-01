package com.idat.Controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Interfaces.IDetalleCalificacion;
import com.idat.Models.Alumno;
import com.idat.Models.Calificacion;
import com.idat.Models.DetalleCalificacion;

@RestController
@RequestMapping("/detalleCalificacion")
public class CDetalleCalificacion {
	@Autowired
	private IDetalleCalificacion data;
	
	@Autowired
	private CAlumno alumnoController;
	
	@GetMapping
	private Collection<DetalleCalificacion> getAll(){
		return (List<DetalleCalificacion>) data.findAll();
	}
	
	@GetMapping(value = "/{id}")
	private Optional<DetalleCalificacion> getById(@PathVariable("id") int id){
		return data.findById(id);
	}
	@GetMapping(value = "/periodosActivosRangoAnio")
	private Collection<DetalleCalificacion> getByPeriodosActivosAnio(
			@RequestParam(name = "curso")int idcurso, @RequestParam(name = "seccion")int idseccion){
		LocalDate date = java.time.LocalDate.now(ZoneId.of( "America/Montreal" ));
		return data.getByPeriodoCalification(String.format("%s", date),idcurso,idseccion);
	}
	
	@PostMapping
	private DetalleCalificacion save(@RequestBody DetalleCalificacion et){
		return data.save(et);
	}
	
	
	@PostMapping("/saveDetailtoAlumns")
	private Collection<DetalleCalificacion> saveToAllAlumnos(@RequestBody DetalleCalificacion tb,
			@RequestParam(name = "idseccion") int idseccion){
		Collection<Alumno> alumnos = alumnoController.getByIdSeccion(idseccion);
		Collection<DetalleCalificacion> listDetalle = new ArrayList<>();
		for (Alumno alumno : alumnos) {
			tb.setFecha_entregado(null);
			tb.setPuntuacion(null);
			tb.setEstado("creado");
			tb.setIdalumno(alumno);
			data.save(tb);
			listDetalle.add(tb);
		}
		return listDetalle;
	}
	
	@PutMapping
	private DetalleCalificacion update(@RequestBody DetalleCalificacion et) {
		return data.save(et);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@RequestParam("id") int id) {
		data.deleteById(id);
	}

}
