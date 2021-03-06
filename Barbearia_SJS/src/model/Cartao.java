package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Cartao extends Pagamento {
	private String cartao;
	private int quantidadeparcelas;
	
	public Cartao() {};
	
	
	public Cartao(double valor, String card, int qtdparc) {
		super(valor);
		cartao = card;
		quantidadeparcelas = qtdparc;
		
	}
	
	@Override
	public void calcularPagamento(double totalconta) {
		if(quantidadeparcelas ==1){
			setValorpago(totalconta);
		}else if(quantidadeparcelas ==2 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta);
		 }else if(quantidadeparcelas ==3 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta+(totalconta*10)/100);
		 }else if (quantidadeparcelas ==4 && totalconta/quantidadeparcelas >=100) {
			 setValorpago(totalconta+(totalconta*20)/100);
		 }
	}

	@Override
	public String toString() {
		return "PagamentoCartão"+"[cartao=" + cartao + ", quantidadeparcelas= " + quantidadeparcelas +
				", valor de cada parcela= "+getValorpago()/quantidadeparcelas+" "+super.toString()+ "]";
	}
	
	
}
