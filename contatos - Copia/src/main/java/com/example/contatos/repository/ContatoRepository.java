package com.example.contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contatos.entity.Contato;


public interface ContatoRepository extends JpaRepository<Contato, Long>{
	public List<Contato> findByNomeContaining(String titulo);

	
}


