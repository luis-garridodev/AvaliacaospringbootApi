package com.example.contatos.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.contatos.entity.CategoriaTelefone;
import com.example.contatos.entity.Telefone;

public class TelefoneDto {
	private long id;
	private String numero;
	private CategoriaTelefone categoriaTelefone;

	public TelefoneDto() {

	}

	public TelefoneDto(Telefone telefone) {

		this.id = telefone.getId();

		this.numero = telefone.getNumero();

		this.categoriaTelefone = telefone.getCategoria();

	}

	public Telefone getTelefone() {
		Telefone telefone = new Telefone();
		telefone.setId(id);
		telefone.setNumero(numero);
		telefone.setCategoria(categoriaTelefone);
		return telefone;
	}

	public CategoriaTelefone getCategoriaTelefone() {
		return categoriaTelefone;
	}

	public void setCategoriaTelefone(CategoriaTelefone categoriaTelefone) {
		this.categoriaTelefone = categoriaTelefone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public static List<TelefoneDto> converter(List<Telefone> telefone) {
		return telefone.stream().map(Telefone -> new TelefoneDto()).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public CategoriaTelefone getCategoria() {
		return categoriaTelefone;
	}
}
