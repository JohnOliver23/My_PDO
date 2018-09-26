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
	private ArrayList<Time> times = new ArrayList<>();
	
	
	/*constructors*/
	public Jogo(int id, Time timeMandante, Time timeVisitante, int placarMandante, int placarVisitante,
			Date dataHorario) {
		super();
		this.id = id;
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
		this.placarMandante = placarMandante;
		this.placarVisitante = placarVisitante;
		this.dataHorario = dataHorario;
	}
	
	
	
	public Jogo(int id, Time timeMandante, Time timeVisitante, Date dataHorario) {
		super();
		this.id = id;
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
		this.dataHorario = dataHorario;
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

	public ArrayList<Time> getTimes() {
		return times;
	}
	
	
	/*remove and add */
	public void adicionar(Time time) {
		times.add(time);
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


	

}
