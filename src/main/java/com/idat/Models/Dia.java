package com.idat.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dia")
@Data @AllArgsConstructor @NoArgsConstructor
public class Dia {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int iddia;
	private String descripcion;
	

}
