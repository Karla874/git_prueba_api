package com.prueba.prueba_api.model;

import java.lang.IllegalArgumentException;

public class Usuario {
	//Parametros
	private Long id;
	private String name;
	private String email;

	//Get
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	//Set
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("Email inválido");
		}
		this.email = email;
	}

	//Constructor
	public Usuario() {} // Para Spring

	public Usuario (Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//toString
	@Override
	public String toString() {
		return "Usuario {id="+id+", name="+name+", email="+email+"}";
	}
}