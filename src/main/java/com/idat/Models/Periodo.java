package com.idat.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodo")
@Data @AllArgsConstructor @NoArgsConstructor
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idperiodo;
	@Column (name="nombre", length = 50)
	private String nombre;
	@Column (name="fechainicio")
	private String fechainicio;
	@Column (name="fechacierre")
	private String fechacierre;
	@Column (name="estado")
	private String estado;
	@ManyToOne
	@JoinColumn(name = "idanio",nullable = false)
	private AnioEscolar idanio;

}
