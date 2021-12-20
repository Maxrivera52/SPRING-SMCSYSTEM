package com.idat.Interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Profesor;

@Repository
public interface IProfesor extends CrudRepository<Profesor, Integer>{

	@Query("SELECT p FROM Profesor p WHERE p.idusuario = ?1")
	public Optional<Profesor> findByIdUser(int id);
}
