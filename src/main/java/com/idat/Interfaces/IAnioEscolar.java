package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.AnioEscolar;

@Repository
public interface IAnioEscolar extends CrudRepository<AnioEscolar, Integer>{

}
