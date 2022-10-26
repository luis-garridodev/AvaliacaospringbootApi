package com.example.contatos.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity(name="emails")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		 
	@Enumerated(EnumType.STRING)
	private CategoriaEmail categoria;
	
	private String endereco;
	
	@ManyToOne
	private Contato dono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaEmail getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEmail categoria) {
		this.categoria = categoria;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Contato getDono() {
		return dono;
	}

	public void setDono(Contato dono) {
		this.dono = dono;
	}

	public Email() {
	
	}
}
	