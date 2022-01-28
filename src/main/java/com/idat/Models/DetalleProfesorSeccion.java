package com.idat.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dtprofesorseccion")
@AllArgsConstructor @NoArgsConstructor
public class DetalleProfesorSeccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddtprofseccion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idprofesor",nullable = false)
	private Profesor idprofesor;
	@ManyToOne
	@JoinColumn(name = "idseccion",nullable = false)
	private Seccion idseccion;
	private String estado;
	
	
	public int getIddtprofseccion() {
		return iddtprofseccion;
	}
	public void setIddtprofseccion(int iddtprofseccion) {
		this.iddtprofseccion = iddtprofseccion;
	}
	//@JsonIgnore
	public Profesor getIdprofesor() {
		return idprofesor;
	}
	public void setIdprofesor(Profesor idprofesor) {
		this.idprofesor = idprofesor;
	}
	public Seccion getIdseccion() {
		return idseccion;
	}
	public void setIdseccion(Seccion idseccion) {
		this.idseccion = idseccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
