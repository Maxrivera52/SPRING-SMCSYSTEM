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
@Table(name = "dtcurso")
@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleCursoDocente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddtcurso;	
	private String fechainicio;	
	private String fechafinal;	
	@ManyToOne
	@JoinColumn(name = "idcurso",nullable = false)
	private Curso idcurso;	
	@ManyToOne
	@JoinColumn(name = "idprofesor",nullable = false)
	private Profesor idprofesor;	
	@ManyToOne
	@JoinColumn(name = "idseccion",nullable = false)
	private Seccion idseccion;

}
