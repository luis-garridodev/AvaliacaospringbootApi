package controller;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dto.ContatoDto;
import repository.ContatoRepository;



@RestController
@RequestMapping("/Contato")
public class ContatoController {
	@Autowired
	public ContatoRepository repository;
	@GetMapping
	public List<ContatoDto>ListarContatos(){
		return ContatoDto.converter(repository.findAll());
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<ContatoDto> findById(@org.springframework.web.bind.annotation.PathVariable Long id){
		ContatoDto contatoDto = new ContatoDto (repository.findById(id).get());
		
		if (contatoDto!=null) {
	        return new ResponseEntity<>(contatoDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


}
