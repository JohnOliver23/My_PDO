package model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name="Servico", uniqueConstraints = @UniqueConstraint(
		columnNames= {"id"}))
public class Servico {
@Id		
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne
private Barbeiro barbeiro;
@ManyToOne
private Tipo tipo;
@ManyToOne
Conta conta;
@Temporal(TemporalType.TIMESTAMP)
private Date dthorario;


public Date getDthorario() {
	return dthorario;
}

public void setDthorario(Date dthorario) {
	this.dthorario = dthorario;
}

public Servico(){};

public Servico(Barbeiro barbeiro, Tipo tipo, Conta c) {
	this.dthorario = new Date();
	this.barbeiro = barbeiro;
	this.tipo = tipo;
	this.conta = c;
}


public Barbeiro getBarbeiro() {
	return barbeiro;
}

public void setBarbeiro(Barbeiro barbeiro) {
	this.barbeiro = barbeiro;
}


public Tipo getTipo() {
	return tipo;
}

public void setTipo(Tipo tipo) {
	this.tipo = tipo;
}
public Conta getConta() {
	return conta;
}

public void setConta(Conta conta) {
	this.conta = conta;
}




@Override
public String toString() {
	return "Servico [id=" + id + ", barbeiro= " + barbeiro.getNome() + ", tipo=" + tipo.getNome() + "]";
}







}
