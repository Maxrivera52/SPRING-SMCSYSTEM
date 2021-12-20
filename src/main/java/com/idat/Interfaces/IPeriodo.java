package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Periodo;

@Repository
public interface IPeriodo extends CrudRepository<Periodo, Integer>{

}
