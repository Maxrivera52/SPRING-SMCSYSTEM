package com.idat.Interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Calificacion;

@Repository
public interface ICalificacion extends CrudRepository<Calificacion, Integer>{

	@Query("SELECT cal FROM Calificacion cal WHERE cal.idperiodo.idperiodo = ?1")
	public Optional<Calificacion> getCalificacionByIdPeriodo(int idperiodo);
}
