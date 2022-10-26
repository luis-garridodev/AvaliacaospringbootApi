package com.example.contatos.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.contatos.dto.ContatoDto;
import com.example.contatos.dto.EmailDto;
import com.example.contatos.dto.TelefoneDto;
import com.example.contatos.entity.Contato;
import com.example.contatos.entity.Email;
import com.example.contatos.entity.Telefone;
import com.example.contatos.repository.ContatoRepository;
import com.example.contatos.repository.EmailRepository;
import com.example.contatos.repository.TelefoneRepository;





@Service
public class ContatoService {


	@Autowired
	ContatoRepository repository;

	@Autowired
	TelefoneRepository telRepository;

	@Autowired
	EmailRepository emailRepository;
	
	
	public List<ContatoDto> converter(List<Contato> lista){
		return lista.stream().map(ContatoDto::new).collect(Collectors.toList());
	}
	
	public List<ContatoDto> listar() {
		return this.converter(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> procurarPorId(String id) {
		try {
			Long meuId = Long.parseLong(id);
			Optional<Contato> contato = repository.findById(meuId);
			if (contato.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			ContatoDto ct = new ContatoDto(contato.get());
			List<ContatoDto> lista = new ArrayList<ContatoDto>();
			lista.add(ct);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(this.converter(repository.findByNomeContaining(id)), HttpStatus.OK);
		}

	}
	
	
	public ResponseEntity<ContatoDto> cadastrar(ContatoDto contatoDto, UriComponentsBuilder uriBuilder) {
		Contato contato=new Contato();
		contato.setNome(contatoDto.getNome());
		repository.save(contato);

		for (EmailDto emailDto : contatoDto.getEmails()) {
			Email emailNovo=new Email();
			emailNovo.setEndereco(emailDto.getEndereco());
			emailNovo.setCategoria(emailDto.getCategoria());
			emailNovo.setDono(contato);
			emailRepository.save(emailNovo);
			contato.getEmails().add(emailNovo);
		}
		for (TelefoneDto telefoneDto : contatoDto.getTelefones()) {
			Telefone telefoneNovo=new Telefone();
			telefoneNovo.setNumero(telefoneDto.getNumero());
			telefoneNovo.setCategoria(telefoneDto.getCategoria());
			telefoneNovo.setDono(contato);
			telRepository.save(telefoneNovo);
			contato.getTelefones().add(telefoneNovo);
		}
		
		URI uri = uriBuilder.path("/contatos/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContatoDto(contato));
	
	
	
	
	
	
	
	
	}
		
	
	public ResponseEntity<?> atualizarPorId(Long id, ContatoDto contatoDto) {

		Optional<Contato> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Contato contato = optional.get();
		contato.setNome(contatoDto.getNome());
		contato.getEmails().clear();
		contato.getTelefones().clear();
		
		for (EmailDto email : contatoDto.getEmails()) {
		 	Optional<Email> op=emailRepository.findById(email.getId());
		 	if(op.isEmpty()) {
		 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 	}
		 	Email mail=op.get();
			mail.setEndereco(email.getEndereco());
			mail.setCategoria(email.getCategoria());
			mail.setDono(contato);
			emailRepository.save(mail);
			contato.getEmails().add(mail);
		}
		 
		for (TelefoneDto telefone : contatoDto.getTelefones()) {
			Optional<Telefone> op=telRepository.findById(telefone.getId());
			
			if(op.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			Telefone telefoneNovo=op.get();
			telefoneNovo.setNumero(telefone.getNumero());
			telefoneNovo.setCategoria(telefone.getCategoria());
			telRepository.save(telefoneNovo);
			contato.getTelefones().add(telefoneNovo);
		}
		repository.save(contato);
		
		return new ResponseEntity<>(new ContatoDto(contato), HttpStatus.OK);

	}
	
	public ResponseEntity<?> deletarPorId(@PathVariable Long id) {

		Optional<Contato> optional =repository.findById(id); 
				
		if (optional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Contato contato = optional.get();
		ResponseEntity<?> entity=new ResponseEntity<>(new ContatoDto(contato), HttpStatus.OK);
		
		for (Email email : contato.getEmails()) {
			emailRepository.deleteById(email.getId());
		}
		
		for (Telefone telefone : contato.getTelefones()) {
			telRepository.deleteById(telefone.getId());
		}
		
		repository.deleteById(id);
		
		return entity;

	}
	
}
