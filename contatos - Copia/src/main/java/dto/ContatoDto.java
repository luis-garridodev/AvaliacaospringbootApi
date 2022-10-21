package dto;

import java.util.List;
import java.util.stream.Collectors;

import model.Contato;
import model.Email;
import model.Telefone;

public class ContatoDto {
	private String nome;
	private long id;
	
	private List<Telefone> telefones; 
	private List<Email> emails;
	public ContatoDto() {
		
	}
public ContatoDto(Contato contato) {
	this.id=contato.getId();
	this.emails=contato.getEmails();
	this.nome=contato.getNome();
	this.telefones=contato.getTelefones();
	
		
	}
public Contato getContato() {
	Contato contato=new Contato();
	contato.setEmails(emails);
	contato.setId(id);
	contato.setNome(nome);
	contato.setTelefones(telefones);
	return contato;
}
public static List<ContatoDto> converter(List<Contato> contato) {
	return contato.stream().map(Contato -> new ContatoDto()).collect(Collectors.toList());
}

	public static ContatoDto converter(Contato contato) {
		
		
		return new ContatoDto(contato);
}}
