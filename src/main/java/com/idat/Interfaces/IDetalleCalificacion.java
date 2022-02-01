package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.DetalleCalificacion;

@Repository
public interface IDetalleCalificacion  extends CrudRepository<DetalleCalificacion, Integer>{
	
	@Query(value = "SELECT dcal FROM DetalleCalificacion dcal "
			+ "WHERE idcalificacion.idperiodo.idanio.fechainicio <= ?1 "
			+ "AND idcalificacion.idperiodo.idanio.fechacierre >= ?1 "
			+ "AND idcalificacion.idcurso.idcurso = ?2 "
			+ "AND idalumno.idseccion = ?3")
	public Collection<DetalleCalificacion> getByPeriodoCalification(String fecha,int idcurso,int idseccion);
}
