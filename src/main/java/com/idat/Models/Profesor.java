package com.idat.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesor")
@Data @AllArgsConstructor @NoArgsConstructor
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprofesor;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String estado;
	private int idusuario;

}
