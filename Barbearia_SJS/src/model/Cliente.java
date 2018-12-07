package model;

import java.util.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
public class Cliente extends Pessoa{
	

	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)  
	private ArrayList<Conta> contas = new ArrayList<>();
	
	//construtor vazio
	public Cliente(){};
	
	
	public Cliente(String nome, String sobrenome, Date data) {
		super(nome, sobrenome, data);
	}
	
	
	public void adicionar(Conta c) {
		contas.add(c);
	}
	
	public void remover(Conta c) {
		contas.remove(c);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
