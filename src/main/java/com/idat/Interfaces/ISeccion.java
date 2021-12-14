package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Seccion;

@Repository
public interface ISeccion extends CrudRepository<Seccion, Integer> {

}
