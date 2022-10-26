package com.example.contatos.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.contatos.entity.CategoriaEmail;
import com.example.contatos.entity.Email;

public class EmailDto {
	private long id;
	private String endereco;
	private  CategoriaEmail categoriaEmail;
	public EmailDto(Email email) {
		this.id=email.getId();
		this.endereco=email.getEndereco();
		this.categoriaEmail=email.getCategoria();
	}
	
	
	
	public EmailDto() {
		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public CategoriaEmail getCategoria() {
		return categoriaEmail;
	}

	public void setCategoria(CategoriaEmail categoria) {
		this.categoriaEmail = categoria;
	}
	
}
