package model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
@Entity
public class Barbeiro extends Pessoa  {
	private boolean ocupado;
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	//construtor vazio
	public Barbeiro() {};
	
	public Barbeiro(String nome, String sobrenome, Date data) {
		super(nome, sobrenome, data);
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
