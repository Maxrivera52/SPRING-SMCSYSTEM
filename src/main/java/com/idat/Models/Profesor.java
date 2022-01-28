package com.idat.Models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@OneToMany(mappedBy = "idprofesor",fetch = FetchType.EAGER)
	@JsonIgnoreProperties("idprofesor")
	private Set<DetalleProfesorSeccion> dtsecciones;

}
