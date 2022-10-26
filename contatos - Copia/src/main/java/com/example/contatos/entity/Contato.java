package com.example.contatos.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.contatos.dto.EmailDto;
import com.example.contatos.dto.TelefoneDto;






@Entity
@Table(name = "contatos")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "dono")
	private List<Telefone> telefones= new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "dono")
	private List<Email> emails= new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	} 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
