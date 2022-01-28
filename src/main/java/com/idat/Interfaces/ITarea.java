package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.Models.Tarea;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer>{

	@Query("SELECT tr FROM Tarea tr INNER JOIN Calificacion cal ON cal.idcal = tr.idcalificacion "
			+ "WHERE cal.idalumno.idalumno = :idalumno")
	public Collection<Tarea> getTareasByIdAlumno(@Param("idalumno") int id);
}
