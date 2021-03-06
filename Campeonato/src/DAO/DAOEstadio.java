package DAO;

import java.sql.Time;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;

public class DAOEstadio extends DAO<Estadio> {
	public Estadio consultarEstadio (String nome){	
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("nome").constrain(nome);
		List<Estadio> resultados = q.execute();
		if (resultados.size()>0)
			return (Estadio) resultados.get(0);
		else
			return null;
	}
	public Estadio localizarPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Estadio.class);
		q.descend("nome").constrain(nome);
		List<Estadio> estadios = q.execute();
		if(estadios.size()> 0)
			return estadios.get(0);
		return null;
	}
	
	public List<Estadio> consultarEstadiosPorLiga(Liga l) {
		Query q = manager.query();
		q.constrain(Estadio.class);
		q.descend("jogos").descend("timeMandante").descend("liga")
		.descend("nome").constrain(l.getNome());
		List<Estadio> result = q.execute();
		if(result.size()>0) {
			return result;
		}
		return null;
		
		
	}
	
	public List<Estadio> consultarEstadiosNaoJogados() {
		Query q = manager.query();
		q.constrain(Estadio.class);
		q.constrain(new Filtro1());
		List<Estadio> result = q.execute();
		if(result.size()>0) {
			return result;
		}
		return null;
		
	}
	
	class Filtro1 implements Evaluation {
		public void evaluate(Candidate candidate) {
			Estadio e = (Estadio) candidate.getObject();
			if(e.getJogos().size()==0) {
				candidate.include(true);
			}else {
				candidate.include(false);
			}
			
		}
	}
	
	
}
