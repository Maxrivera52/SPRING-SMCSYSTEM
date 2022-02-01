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
	private int idcalificacion;
	@ManyToOne
	@JoinColumn(name = "idcurso",nullable = false)
	private Curso idcurso;
	@ManyToOne
	@JoinColumn(name = "idperiodo",nullable = false)
	private Periodo idperiodo;
	private String tipo;
	private String fecha_asignacion;
	private String fecha_entrega;
	private String titulo;
	private String descripcion;
	private String estado;
	
}
