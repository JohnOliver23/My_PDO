package aplicacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fachada.Fachada;
import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;
import modelo.Time;

public class TesteRapido {
	public static void main(String[] args) {
		Fachada.inicializar();
		cadastro();
		listarEstadios();
		listarLigas();
		listarJogos();
		Fachada.finalizar();
	}


	public static void cadastro() {
		try {
			Estadio maracana, pacaembu, vila, morumbi, mineirao, allianz, beirario;
			maracana = Fachada.cadastrarEstadio(1, "Maracanã");
			pacaembu = Fachada.cadastrarEstadio(2, "Pacaembu");
			vila = Fachada.cadastrarEstadio(3, "Vila Beumiro");
			morumbi = Fachada.cadastrarEstadio(4, "Morumbi");
			mineirao = Fachada.cadastrarEstadio(5, "Mineirão");
			allianz = Fachada.cadastrarEstadio(6, "Allianz Parque");
			beirario = Fachada.cadastrarEstadio(7, "Beira Rio");
			Liga brasileiro = Fachada.cadastrarLiga(1, "Brasileirão", "a");
			Liga espanhol = Fachada.cadastrarLiga(2, "Espanhol", "a");
			Time flamengo, saopaulo, santos, palmeiras, internacional, corinthians, cruzeiro,vasco, barcelona, realmadrid, sevilla, atleticomadrid;
			flamengo = Fachada.cadastrarTime(1, "flamengo", brasileiro);
			saopaulo = Fachada.cadastrarTime(2, "São Paulo", brasileiro);
			santos = Fachada.cadastrarTime(3, "Santos", brasileiro);
			corinthians = Fachada.cadastrarTime(4, "Corinthians", brasileiro);
			palmeiras = Fachada.cadastrarTime(5, "palmeiras", brasileiro);
			internacional = Fachada.cadastrarTime(6, "Internacional", brasileiro);
			cruzeiro = Fachada.cadastrarTime(7, "Cruzeiro", brasileiro);
			vasco = Fachada.cadastrarTime(8, "vasco", brasileiro);
			barcelona = Fachada.cadastrarTime(1, "Barcelona", espanhol);
			realmadrid = Fachada.cadastrarTime(2, "Real Madrid", espanhol);
			sevilla = Fachada.cadastrarTime(3, "Sevilla", espanhol);
			atleticomadrid = Fachada.cadastrarTime(4, "Atletico de Madrid", espanhol);
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
			Fachada.finalizaJogo(jogo1,4, 1);
			Fachada.finalizaJogo(jogo2, 2, 1);
			Fachada.finalizaJogo(jogo3, 1, 1);
			Fachada.finalizaJogo(jogo4, 3, 0);
			Fachada.finalizaJogo(jogo5, 2, 1);
			Fachada.finalizaJogo(jogo6, 1, 1);
			Fachada.finalizaJogo(jogo7, 2, 0);
			Fachada.finalizaJogo(jogo8, 2, 3);
			System.out.println("\n---------------------\n");
			System.out.println("Classificaçao");
			System.out.println(Fachada.classificacao(brasileiro));
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



}
