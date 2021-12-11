package com.idat.Models;


import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="anioescolar")
@Data @AllArgsConstructor @NoArgsConstructor
public class AnioEscolar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idanio;
	@Column (name="nombre", length = 4)
	private String nombre;
	@Column (name="fechainicio")
	private String fechainicio;
	@Column (name="fechacierre")
	private String fechacierre;
	@Column (name="estado")
	private String estado;

}
