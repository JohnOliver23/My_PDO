package model;

import java.util.ArrayList;

public class Barbeiro extends Pessoa  {
	private boolean ocupado;
	private ArrayList<Servico> servicos = new ArrayList<>();
	public Barbeiro(int id, String nome, String celular) {
		super(id, nome, celular);
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
		return "Barbeiro [id= "+super.getId()+"nome= "+super.getNome()+" celular= "+
				super.getCelular()+" "+"ocupado=" + ocupado + "]";
	}
	
}
