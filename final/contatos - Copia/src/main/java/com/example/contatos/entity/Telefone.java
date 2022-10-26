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



@Entity(name="telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		 
	@Enumerated(EnumType.STRING)
	private CategoriaTelefone categoria;
	
	private String numero;
	
	@ManyToOne
	private Contato dono;
	
	public Telefone() {
		
	}
	
	

	public Contato getDono() {
		return dono;
	}



	public void setDono(Contato dono) {
		this.dono = dono;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaTelefone getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTelefone categoria) {
		this.categoria = categoria;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}

