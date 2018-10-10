package fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.DAO;
import DAO.DAOEstadio;
import DAO.DAOJogo;
import DAO.DAOLiga;
import DAO.DAOTime;
import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;
import modelo.Time;


public class Fachada {
	private static DAOJogo daojogo = new DAOJogo();
	private static DAOTime daotime = new DAOTime();
	private static DAOEstadio daoestadio = new DAOEstadio();
	private static DAOLiga daoliga = new DAOLiga();
	
	public static void inicializar () {
		DAO.open();
	}
	
	public static void finalizar () {
		DAO.close();
	}
	
	public static Liga cadastrarLiga(int id, String nome, String serie)throws Exception {
		
		DAO.begin();			
		Liga l = daoliga.localizarPorNome(nome);
		if(l!= null) {
			throw new Exception("ja cadastrado:" + nome);
		}
		l = new Liga(id, nome, serie);
		daoliga.create(l);		
		DAO.commit();
		return l;
	}
	
	public static Time cadastrarTime(int id, String nome, Liga liga)throws Exception {
		DAO.begin();			
		Time t  = daotime.localizarPorNome(nome);
		if(t!= null) {
			throw new Exception("ja cadastrado:" + nome);
		}
		t = new Time(id, nome, liga);
		liga.adicionar(t);
		daotime.create(t);	
		DAO.commit();
		return t;
	}
	
public static Jogo cadastrarJogo(int id, Time mandante, Time visitante, Estadio estadio, Date dthora)throws Exception {
		
		int key = daojogo.getKey();
		DAO.begin();			
		Jogo j  = daojogo.read(key);
		if(j!= null) {
			throw new Exception("jogo ja cadastrado: " + mandante.getNome()+" x "+ visitante.getNome());
		}
		j = new Jogo(id, mandante, visitante, estadio, dthora);
		daojogo.create(j);		
		DAO.commit();
		return j;
	}

public static Estadio cadastrarEstadio(int id, String nome)throws Exception {
	
	DAO.begin();			
	Estadio e  = daoestadio.localizarPorNome(nome);
	if(e!= null) {
		throw new Exception("Estadio ja cadastrado: " + nome);
	}
	e = new Estadio(id, nome);
	daoestadio.create(e);		
	DAO.commit();
	return e;
}

public static Jogo finalizaJogo(Jogo jogo, int placarMandante, int placarVisitante)throws Exception {
	if(jogo.isFinalizado()) {
		throw new Exception("Esse jogo já foi finalizado");
	}
	for(int i=0; i<placarMandante; i++) {
		jogo.marcaGolMandante();
	}
	for(int i=0; i<placarVisitante; i++) {
		jogo.marcaGolVisitante();
	}
	jogo.finalizarJogo();
	daojogo.update(jogo);
	DAO.commit();
	return jogo;
}

public static Time  deletarTime(String nome) throws Exception{
	DAO.begin();
	Time t = daotime.localizarPorNome(nome);
	if(t== null) {
		throw new Exception("Time não cadastrado");
	}
	Liga l = daoliga.localizarPorNome(t.getLiga().getNome());
	t.setLiga(null);
	l.remover(t);
	daoliga.update(l);
	daotime.update(t);
	
	
	DAO.commit();
	return t;
	

}

public static Liga consultarLiga(String nome) {
	return daoliga.consultarLiga(nome);
}

public static Time consultarTime(String nome) {
	return daotime.localizarPorNome(nome);
}

public static List<Time> classificacao(Liga liga) {
	return daoliga.classificacao(liga);
}

public static List <Estadio> getEstadios(){
	return daoestadio.readAll();
}

public static List <Liga> getLigas(){
	return daoliga.readAll();
}
public static List <Time> gettimes(){
	return daotime.readAll();
}
public static List <Jogo> getJogos(){
	return daojogo.readAll();
}
	

}
