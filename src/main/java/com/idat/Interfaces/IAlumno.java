package com.idat.Interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Alumno;

@Repository
public interface IAlumno extends CrudRepository<Alumno, Integer>{
	Optional<Alumno> findBydni(String dni);
	
	@Query("SELECT a FROM Alumno a WHERE a.idalumno = ?1")
	public Optional<Alumno> findByUserId(int id);
	
	@Query("SELECT a FROM Alumno a WHERE a.idseccion = ?1")
	public List<Alumno> findBySeccion(int id);
}
