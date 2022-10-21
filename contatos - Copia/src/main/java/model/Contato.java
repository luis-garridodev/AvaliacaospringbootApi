package model;

import java.util.List;

public class Contato {
	private String nome;
	private long id;
	
	private List<Telefone> telefones; 
	private List<Email> emails;
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
