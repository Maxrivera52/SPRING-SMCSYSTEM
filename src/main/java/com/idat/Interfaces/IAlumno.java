package com.idat.Interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Alumno;

@Repository
public interface IAlumno extends CrudRepository<Alumno, Integer>{
	Optional<Alumno> findBydni(String dni);
}
