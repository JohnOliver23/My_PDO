package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo",  discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
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
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public abstract void calcularPagamento(double totalconta);
	
	public double calcularGorjeta() {
		return (valorpago*10)/100;
	}
	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", valorpago=" + valorpago + "]";
	}

	
		
	
	
}

