package aplicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fachada.Fachada;
import model.Barbeiro;
import model.Cliente;
import model.Pessoa;
import model.Tipo;

public class Delete {
	public Delete(){
		try {
		// INSTANCIAÇÃO DO MANAGER--------------------------------
			Fachada.inicializar();

//		PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
			/*
			System.out.println("===================================");
			System.out.println("Deletando barbeiro quizinho");
			Fachada.fecharConta(2);
			Fachada.deletarBarbeiro("Quizinho");
			System.out.println("===================================");
			System.out.println("Deletando Cliente Pedro");
			Fachada.deletarCliente(5);
			*/
			System.out.println("===================================");
			System.out.println("Deletando Conta de Jonnas");
			Fachada.deletarConta(3);
			
		
			
			
			
		
		Fachada.finalizar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Delete();
	}
	

}

