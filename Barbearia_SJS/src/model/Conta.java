package model;

public class Conta {
	private int numero;
	private String dtfechamento;
	private double total;
	private Pagamento pagamento;
	
	public Conta(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDtfechamento() {
		return dtfechamento;
	}
	public void setDtfechamento(String dtfechamento) {
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
