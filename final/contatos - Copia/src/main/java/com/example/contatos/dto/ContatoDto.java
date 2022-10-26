package com.example.contatos.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.contatos.entity.Contato;
import com.example.contatos.entity.Email;
import com.example.contatos.entity.Telefone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ContatoDto {

	private Long id;
	private String nome;
	private List<TelefoneDto> telefones;
	private List<EmailDto> emails;
	
	public ContatoDto() {
		
	}
	
	public ContatoDto(Contato contato) {
		this.id=contato.getId();
		this.nome=contato.getNome();
		this.telefones=contato.getTelefones().stream().map(TelefoneDto::new).collect(Collectors.toList());
		this.emails=contato.getEmails().stream().map(EmailDto::new).collect(Collectors.toList());
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TelefoneDto> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDto> telefones) {
		this.telefones = telefones;
	}

	public List<EmailDto> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailDto> emails) {
		this.emails = emails;
	}	
	

}
