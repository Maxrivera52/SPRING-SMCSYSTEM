package com.idat.Models;

import javax.persistence.Column;
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
@Table(name = "detalle_calificacion")
@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleCalificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "idalumno")
	private Alumno idalumno;
	@ManyToOne
	@JoinColumn(name = "idcalificacion")
	private Calificacion idcalificacion;
	@Column(nullable = true)
	private String fecha_entregado;
	@Column(nullable = true)
	private Double puntuacion;
	private String estado;
}
