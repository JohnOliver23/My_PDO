package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Jogo {


	private int id;
	private Time timeMandante;
	private Time timeVisitante;
	private int placarMandante;
	private int placarVisitante;
	private Date dataHorario;
	private Estadio estadio;
	private ArrayList<Time> times = new ArrayList<>();
	private boolean finalizado = false;
	
	
	/*constructors*/
	
	
	public Jogo(int id, Time timeMandante, Time timeVisitante, Estadio estadio, Date dataHorario) {
		super();
		this.id = id;
		this.timeMandante = timeMandante;
		this.timeVisitante = timeVisitante;
		this.estadio = estadio;
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
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	
	
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
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
	
	public void atualizaSaldoGols() {
		timeMandante.setSG(timeMandante.getGP() - timeMandante.getGS());
		timeVisitante.setSG(timeVisitante.getGP() - timeVisitante.getGS());
	}
	
	public void marcaGolMandante() {
		timeMandante.setGP(timeMandante.getGP()+1);
		placarMandante++;
		timeVisitante.setGS(timeVisitante.getGS()+1);
		atualizaSaldoGols();
	}
	
	public void marcaGolVisitante() {
		timeVisitante.setGP(timeVisitante.getGP()+1);
		placarVisitante++;
		timeMandante.setGS(timeMandante.getGS()+1);
		atualizaSaldoGols();
		
	}
	
	public Time finalizarJogo() {
		if(placarMandante > placarVisitante) {
			timeMandante.setPontos(timeMandante.getPontos()+3);
			timeMandante.setVitorias(timeMandante.getVitorias()+1);
			timeVisitante.setDerrotas(timeVisitante.getDerrotas()+1);
			atualizaSaldoGols();
			finalizado = true;
			return timeMandante;
		}else if(placarMandante < placarVisitante) {
			timeVisitante.setPontos(timeVisitante.getPontos()+3);
			timeVisitante.setVitorias(timeVisitante.getVitorias()+1);
			timeMandante.setDerrotas(timeMandante.getDerrotas()+1);
			atualizaSaldoGols();
			finalizado = true;
			return timeVisitante;
		}else {
			timeMandante.setPontos(timeMandante.getPontos()+1);
			timeVisitante.setPontos(timeVisitante.getPontos()+1);
			timeMandante.setEmpates(timeMandante.getEmpates()+1);
			timeVisitante.setEmpates(timeVisitante.getEmpates()+1);
			finalizado = true;
		}
		return null;
	}
	

	@Override
	public String toString() {
		String texto = timeMandante.getNome()+" " +placarMandante+" X "+placarVisitante+
				 " "+timeVisitante.getNome();
		texto+="\nEstadio = "+estadio.getNome();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataHorario); //aqui você usa sua variável que chamei de "minhaData"
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int mes = calendar.get(Calendar.MONTH)+1;
		int ano = calendar.get(Calendar.YEAR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String minutes = Integer.toString(calendar.get(Calendar.MINUTE));
		String data = dia+"/"+mes+"/"+ano;
		texto+="\nData = "+data;
		texto+="\nHorario = "+hour+":"+minutes;
		texto+="\nFinalizado = "+finalizado+"\n\n";
		return texto;
	}


	

}
