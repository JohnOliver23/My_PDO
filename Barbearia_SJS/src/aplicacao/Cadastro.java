package aplicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Barbeiro;
import model.Cliente;
import model.Pessoa;

public class Cadastro {
	protected static EntityManager manager;
	public Cadastro(){
		Pessoa p1;
		
		try {
		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("barbearia");
		manager = factory.createEntityManager();

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
		manager.getTransaction().begin();
		p1 = new Pessoa("Pepeu","Silva", formatter.parse("1993-10-01"));
		manager.persist(p1);
		manager.getTransaction().commit();
		/*
		
		manager.getTransaction().begin();
		p1 = new Barbeiro("Pedrinho ","Cherry","9945-4585" );
		manager.persist(p1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		p1 = new Cliente("Murivaldo ","Zebra","9447-2558" );
		manager.persist(p1);
		manager.getTransaction().commit();*/

		
		
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

