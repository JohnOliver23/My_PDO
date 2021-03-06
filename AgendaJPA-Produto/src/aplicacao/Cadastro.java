package aplicacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Professor;
import modelo.Sexo;

public class Cadastro {
	protected static EntityManager manager;
	public Cadastro(){
		Pessoa p1;
		Produto pr1;
		
		// INSTANCIA��O DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		manager = factory.createEntityManager();

		
//		PERSIST�NCIA DOS OBJETOS NO BANCO-----------------------
		manager.getTransaction().begin();
		p1 = new Pessoa("joao", Sexo.MASCULINO);
		manager.persist(p1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		p1 = new Pessoa("maria", Sexo.FEMININO);
		manager.persist(p1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		p1 = new Pessoa("jose", Sexo.MASCULINO);
		manager.persist(p1);	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		p1 = new Aluno("paulo",Sexo.MASCULINO,9);
		manager.persist(p1);	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		p1 = new Professor ("fausto", Sexo.MASCULINO, 1000.00);
		manager.persist(p1);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		pr1 = new Produto("feij�o", 2.50, 10);
		manager.persist(pr1);	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		pr1 = new Produto("arroz", 1.50, 15);
		manager.persist(pr1);	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		pr1 = new Produto("macarr�o", 1.70, 20);
		manager.persist(pr1);	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		pr1 = new Produto("biscoito", 1.10, 30);
		manager.persist(pr1);	
		manager.getTransaction().commit();
		
		
		manager.close();
		factory.close();
		System.out.println("fim da aplica��o");
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Cadastro();
	}
	

}
