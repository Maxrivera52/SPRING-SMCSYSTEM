package com.idat.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data @AllArgsConstructor @NoArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	private String descripcion;
	private String estado;
	
	/*
	@ManyToOne
	@JoinColumn(name = "idusuario",nullable = false)
	private Usuario usuario;
	*/
}
 