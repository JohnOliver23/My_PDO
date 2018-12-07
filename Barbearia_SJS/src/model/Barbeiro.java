package model;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
public class Barbeiro extends Pessoa  {
	private boolean ocupado;
	@OneToMany(mappedBy="Barbeiro", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)  
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	//construtor vazio
	public Barbeiro() {};
	
	public Barbeiro(String nome, String sobrenome, Date date) {
		super(nome, sobrenome, date);
	}

	
	public void adicionar(Servico s) {
		servicos.add(s);
	}
	
	public void remover(Servico s) {
		servicos.remove(s);
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return super.toString()+"ocupado"+ocupado;
	}
	
}
