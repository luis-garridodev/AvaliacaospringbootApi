package com.example.contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.contatos.entity.Telefone;



public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	
}
