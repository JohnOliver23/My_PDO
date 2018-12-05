package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public abstract class Pagamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private  double valorpago;
	
	public Pagamento (){};
	public Pagamento(double valor) {
		super();
		this.valorpago = valor;
	}
	
	
	
	public double getValorpago() {
		return valorpago;
	}



	public void setValorpago(double valorpago) {
		this.valorpago = valorpago;
	}



	public abstract void calcularPagamento(double totalconta);
	
	public double calcularGorjeta() {
		return (valorpago*10)/100;
	}

	@Override
	public String toString() {
		return "Pagamento [valorpago=" + valorpago + "]";
	}
		
	
	
}

