package model;

public class Telefone {
	private long id;
	private String numero;
	private CategoriaTelefone categoriaTelefone;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CategoriaTelefone getCategoriaTelefone() {
		return categoriaTelefone;
	}
	public void setCategoriaTelefone(CategoriaTelefone categoriaTelefone) {
		this.categoriaTelefone = categoriaTelefone;
	}
}
