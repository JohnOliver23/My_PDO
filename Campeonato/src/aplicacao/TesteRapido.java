package aplicacao;

import fachada.Fachada;
import modelo.Estadio;
import modelo.Liga;
import modelo.Time;

public class TesteRapido {
	public static void main(String[] args) {
		Fachada.inicializar();
		cadastrarEstadio();
		cadastrarLigasETimes();
		listarEstadios();
		listarLigas();
		Fachada.finalizar();
	}
	public static void cadastrarEstadio() {
		try {
			Estadio maracana, pacaembu, vila, morumbi, mineirao, allianz, beirario;
			maracana = Fachada.cadastrarEstadio(1, "Maracanã");
			pacaembu = Fachada.cadastrarEstadio(2, "Pacaembu");
			vila = Fachada.cadastrarEstadio(3, "Vila Beumiro");
			morumbi = Fachada.cadastrarEstadio(4, "Morumbi");
			mineirao = Fachada.cadastrarEstadio(5, "Mineirão");
			allianz = Fachada.cadastrarEstadio(6, "Allianz Parque");
			beirario = Fachada.cadastrarEstadio(7, "Beira Rio");
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void listarEstadios() {
		try {
			System.out.println(Fachada.getEstadios());
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void cadastrarLigasETimes() {
		try {
			Liga brasileiro = Fachada.cadastrarLiga(1, "Brasileirão", "a");
			Liga espanhol = Fachada.cadastrarLiga(2, "Espanhol", "a");
			Time flamengo, saopaulo, santos, palmeiras, internacional, corinthians, cruzeiro, barcelona, realmadrid, sevilla, atleticomadrid;
			flamengo = Fachada.cadastrarTime(1, "flamengo", brasileiro);
			saopaulo = Fachada.cadastrarTime(2, "São Paulo", brasileiro);
			santos = Fachada.cadastrarTime(3, "Santos", brasileiro);
			corinthians = Fachada.cadastrarTime(4, "Corinthians", brasileiro);
			palmeiras = Fachada.cadastrarTime(5, "palmeiras", brasileiro);
			internacional = Fachada.cadastrarTime(6, "Internacional", brasileiro);
			cruzeiro = Fachada.cadastrarTime(7, "Cruzeiro", brasileiro);
			barcelona = Fachada.cadastrarTime(8, "Barcelona", espanhol);
			realmadrid = Fachada.cadastrarTime(9, "Real Madrid", espanhol);
			sevilla = Fachada.cadastrarTime(9, "Sevilla", espanhol);
			atleticomadrid = Fachada.cadastrarTime(10, "Atletico de Madrid", espanhol);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void listarLigas() {
		try {
			System.out.println(Fachada.getLigas());
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
