package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Conta", uniqueConstraints = @UniqueConstraint(
		columnNames= {"numero"}))
public class Conta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int numero;
	
	@Temporal(TemporalType.DATE)
	private Date dtfechamento;
	
	private double total;
	private Pagamento pagamento;
	
	public Conta () {};
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getDtfechamento() {
		return dtfechamento;
	}

	public void setDtfechamento(Date dtfechamento) {
		this.dtfechamento = dtfechamento;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", dtfechamento=" + dtfechamento + ", total=" + total + ", pagamento="
				+ pagamento + "]";
	}
	
	
	

}
