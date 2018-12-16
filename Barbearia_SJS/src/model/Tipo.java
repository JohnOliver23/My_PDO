package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Tipo", uniqueConstraints = @UniqueConstraint(
		columnNames= {"id"}))
public class Tipo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=30, unique=true, nullable=false,
			insertable=true, updatable=true)
	private String nome;
	
	private double preco;
	@OneToMany(mappedBy="tipo", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)   
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	
	public Tipo() {};
	
	
	public Tipo(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		String texto = "Tipo [id=" + id + ", nome= " + nome + ", preco= " + preco ;
		for(Servico s: servicos) {
			texto+=", Barbeiro : "+s.getBarbeiro().getNome();
			texto+=", Cliente : "+s.getConta().getCliente().getNome();
		}
				texto+="]";
				return texto;
	}
	
	

}
