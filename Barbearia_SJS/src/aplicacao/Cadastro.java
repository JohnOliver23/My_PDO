package aplicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fachada.Fachada;
import model.Barbeiro;
import model.Cliente;
import model.Conta;
import model.Pessoa;
import model.Servico;
import model.Tipo;

public class Cadastro {
	public Cadastro(){
		try {
		// INSTANCIAÇÃO DO MANAGER--------------------------------
			Fachada.inicializar();

//		PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
			/*
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("===================================");
			System.out.println("Cadastrando Pessoa");
			
			Pessoa p1 = Fachada.cadastrarPessoa("Pepeu", "Silva", formatter.parse("1996-05-11"));
			
			System.out.println("===================================");
			System.out.println("Cadastrando Barbeiro");
			Barbeiro b = Fachada.cadastrarBarbeiro("Pedro", "Ricardo", formatter.parse("1995-10-01"));
			
			System.out.println("===================================");
			System.out.println("Cadastrando Cliente");
			Cliente c  = Fachada.cadastrarCliente("Murivaldo", "Ynho", formatter.parse("1990-05-01"));
			*/
			System.out.println("===================================");
			System.out.println("Cadastrando Tipos");
			Tipo t  = Fachada.cadastrarTipos("Corte de cabelo", 15.00);
			t  = Fachada.cadastrarTipos("Barba", 10.00);
			t  = Fachada.cadastrarTipos("Combo (Corte e Barba)", 22.00);
			t  = Fachada.cadastrarTipos("Lavagem", 10.00);
			
			
		
		Fachada.finalizar();
		/*


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
		
		/*
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
		*/
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Cadastro();
	}
	

}

