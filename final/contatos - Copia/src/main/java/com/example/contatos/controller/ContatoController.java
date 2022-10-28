package com.example.contatos.controller;
 import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.contatos.dto.ContatoDto;
import com.example.contatos.entity.Contato;
import com.example.contatos.repository.ContatoRepository;
import com.example.contatos.service.ContatoService;



@RestController
@RequestMapping("/contato")
public class ContatoController {
	@Autowired
	ContatoService service;

	@GetMapping
	public List<ContatoDto> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> procurarPorId(@PathVariable String id) {
		return service.procurarPorId(id);

	}

	@PostMapping
	public ResponseEntity<ContatoDto> cadastrar(@RequestBody ContatoDto contatoDto, UriComponentsBuilder uriBuilder) {
		
		return service.cadastrar(contatoDto, uriBuilder);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarPorId(@PathVariable Long id, @RequestBody ContatoDto contatoDto) {
		return service.atualizarPorId(id, contatoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
		
		return service.deletarPorId(id);

	}

}
///
