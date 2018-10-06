package modelo;

import java.util.ArrayList;

public class Liga {
	private int id;
	private String nome;
	private String serie;
	private ArrayList<Time> times = new ArrayList<>();
	


	/*constructor*/
	public Liga(int id, String nome, String serie) {
		super();
		this.id = id;
		this.nome = nome;
		this.serie = serie;
	}
	
	/*getters and setters */
	public ArrayList<Time> getTimes() {
		return times;
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
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	/*remove and add */
	public void adicionar(Time time) {
		times.add(time);
		time.setLiga(this);
	}
	
	public void remover (Time time) {
		times.remove(time);
	}
	
	/*localizar */
	public Time localizarTime(String nome) {
		for(Time t : times) {
			if(t.getNome().equals(nome)) {
				return t;
			}
		}
		return null;
	}
	public String classificacao(){
		String texto ="";
		for(Time t: times) {
			texto+= t.getNome()+" "+t.getPontos()+" "+t.getJogos()+" "+t.getVitorias()+" "+
			t.getDerrotas()+" "+t.getEmpates()+" "+t.getGP()+" "+t.getSG()+" "+t.getGS()+"\n";
		}
		return texto;
	}
	
	/*toString*/
	@Override
	public String toString() {
		String texto = "id= " + id + "\nnome= " + nome + "\nserie= " + serie + ",\ntimes= \n";
		for(Time t: times) {
			texto+=t.getNome()+"\n";
		}
				texto+="\n";
				return texto;
	}
	
	
	
	

}
