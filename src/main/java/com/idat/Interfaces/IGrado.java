package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Grado;

@Repository
public interface IGrado extends CrudRepository<Grado, Integer>{

}
