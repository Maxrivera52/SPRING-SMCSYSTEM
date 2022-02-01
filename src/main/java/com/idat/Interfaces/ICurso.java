package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.*;

@Repository
public interface ICurso extends CrudRepository<Curso, Integer>{


	@Query(value = "SELECT cur FROM Curso cur WHERE cur.idgrado.idgrado=?1")
	public Collection<Curso> getByIdGrado(int idgrado);
}
