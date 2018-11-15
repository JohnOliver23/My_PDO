package model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	private ArrayList<Servico> servicos = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();
	public Cliente(int id, String nome, String celular) {
		super(id, nome, celular);
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
		return "Cliente [id= "+super.getId()+"nome= "+super.getNome()+" celular= "+
				super.getCelular()+"]";
	}
	
}
