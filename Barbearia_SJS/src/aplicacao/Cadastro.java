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
			 b = Fachada.cadastrarBarbeiro("Quizinho", "Junior", formatter.parse("1996-10-01"));
			System.out.println("===================================");
			System.out.println("Cadastrando Cliente");
			Cliente c  = Fachada.cadastrarCliente("Murivaldo", "Ynho", formatter.parse("1990-05-01"));
			 c  = Fachada.cadastrarCliente("Pedro", "Cirrose", formatter.parse("1991-05-01"));
			 c  = Fachada.cadastrarCliente("Jonnas", "Santos", formatter.parse("1992-07-12"));
			 c  = Fachada.cadastrarCliente("Marcos", "kiesa", formatter.parse("1992-07-12"));
			 c  = Fachada.cadastrarCliente("Aldair", "playBoy", formatter.parse("1994-07-12"));
			System.out.println("===================================");
			System.out.println("Cadastrando Tipos");
			Tipo t  = Fachada.cadastrarTipos("Corte de cabelo", 15.00);
			t  = Fachada.cadastrarTipos("Barba", 10.00);
			t  = Fachada.cadastrarTipos("Combo (Corte e Barba)", 22.00);
			t  = Fachada.cadastrarTipos("Lavagem", 10.00);
			//lembrar de parar pra demostrar
			System.out.println("===================================");
			System.out.println("Cadastrando Contas");
			Fachada.cadastrarConta(4);
			Fachada.cadastrarConta(5);
			Fachada.cadastrarConta(6);
			Fachada.cadastrarConta(7);
			Fachada.cadastrarConta(8);
			
			System.out.println("===================================");
			System.out.println("Cadastrando Servicos");
			Fachada.cadastrarServico("Pedro","Corte de cabelo",1);
			Fachada.cadastrarServico("Quizinho","Corte de cabelo",2);
			System.out.println("Fechar a conta 1");
			Fachada.fecharConta(1);
			Fachada.pagarConta(1, "Dinheiro", 0, "hiper", 5);
			
		
			
			
			
		
		Fachada.finalizar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Cadastro();
	}
	

}

