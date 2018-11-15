package model;

public class Servico {
private int id;
private Barbeiro barbeiro;
private Cliente cliente;
private String data;
private Tipo tipo;




public Servico(int id, Barbeiro barbeiro, Cliente cliente, String data, Tipo tipo) {
	
	this.id = id;
	this.barbeiro = barbeiro;
	this.cliente = cliente;
	this.data = data;
	this.tipo = tipo;
}

public Tipo getTipo() {
	return tipo;
}

public void setTipo(Tipo tipo) {
	this.tipo = tipo;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}

@Override
public String toString() {
	return "Servico [id=" + id + ", barbeiro=" + barbeiro.getNome() + ", cliente=" + cliente.getNome() + ", data=" + data +"tipo="+tipo.getNome()+", preco = "+tipo.getPreco()+ "]";
}
}
