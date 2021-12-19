package com.idat.Models;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="alumno")
@Data @AllArgsConstructor @NoArgsConstructor
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idalumno;
	@Column (name="idseccion")
	private int idseccion;
	@Column (name="idusuario")
	private int idusuario;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column (name="dni", length = 8)
	private String dni;
	@Column (name="telefono", length=20)
	private String telefono;
	@Column (name="estado")
	private String estado;
}
