package dto;

import java.util.List;
import java.util.stream.Collectors;



import model.CategoriaEmail;
import model.Email;

public class EmailDto {
	private long id;
	private String endereco;
	private  CategoriaEmail categoriaEmail;
	public EmailDto() {
		
	}
public EmailDto(Email email) {
	this.id=email.getId();
	this.endereco=email.getEndereco();
	this.categoriaEmail=email.getCategoriaEmail();
		
	}
public Email getEmail() {
	Email email=new Email();
	email.setId(id);
	email.setEndereco(endereco);
	email.setCategoriaEmail(categoriaEmail);
	return email;
}
public static List<EmailDto> converter(List<Email> email) {
	return email.stream().map(Email -> new EmailDto()).collect(Collectors.toList());
}
	
}
