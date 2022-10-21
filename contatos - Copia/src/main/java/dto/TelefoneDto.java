package dto;

import java.util.List;
import java.util.stream.Collectors;



import model.CategoriaTelefone;
import model.Telefone;

public class TelefoneDto {
	private long id;
	private String numero;
	private CategoriaTelefone categoriaTelefone;
	public TelefoneDto() {
		
	}
public TelefoneDto(Telefone telefone) {
	this.id=telefone.getId();
	this.numero=telefone.getNumero();
	this.categoriaTelefone=telefone.getCategoriaTelefone();
	
		
	}
public Telefone getTelefone() {
	Telefone telefone=new Telefone();
	telefone.setId(id);
	telefone.setNumero(numero);
	telefone.setCategoriaTelefone(categoriaTelefone);
	return telefone;
}
public static List<TelefoneDto> converter(List<Telefone> telefone) {
	return telefone.stream().map(Telefone -> new TelefoneDto()).collect(Collectors.toList());
}
}
