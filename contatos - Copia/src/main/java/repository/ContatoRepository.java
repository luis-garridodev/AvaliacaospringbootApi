package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Contato;


public interface ContatoRepository extends JpaRepository<Contato, Long>{
	public List<Contato> findBynome(String nome);
	public Contato findByid(Long id);
	
}


