package com.idat.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.Models.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u WHERE u.correo= ?1")
	Usuario loginUserMailPass(String correo);

	
}