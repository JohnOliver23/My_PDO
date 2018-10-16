package aplicacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fachada.Fachada;
import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;
import modelo.Time;

public class TesteRapido {
	public static void main(String[] args) {
		Fachada.inicializar();
		cadastro();
		deletes();
		listarEstadios();
		listarLigas();
		listarJogos();
		classificacao();
		consultas();
		Fachada.finalizar();
		
	}


	public static void cadastro() {
		try {
			Estadio maracana, pacaembu, vila, morumbi, mineirao, allianz, beirario, campNou, santiago, sanchez, wanda, mestala;
			maracana = Fachada.cadastrarEstadio(1, "Maracan�");
			pacaembu = Fachada.cadastrarEstadio(2, "Pacaembu");
			vila = Fachada.cadastrarEstadio(3, "Vila Beumiro");
			morumbi = Fachada.cadastrarEstadio(4, "Morumbi");
			mineirao = Fachada.cadastrarEstadio(5, "Mineir�o");
			allianz = Fachada.cadastrarEstadio(6, "Allianz Parque");
			beirario = Fachada.cadastrarEstadio(7, "Beira Rio");
			campNou = Fachada.cadastrarEstadio(8, "Camp Nou");
			santiago = Fachada.cadastrarEstadio(9, "Santiago Bernabeu");
			sanchez = Fachada.cadastrarEstadio(10, "Ramon Sanchez");
			wanda = Fachada.cadastrarEstadio(11, "Wanda Metropolitano");
			mestala = Fachada.cadastrarEstadio(12, "Mestala");
			Liga brasileiro = Fachada.cadastrarLiga(1, "Brasileir�o", "a");
			Liga espanhol = Fachada.cadastrarLiga(2, "Espanhol", "a");
			Time flamengo, saopaulo, santos, palmeiras, internacional, corinthians, cruzeiro,vasco, barcelona, realmadrid, sevilla, atleticomadrid;
			flamengo = Fachada.cadastrarTime(1, "flamengo", "Brasileir�o");
			saopaulo = Fachada.cadastrarTime(2, "S�o Paulo", "Brasileir�o");
			santos = Fachada.cadastrarTime(3, "Santos", "Brasileir�o");
			corinthians = Fachada.cadastrarTime(4, "Corinthians", "Brasileir�o");
			palmeiras = Fachada.cadastrarTime(5, "palmeiras", "Brasileir�o");
			internacional = Fachada.cadastrarTime(6, "Internacional", "Brasileir�o");
			cruzeiro = Fachada.cadastrarTime(7, "Cruzeiro", "Brasileir�o");
			vasco = Fachada.cadastrarTime(8, "vasco", "Brasileir�o");
			barcelona = Fachada.cadastrarTime(1, "Barcelona", "Espanhol");
			realmadrid = Fachada.cadastrarTime(2, "Real Madrid", "Espanhol");
			sevilla = Fachada.cadastrarTime(3, "Sevilla", "Espanhol");
			atleticomadrid = Fachada.cadastrarTime(4, "Atletico de Madrid", "Espanhol");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Jogo jogo1 = Fachada.cadastrarJogo(1, flamengo, saopaulo,maracana, formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo2 = Fachada.cadastrarJogo(2, internacional, santos, beirario, formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo3 = Fachada.cadastrarJogo(3, corinthians, palmeiras, pacaembu, formatter.parse("2018-10-01 19:30:00"));
			Jogo jogo4 =Fachada.cadastrarJogo(4, cruzeiro, vasco, mineirao, formatter.parse("2018-10-01 19:30:00"));
			Jogo jogo5 = Fachada.cadastrarJogo(5, flamengo, palmeiras, maracana, formatter.parse("2018-10-07 16:30:00"));
			Jogo jogo6 = Fachada.cadastrarJogo(6, internacional, corinthians, beirario, formatter.parse("2018-10-07 16:30:00"));
			Jogo jogo7 = Fachada.cadastrarJogo(7, palmeiras, vasco, allianz, formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo8 = Fachada.cadastrarJogo(8, cruzeiro, santos, mineirao, formatter.parse("2018-10-07 16:30:00"));
			Fachada.cadastrarJogo(9, corinthians, flamengo, pacaembu, formatter.parse("2018-10-14 16:30:00"));
			Fachada.cadastrarJogo(10, internacional, vasco, beirario, formatter.parse("2018-10-14 16:30:00"));
			Fachada.cadastrarJogo(11, santos, vasco, vila, formatter.parse("2018-10-14 19:30:00"));
			
			Fachada.cadastrarJogo(12, cruzeiro, palmeiras, mineirao, formatter.parse("2018-10-14 19:30:00"));
			Jogo jogo13 = Fachada.cadastrarJogo(1, barcelona, realmadrid,campNou, formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo14 = Fachada.cadastrarJogo(2, sevilla, atleticomadrid, sanchez, formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo15 = Fachada.cadastrarJogo(3, realmadrid, sevilla, santiago, formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo16 = Fachada.cadastrarJogo(4, atleticomadrid, barcelona, wanda, formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo17 = Fachada.cadastrarJogo(5, realmadrid, atleticomadrid, santiago, formatter.parse("2018-10-14 16:30:00"));
			Jogo jogo18 = Fachada.cadastrarJogo(6, barcelona, sevilla, campNou, formatter.parse("2018-10-14 16:30:00"));
			Fachada.finalizaJogo("Brasileir�o",1, 4, 1);
			Fachada.finalizaJogo("Brasileir�o", 2, 2, 1);
			Fachada.finalizaJogo("Brasileir�o", 3, 1, 1);
			Fachada.finalizaJogo("Brasileir�o", 4, 3, 0);
			Fachada.finalizaJogo("Brasileir�o", 5, 2, 1);
			Fachada.finalizaJogo("Brasileir�o", 6, 1, 1);
			Fachada.finalizaJogo("Brasileir�o", 7, 2, 0);
			Fachada.finalizaJogo("Brasileir�o", 8, 2, 3);
			Fachada.finalizaJogo("Espanhol", 1, 3, 3);
			Fachada.finalizaJogo("Espanhol", 2, 1, 2);
			Fachada.finalizaJogo("Espanhol", 3, 3, 0);
			Fachada.finalizaJogo("Espanhol", 4, 0, 4);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void deletes() {
		try {
			System.out.println("\n---------------------\n");
			System.out.println("apagando o time vasco");
			Fachada.deletarTime("vasco");
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("apagando o Estadio Mestala");
			Fachada.deletarEstadio("Mestala");
			System.out.println("\n---------------------\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void listarEstadios() {
		try {
			System.out.println("\n---------------------\n");
			System.out.println("Listando os Estadios");
			System.out.println(Fachada.getEstadios());
			System.out.println("\n---------------------\n");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void listarLigas() {
		try {
			System.out.println("\n---------------------\n");
			System.out.println("Listando as Ligas");
			System.out.println(Fachada.getLigas());
			System.out.println("\n---------------------\n");
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void listarJogos() {
		try {
			System.out.println("\n---------------------\n");
			System.out.println("Listando os Jogos");
			System.out.println(Fachada.getJogos());
			System.out.println("\n---------------------\n");
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void classificacao() {
		try {
			
			System.out.println("\n---------------------\n");
			System.out.println("Classifica�ao Brasileir�o");
			System.out.println(Fachada.classificacao("Brasileir�o"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Classifica�ao Espanhol");
			System.out.println(Fachada.classificacao("Espanhol"));
			System.out.println("\n---------------------\n");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void consultas() {
		try {
			
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os est�dios jogados no Brasileir�o");
			System.out.println(Fachada.consultarEstadiosPorLiga("Brasileir�o"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os est�dios  n�o jogados");
			System.out.println(Fachada.consultarEstadiosNaoJogados());
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os Jogos que n�o aconteceram do Brasileir�o");
			System.out.println(Fachada.consultarJogosNaoRealisados("Brasileir�o"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os 4 primeiros colocados do brasileir�o");
			System.out.println(Fachada.retornaNPrimeirosColocados("Brasileir�o",4));
			System.out.println("\n---------------------\n");
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


}
