package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
public class Pessoa {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	String sobrenome;
	@Temporal(TemporalType.DATE)
	private Date datanasc;
	
	//construtor vazio
	public Pessoa (){}
	
	public Pessoa(String nome, String sobrenome, Date data) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanasc = data;
		
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
	

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return "Pessoa [id=" + id + ", nome=" + nome +"sobrenome="+sobrenome+ ",data cadastro= "+f.format(datanasc.getTime()) +"]";
	}


	
}
