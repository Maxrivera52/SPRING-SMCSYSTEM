package com.idat.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dtprofesorseccion")
@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleProfesorSeccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddtprofseccion;
	@ManyToOne
	@JoinColumn(name = "idprofesor",nullable = false)
	private Profesor idprofesor;
	@ManyToOne
	@JoinColumn(name = "idseccion",nullable = false)
	private Seccion idseccion;
	private String estado;	
}
