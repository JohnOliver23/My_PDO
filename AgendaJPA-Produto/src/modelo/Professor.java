package modelo;


import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {
	private double salario;

	public Professor() {}
	public Professor(String nome, Sexo sexo, double sal) {
		super(nome, sexo);
		this.salario = sal;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return super.toString() + "  salario=  "+ salario;
	}

	

	

	
}
