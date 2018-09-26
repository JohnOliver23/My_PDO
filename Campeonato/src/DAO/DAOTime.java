package DAO;

import java.sql.Time;
import java.util.List;

import com.db4o.query.Query;

import modelo.Liga;

public class DAOTime extends DAO<Time> {
	
	public Time consultarTime (String nome){	
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("nome").constrain(nome);
		List<Time> resultados = q.execute();
		if (resultados.size()>0)
			return (Time) resultados.get(0);
		else
			return null;
	}
	
	public List<Time> consultarTimePorPontos(int ponto) {
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("pontos").constrain(ponto);
		List<Time> times = q.execute();
		return times;
	}

	
}
