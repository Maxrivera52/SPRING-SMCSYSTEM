package com.idat.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="nivel")
@Data @AllArgsConstructor @NoArgsConstructor

public class Nivel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idnivel;
	@Column (name="nombre")
	private String nombre;
	@Column (name="estado")
	private String estado;

}
