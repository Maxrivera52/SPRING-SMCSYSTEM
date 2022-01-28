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
@Table(name = "calificacion")
@Data @AllArgsConstructor @NoArgsConstructor
public class Calificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcal;
	private String fechacomplcal;
	private String observacioncal;
	private String estado;
	@ManyToOne
	@JoinColumn(name = "idcurso",nullable = false)
	private Curso idcurso;
	@ManyToOne
	@JoinColumn(name = "idalumno",nullable = false)
	private Alumno idalumno;
	@ManyToOne
	@JoinColumn(name = "idperiodo")
	private Periodo idperiodo;

}
