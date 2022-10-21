package model;

public class Email {
	private long id;
	private String endereco;
	private  CategoriaEmail categoriaEmail;
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public CategoriaEmail getCategoriaEmail() {
		return categoriaEmail;
	}
	public void setCategoriaEmail(CategoriaEmail categoriaEmail) {
		this.categoriaEmail = categoriaEmail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
