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
@Table(name="grado")
@Data @AllArgsConstructor @NoArgsConstructor

public class Grado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idgrado;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "idnivel",nullable = false)
	private Nivel idnivel;

}
