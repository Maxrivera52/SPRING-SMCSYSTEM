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
@Table(name = "seccion")
@Data @AllArgsConstructor @NoArgsConstructor
public class Seccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idseccion;
	@ManyToOne
	@JoinColumn(name = "idgrado",nullable = false)
	private Grado idgrado;
	private String descripcion;
	private String estado;

}
