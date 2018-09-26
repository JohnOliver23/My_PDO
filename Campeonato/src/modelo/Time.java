package modelo;

import java.util.ArrayList;

public class Time {
	private int id;
	private String nome;
	private int SG;
	private int GP;
	private int GS;
	private int pontos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int numjogos;
	private Liga liga;
	private ArrayList<Jogo> jogos = new ArrayList<>();
	/*constructor*/
	
	public Time(int id, String nome, Time time) {
		super();
		this.id = id;
		this.nome = nome;
		this.liga = liga;
	}
	
	/*getters and setters */
	
	public int getId() {
		return id;
	}
	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
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
	public int getSG() {
		return SG;
	}
	public void setSG(int sG) {
		SG = sG;
	}
	public int getGP() {
		return GP;
	}
	public void setGP(int gP) {
		GP = gP;
	}
	public int getGS() {
		return GS;
	}
	public void setGS(int gS) {
		GS = gS;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getJogos() {
		return numjogos;
	}
	public void setJogos(int jogos) {
		this.numjogos = jogos;
	}
	
	/*remove and add */
	public void adicionar(Jogo jogo) {
		jogos.add(jogo);
	}
	
	public void remover (Jogo jogo) {
		jogos.remove(jogo);
	}
	
	/*localizar */
	public Jogo localizarJogo(int id) {
		for(Jogo j : jogos) {
			if(j.getId() == id) {
				return j;
			}
		}
		return null;
	}
	/*toString */

	@Override
	public String toString() {
		String texto =  "Time [id=" + id + ", nome=" + nome + ", SG=" + SG + ", GP=" + GP + ", GS=" + GS + ", pontos=" + pontos
				+ ", vitorias=" + vitorias + ", empates=" + empates + ", derrotas=" + derrotas + ", numjogos="
				+ numjogos + ", liga=" + liga.getNome() + "]";
		return texto;
	}
	
	
	
	

}
