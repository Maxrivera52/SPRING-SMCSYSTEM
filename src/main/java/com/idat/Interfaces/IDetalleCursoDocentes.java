package com.idat.Interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.DetalleCursoDocente;
import com.idat.Models.Profesor;

@Repository
public interface IDetalleCursoDocentes extends CrudRepository<DetalleCursoDocente, Integer> {
	
	public List<DetalleCursoDocente> findByIdprofesor(Profesor idprofesor);
	
	
}
