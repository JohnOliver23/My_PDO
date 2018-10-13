package DAO;

import java.util.List;

import com.db4o.query.Query;

import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;
import modelo.Time;

public class DAOLiga extends DAO<Liga> {
	
	public Liga consultarLiga (String nome){	
		Query q = manager.query();
		q.constrain(Liga.class);
		q.descend("nome").constrain(nome);
		List<Liga> resultados = q.execute();
		if (resultados.size()>0)
			return (Liga) resultados.get(0);
		else
			return null;
	}
	
	public int consultarTotalLigas() {
		Query q = manager.query();
		q.constrain(Liga.class);
		int total = q.execute().size(); 
		return total;
	}

	public List<Time> consultarTimesPorLiga(String nome){
		Query q = manager.query();
		q.constrain(Liga.class);
		q.descend("times").descend("nome").constrain(nome);
		List<Time> result = q.execute(); 
		return result;	
	}
	
	public List <Time> classificacao(Liga liga){
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("liga").descend("id").constrain(liga.getId());
		q.descend("pontos").orderDescending();
		List<Time> result =  q.execute();
		return result;
	}
	
	public Liga localizarPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Liga.class);
		q.descend("nome").constrain(nome);
		List<Liga> ligas = q.execute();
		if(ligas.size()> 0) {
			return ligas.get(0);
		}
		return null;
		
		
	}



}
