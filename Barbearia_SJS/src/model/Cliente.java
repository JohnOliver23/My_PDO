package model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	private ArrayList<Servico> servicos = new ArrayList<>();
	public Cliente(int id, String nome, String celular) {
		super(id, nome, celular);
	}
	
	public void adicionar(Servico s) {
		servicos.add(s);
	}
	
	public void remover(Servico s) {
		servicos.remove(s);
	}

	@Override
	public String toString() {
		return "Cliente [id= "+super.getId()+"nome= "+super.getNome()+" celular= "+
				super.getCelular()+"]";
	}
	
}
