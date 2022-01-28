package com.idat.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recoveryaccount")
@Data @AllArgsConstructor @NoArgsConstructor
public class RecoveryAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "email",length = 60)
	String email;
	@Column(name = "keycode",length = 60)
	String keycode;
}
