package com.idat.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="curso")
@Data @AllArgsConstructor @NoArgsConstructor
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcurso;
	@ManyToOne
	@JoinColumn(name = "idgrado",nullable = false)
	private Grado idgrado;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="estado")
	private String estado;

}
