package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="T_Usuario") 
public class Usuario {
	@Id
	private String email;
	private String nombre;
	private String password;
	
	public Usuario(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public Usuario() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
