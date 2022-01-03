package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Dia;

@Repository
public interface IDia extends CrudRepository<Dia, Integer>{

}
