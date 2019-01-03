package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Dinheiro extends Pagamento {
	private int percentualdesconto;
	
	
	public Dinheiro () {};
	public Dinheiro(double valor, int percentual) {
		super(valor);
		percentualdesconto = percentual;
	}
	@Override
	public void calcularPagamento(double totalconta) {
		 setValorpago(totalconta - (totalconta*percentualdesconto)/100);
	}
	@Override
	public String toString() {
		return  "PagamentoDinheiro"+"[percentualdesconto= " + percentualdesconto +"% "+ super.toString()+"]";
	}
	public int getPercentualdesconto() {
		return percentualdesconto;
	}
	
	
}