package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.DetalleProfesorSeccion;

@Repository
public interface IDetalleProfesorSeccion extends CrudRepository<DetalleProfesorSeccion, Integer>{

}
