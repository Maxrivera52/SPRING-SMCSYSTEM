package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Grado;
import com.idat.Models.Seccion;

@Repository
public interface ISeccion extends CrudRepository<Seccion, Integer> {

	
	public Collection<Seccion> findByidgrado(Grado idgrado);
}
