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
private Cliente cliente;
@Temporal(TemporalType.DATE)
private Date data;
@ManyToOne
private Tipo tipo;


public Servico(){};

public Servico(Barbeiro barbeiro, Cliente cliente, Date data, Tipo tipo) {
	
	this.barbeiro = barbeiro;
	this.cliente = cliente;
	this.data = data;
	this.tipo = tipo;
}


public Barbeiro getBarbeiro() {
	return barbeiro;
}

public void setBarbeiro(Barbeiro barbeiro) {
	this.barbeiro = barbeiro;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Tipo getTipo() {
	return tipo;
}

public void setTipo(Tipo tipo) {
	this.tipo = tipo;
}

public Date getData() {
	return data;
}




public void setData(Date data) {
	this.data = data;
}







}
