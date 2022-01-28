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
@Table(name = "tarea")
@Data @AllArgsConstructor @NoArgsConstructor
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtarea;
	@ManyToOne
	@JoinColumn(name = "idcalificacion",nullable = false)
	private Calificacion idcalificacion;
	private String fechaasignacion;
	private String fechaentrega;
	private String titulo;
	private String detalle;
	private Double puntaje;
	private String tipo;
	private String estado;
	
}
