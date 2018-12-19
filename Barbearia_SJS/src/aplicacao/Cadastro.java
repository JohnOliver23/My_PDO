package aplicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fachada.Fachada;
import model.Barbeiro;
import model.Cliente;
import model.Pessoa;
import model.Tipo;

public class Cadastro {
	public Cadastro(){
		try {
		// INSTANCIAÇÃO DO MANAGER--------------------------------
			Fachada.inicializar();

//		PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
			
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
			 c  = Fachada.cadastrarCliente("Pedro", "Cirrose", formatter.parse("1991-05-01"));
			 c  = Fachada.cadastrarCliente("Jonnas", "Santos", formatter.parse("1992-07-12"));
			System.out.println("===================================");
			System.out.println("Cadastrando Tipos");
			Tipo t  = Fachada.cadastrarTipos("Corte de cabelo", 15.00);
			t  = Fachada.cadastrarTipos("Barba", 10.00);
			t  = Fachada.cadastrarTipos("Combo (Corte e Barba)", 22.00);
			t  = Fachada.cadastrarTipos("Lavagem", 10.00);
			//lembrar de parar pra demostrar
			System.out.println("===================================");
			System.out.println("Cadastrando Contas");
			Fachada.cadastrarConta(3);
			Fachada.cadastrarConta(4);
			Fachada.cadastrarConta(5);
			
			System.out.println("===================================");
			System.out.println("Cadastrando Servicos");
			Fachada.cadastrarServico("Pedro","Corte de cabelo",1);
			
			
			
			
		
		Fachada.finalizar();
		/*


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

