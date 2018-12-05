package model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Cliente extends Pessoa{
	
	//RELACIONAMENTO BIDIRECIONAL
	@OneToMany(mappedBy="Pessoa", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)   
	private ArrayList<Servico> servicos = new ArrayList<>();
	@OneToMany(mappedBy="Pessoa", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)  
	private ArrayList<Conta> contas = new ArrayList<>();
	
	//construtor vazio
	public Cliente(){};
	
	
	public Cliente(String nome, String sobrenome, Date data) {
		super(nome, sobrenome, data);
	}
	
	
	public void adicionar(Servico s) {
		servicos.add(s);
	}
	
	public void remover(Servico s) {
		servicos.remove(s);
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
