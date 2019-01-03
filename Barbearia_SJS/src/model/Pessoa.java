package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo",  discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Pessoa {
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDatanasc() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) this.datanasc);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String dayParse = Integer.toString(day);
		String monthParse = Integer.toString(month);
		if(dayParse.length()==1) {
			dayParse = "0"+dayParse;
		}
		if(monthParse.length()==1) {
			monthParse = "0"+monthParse;
		}
		return dayParse+"/"+monthParse+"/"+year;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30, unique=false, nullable=false,
			insertable=true, updatable=true)
	private String nome;
	
	@Column(length=50, unique=false, nullable=false,
			insertable=true, updatable=true)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	private Date datanasc;
	
	//construtor vazio
	public Pessoa (){}
	
	public Pessoa(String nome, String sobrenome, Date data) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanasc = data;
		
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
	

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return this.getClass().getSimpleName() +" : "+ nome +" "+sobrenome+ ", Data de nascimento : "+this.getDatanasc();
	}


	
}
