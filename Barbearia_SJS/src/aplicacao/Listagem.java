package aplicacao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fachada.Fachada;
import model.Barbeiro;


public class Listagem {
	protected static EntityManager manager;
	public Listagem(){
		
		try {
			Fachada.inicializar();
			System.out.println("===================================");
			System.out.println("Listagem das pessoas");
			System.out.println(Fachada.listarPessoas());
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println("Listagem das Barbeiros");
			/*
			List<Barbeiro> list = Fachada.listarBarbeiros();
			for(Barbeiro b: list) {
				System.out.println(b.getNome()+" ");
			}*/
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println("Listagem das Clientes");
			System.out.println(Fachada.listarClientes());
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println("Listagem das Tipos");
			System.out.println(Fachada.listarTipos());
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println("Listagem das Contas");
			System.out.println(Fachada.listarContas());
			System.out.println("===================================");
			System.out.println("Listar o atendimento atual");
			System.out.println(Fachada.listarAtendimentoAtual());
			System.out.println("===================================");
			System.out.println("===================================");
			System.out.println("Listar a Fila de Espera");
			System.out.println(Fachada.listarFilaDeEspera());
			System.out.println("===================================");
			System.out.println("Listar Pagamentos do dia");
			System.out.println(Fachada.listarPagamentosPorPeriodo("dia","Cartão"));
			System.out.println("===================================");
			Fachada.cadastrarConta(6);
			Fachada.cadastrarConta(7);
			Fachada.cadastrarConta(8);
			Fachada.finalizar();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Listagem();
	}
	

}
