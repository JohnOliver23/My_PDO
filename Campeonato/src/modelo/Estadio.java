package modelo;

import java.util.ArrayList;

public class Estadio {
	private int id;
	private String nome;
	private ArrayList<Jogo> jogos = new ArrayList<>();
	

	/*constructor*/
	public Estadio(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	/*getters and setters */
	
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
	
	/*remove and add */
	public void adicionar(Jogo jogo) {
		jogos.add(jogo);
	}
	
	public void remover(Jogo jogo) {
		jogos.remove(jogo);
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + "\n";
	}

	
	
}
