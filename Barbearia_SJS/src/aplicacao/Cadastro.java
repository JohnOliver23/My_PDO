package aplicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Barbeiro;
import model.Cliente;
import model.Conta;
import model.Pessoa;
import model.Servico;
import model.Tipo;

public class Cadastro {
	protected static EntityManager manager;
	public Cadastro(){
		Pessoa p1;
		Tipo t = null;
		Conta c = null;
		Servico s;
		Barbeiro b = null;
		try {
		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("barbearia");
		manager = factory.createEntityManager();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
		/*
		manager.getTransaction().begin();
		p1 = new Pessoa("Pepeu","Silva", formatter.parse("1993-10-01"));
		manager.persist(p1);
		manager.getTransaction().commit();
		
//		INSERINDO BARBEIRO
		manager.getTransaction().begin();
		p1 = new Barbeiro("Pedro","Ricardo",formatter.parse("1996-05-11"));
		manager.persist(p1);
		manager.getTransaction().commit();
		
//		INSERINDO CLIENTE
		manager.getTransaction().begin();
		p1 = new Cliente("Murivaldo ","Zebra",formatter.parse("1991-08-05"));
		manager.persist(p1);
		manager.getTransaction().commit();

//		CADASTRANDO TIPOS DE SERVICOS
		manager.getTransaction().begin();
		t = new Tipo("Corte ",15.00);
		manager.persist(t);
		manager.getTransaction().commit();	
		
		manager.getTransaction().begin();
		t = new Tipo("Barba ",8.00);
		manager.persist(t);
		manager.getTransaction().commit();	
		
		manager.getTransaction().begin();
		t = new Tipo("Combo (Corte e Barba) ",20.00);
		manager.persist(t);
		manager.getTransaction().commit();	
*/
//		CADASTRANDO CONTAS
		
		//consultando o cliente
		Query query = manager.createQuery("select c from Cliente c");
		List<Cliente> resultados3 = (List<Cliente>) query.getResultList();
		for(Cliente c1: resultados3) {
			manager.getTransaction().begin();
			c = new Conta(c1);
			manager.persist(c);
			manager.getTransaction().commit();	
		}

//		CONSULTANO A CONTA
		query = manager.createQuery("select c from Conta c");
		List<Conta> resultados4 = (List<Conta>) query.getResultList();
		for(Conta c1: resultados4) {
			c = c1;
		}
//		CONSULTANO O BARBEIRO
		query = manager.createQuery("select b from Barbeiro b");
		List<Barbeiro> resultados5 = (List<Barbeiro>) query.getResultList();
		for(Barbeiro b1: resultados5) {
			b = b1;
		}	
// 		CONSULTANDO O TIPO
		query = manager.createQuery("select t from Tipo t ");
		List<Tipo> resultados6 = (List<Tipo>) query.getResultList();
		for(Tipo t1: resultados6) {
			t = t1;
		}
		manager.getTransaction().begin();
		s = new Servico(b,t,c);
		manager.persist(s);
		manager.getTransaction().commit();
				
		
		
		
		manager.close();
		factory.close();
		System.out.println("fim da aplicação");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Cadastro();
	}
	

}

