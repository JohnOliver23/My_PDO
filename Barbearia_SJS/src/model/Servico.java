package model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Servico", uniqueConstraints = @UniqueConstraint(
		columnNames= {"idBarbeiro, idCliente, tipo"}))
public class Servico {
@Id
private int idBarbeiro;
@Id
private int idCliente;
@Temporal(TemporalType.DATE)
private Date data;
@Id
private int tipo;


public Servico(){};

public Servico(int barbeiro, int cliente, Date data, int tipo) {
	
	this.idBarbeiro = barbeiro;
	this.idCliente = cliente;
	this.data = data;
	this.tipo = tipo;
}




public int getIdBarbeiro() {
	return idBarbeiro;
}




public void setIdBarbeiro(int idBarbeiro) {
	this.idBarbeiro = idBarbeiro;
}




public int getIdCliente() {
	return idCliente;
}




public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}






public Date getData() {
	return data;
}




public void setData(Date data) {
	this.data = data;
}




public int getTipo() {
	return tipo;
}




public void setTipo(int tipo) {
	this.tipo = tipo;
}




@Override
public String toString() {
	return "Servico [idBarbeiro=" + idBarbeiro + ", idCliente=" + idCliente + ", data=" + data + ", tipo=" + tipo + "]";
}


}
