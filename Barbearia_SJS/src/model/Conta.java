package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Conta", uniqueConstraints = @UniqueConstraint(
		columnNames= {"id"}))
public class Conta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dtfechamento;
	
	private double total;
	@OneToOne
	private Pagamento pagamento;
	@ManyToOne
	private Cliente cliente;
	
	//RELACIONAMENTO BIDIRECIONAL
	@OneToMany(mappedBy="conta", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)   
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	public Conta () {};

	public Conta (Cliente c) {
		this.cliente = c;
	};
	
	

	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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
		return "Conta [id=" + id + ", dtfechamento=" + dtfechamento + ", total=" + total + ", pagamento="
				+ pagamento + "]";
	}
	
	
	

}
