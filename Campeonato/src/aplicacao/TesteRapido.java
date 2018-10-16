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
		//cadastro();
		//deletes();
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
			maracana = Fachada.cadastrarEstadio(1, "Maracanã");
			pacaembu = Fachada.cadastrarEstadio(2, "Pacaembu");
			vila = Fachada.cadastrarEstadio(3, "Vila Beumiro");
			morumbi = Fachada.cadastrarEstadio(4, "Morumbi");
			mineirao = Fachada.cadastrarEstadio(5, "Mineirão");
			allianz = Fachada.cadastrarEstadio(6, "Allianz Parque");
			beirario = Fachada.cadastrarEstadio(7, "Beira Rio");
			campNou = Fachada.cadastrarEstadio(8, "Camp Nou");
			santiago = Fachada.cadastrarEstadio(9, "Santiago Bernabeu");
			sanchez = Fachada.cadastrarEstadio(10, "Ramon Sanchez");
			wanda = Fachada.cadastrarEstadio(11, "Wanda Metropolitano");
			mestala = Fachada.cadastrarEstadio(12, "Mestala");
			Liga brasileiro = Fachada.cadastrarLiga(1, "Brasileirão", "a");
			Liga espanhol = Fachada.cadastrarLiga(2, "Espanhol", "a");
			Time flamengo, saopaulo, santos, palmeiras, internacional, corinthians, cruzeiro,vasco, barcelona, realmadrid, sevilla, atleticomadrid;
			flamengo = Fachada.cadastrarTime(1, "Flamengo", "Brasileirão");
			saopaulo = Fachada.cadastrarTime(2, "São Paulo", "Brasileirão");
			santos = Fachada.cadastrarTime(3, "Santos", "Brasileirão");
			corinthians = Fachada.cadastrarTime(4, "Corinthians", "Brasileirão");
			palmeiras = Fachada.cadastrarTime(5, "Palmeiras", "Brasileirão");
			internacional = Fachada.cadastrarTime(6, "Internacional", "Brasileirão");
			cruzeiro = Fachada.cadastrarTime(7, "Cruzeiro", "Brasileirão");
			vasco = Fachada.cadastrarTime(8, "Vasco", "Brasileirão");
			barcelona = Fachada.cadastrarTime(1, "Barcelona", "Espanhol");
			realmadrid = Fachada.cadastrarTime(2, "Real Madrid", "Espanhol");
			sevilla = Fachada.cadastrarTime(3, "Sevilla", "Espanhol");
			atleticomadrid = Fachada.cadastrarTime(4, "Atletico de Madrid", "Espanhol");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Jogo jogo1 = Fachada.cadastrarJogo(1, "Flamengo", "São Paulo","Maracanã", formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo2 = Fachada.cadastrarJogo(2, "Internacional", "Santos", "Beira Rio", formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo3 = Fachada.cadastrarJogo(3, "Corinthians", "Palmeiras", "Pacaembu", formatter.parse("2018-10-01 19:30:00"));
			Jogo jogo4 =Fachada.cadastrarJogo(4, "Cruzeiro", "Vasco", "Mineirão", formatter.parse("2018-10-01 19:30:00"));
			Jogo jogo5 = Fachada.cadastrarJogo(5, "Flamengo", "Palmeiras", "Maracanã", formatter.parse("2018-10-07 16:30:00"));
			Jogo jogo6 = Fachada.cadastrarJogo(6, "Internacional", "Corinthians", "Beira Rio", formatter.parse("2018-10-07 16:30:00"));
			Jogo jogo7 = Fachada.cadastrarJogo(7, "Palmeiras", "Vasco", "Allianz Parque", formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo8 = Fachada.cadastrarJogo(8, "Cruzeiro", "Santos", "Mineirão", formatter.parse("2018-10-07 16:30:00"));
			Fachada.cadastrarJogo(9, "Corinthians", "Flamengo", "Pacaembu", formatter.parse("2018-10-14 16:30:00"));
			Fachada.cadastrarJogo(10, "Internacional", "Vasco", "Beira Rio", formatter.parse("2018-10-14 16:30:00"));
			Fachada.cadastrarJogo(11, "Santos", "Vasco", "Vila Beumiro", formatter.parse("2018-10-14 19:30:00"));
			
			Fachada.cadastrarJogo(12, "Cruzeiro", "Palmeiras", "Mineirão", formatter.parse("2018-10-14 19:30:00"));
			Jogo jogo13 = Fachada.cadastrarJogo(1, "Barcelona", "Real Madrid","Camp Nou", formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo14 = Fachada.cadastrarJogo(2, "Sevilla", "Atletico de Madrid", "Ramon Sanchez", formatter.parse("2018-10-01 16:30:00"));
			Jogo jogo15 = Fachada.cadastrarJogo(3, "Real Madrid", "Sevilla", "Santiago Bernabeu", formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo16 = Fachada.cadastrarJogo(4, "Atletico de Madrid", "Barcelona", "Wanda Metropolitano", formatter.parse("2018-10-07 19:30:00"));
			Jogo jogo17 = Fachada.cadastrarJogo(5, "Real Madrid", "Atletico de Madrid", "Santiago Bernabeu", formatter.parse("2018-10-14 16:30:00"));
			Jogo jogo18 = Fachada.cadastrarJogo(6, "Barcelona", "Sevilla", "Camp Nou", formatter.parse("2018-10-14 16:30:00"));
			Fachada.finalizaJogo("Brasileirão",1, 4, 1);
			Fachada.finalizaJogo("Brasileirão", 2, 2, 1);
			Fachada.finalizaJogo("Brasileirão", 3, 1, 1);
			Fachada.finalizaJogo("Brasileirão", 4, 3, 0);
			Fachada.finalizaJogo("Brasileirão", 5, 2, 1);
			Fachada.finalizaJogo("Brasileirão", 6, 1, 1);
			Fachada.finalizaJogo("Brasileirão", 7, 4, 0);
			Fachada.finalizaJogo("Brasileirão", 8, 2, 3);
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
			Fachada.deletarTime("Vasco");
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
			System.out.println("Classificaçao Brasileirão");
			System.out.println(Fachada.classificacao("Brasileirão"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Classificaçao Espanhol");
			System.out.println(Fachada.classificacao("Espanhol"));
			System.out.println("\n---------------------\n");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void consultas() {
		try {
			
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os estádios jogados no Brasileirão");
			System.out.println(Fachada.consultarEstadiosPorLiga("Brasileirão"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os estádios  não jogados");
			System.out.println(Fachada.consultarEstadiosNaoJogados());
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os Jogos que não aconteceram do Brasileirão");
			System.out.println(Fachada.consultarJogosNaoRealisados("Brasileirão"));
			System.out.println("\n---------------------\n");
			System.out.println("\n---------------------\n");
			System.out.println("Consultando os 4 primeiros colocados do brasileirão");
			System.out.println(Fachada.retornaNPrimeirosColocados("Brasileirão",4));
			System.out.println("\n---------------------\n");
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


}
