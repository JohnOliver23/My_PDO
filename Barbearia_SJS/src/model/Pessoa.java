package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
@Entity 
@Table(name="Pessoa", uniqueConstraints = @UniqueConstraint(
		columnNames= {"id"}))
public class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30, unique=false, nullable=false,
			insertable=true, updatable=true)
	private String nome;
	
	@Column(length=50, unique=false, nullable=false,
			insertable=true, updatable=true)
	private String sobrenome;
	
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
