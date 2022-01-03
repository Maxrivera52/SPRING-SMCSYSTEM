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
	@Column(name = "idgrado")
	private int idgrado;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="estado")
	private String estado;

}
