package model;

public class Pessoa {
	private int id;
	private String nome;
	private String celular;
	
	public Pessoa(int id, String nome, String celular) {
		this.id = id;
		this.nome = nome;
		this.celular = celular;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", celular=" + celular + "]";
	}
	
	
}
