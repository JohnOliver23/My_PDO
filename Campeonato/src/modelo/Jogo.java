package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Jogo {


	private int id;
	private Time timeMandante;
	private Time timeVisitante;
	private int placarMandante;
	private int placarVisitante;
	private Date dataHorario;
	private Estadio estadio;
	
	
	/*constructors*/
	
	
	public Jogo(int id, Time timeMandante, Time timeVisitante, Date dataHorario, Estadio estadio) {
		super();
		this.id = id;
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
		this.dataHorario = dataHorario;
		this.estadio = estadio;
	}

	/*getters and setters */

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Time getTimeMandante() {
		return timeMandante;
	}
	public void setTimeMandante(Time timeMandante) {
		this.timeMandante = timeMandante;
	}
	public Time getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public int getPlacarMandante() {
		return placarMandante;
	}
	public void setPlacarMandante(int placarMandante) {
		this.placarMandante = placarMandante;
	}
	public int getPlacarVisitante() {
		return placarVisitante;
	}
	public void setPlacarVisitante(int placarVisitante) {
		this.placarVisitante = placarVisitante;
	}
	public Date getData() {
		return dataHorario;
	}

	public void setData(Date data) {
		this.dataHorario = data;
	}
	public Date getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(Date dataHorario) {
		this.dataHorario = dataHorario;
	}


	
	public void atualizaSaldoGols() {
		timeMandante.setSG(timeMandante.getGP() - timeMandante.getGS());
		timeVisitante.setSG(timeVisitante.getGP() - timeVisitante.getGS());
	}
	
	public void marcaGolMandante() {
		timeMandante.setGP(timeMandante.getGP()+1);
		placarMandante++;
		timeVisitante.setGS(timeVisitante.getGS()+1);
		placarVisitante--;
		atualizaSaldoGols();
	}
	
	public void marcaGolVisitante() {
		timeVisitante.setGP(timeVisitante.getGP()+1);
		placarVisitante++;
		timeMandante.setGS(timeMandante.getGS()+1);
		placarMandante--;
		atualizaSaldoGols();
		
	}
	
	public Time finalizarJogo() {
		if(placarMandante > placarVisitante) {
			timeMandante.setPontos(timeMandante.getPontos()+3);
			timeMandante.setVitorias(timeMandante.getVitorias()+1);
			timeVisitante.setDerrotas(timeVisitante.getDerrotas()+1);
			atualizaSaldoGols();
			return timeMandante;
		}else if(placarMandante < placarVisitante) {
			timeVisitante.setPontos(timeVisitante.getPontos()+3);
			timeVisitante.setVitorias(timeVisitante.getVitorias()+1);
			timeMandante.setDerrotas(timeMandante.getDerrotas()+1);
			atualizaSaldoGols();
			return timeVisitante;
		}else {
			timeMandante.setEmpates(timeMandante.getEmpates()+1);
			timeVisitante.setEmpates(timeVisitante.getEmpates()+1);
		}
		return null;
	}
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	
	
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", timeMandante=" + timeMandante.getNome() + ", timeVisitante=" + timeVisitante.getNome()
				+ ", placarMandante=" + placarMandante + ", placarVisitante=" + placarVisitante + ", dataHorario = "
				+ dataHorario.getTime()+ " estadio = "+estadio.getNome()+ "]";
	}


	

}
