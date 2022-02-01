package com.idat.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Periodo;

@Repository
public interface IPeriodo extends CrudRepository<Periodo, Integer>{

	@Query("SELECT per FROM Periodo per WHERE per.fechacierre > ?1")
	public Collection<Periodo> getPeriodoByDateMax(String fecha);
	
	@Query("SELECT per FROM Periodo per WHERE per.fechainicio <= ?1 "
			+ "AND per.fechacierre >= ?1")
	public Periodo getCurrentPeriodoByDate(String fecha);
}
