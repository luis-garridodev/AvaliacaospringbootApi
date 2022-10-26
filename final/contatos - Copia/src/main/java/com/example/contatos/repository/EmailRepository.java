package com.example.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.contatos.entity.Email;



public interface EmailRepository extends JpaRepository<Email, Long> {

}
