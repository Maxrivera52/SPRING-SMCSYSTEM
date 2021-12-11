package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Rol;

@Repository
public interface IRol extends CrudRepository<Rol, Integer>{

}
