package model;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("3")
public class Barbeiro extends Pessoa  {
	private boolean ocupado;
	@OneToMany(mappedBy="Barbeiro", cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	//construtor vazio
	public Barbeiro() {};
	
	public Barbeiro(String nome, String sobrenome, Date date) {
		super(nome, sobrenome, date);
	}

	public int getSizeServicos() {
		return servicos.size();
	}
	public ArrayList<Servico> getServicos(){
		return servicos;
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
		String texto = "";
		if(ocupado) {
			texto = ", (ocupado)";
		}
		return super.toString()+texto;
	}
	
}
