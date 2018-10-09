package DAO;


import java.util.List;

import com.db4o.query.Query;

import modelo.Liga;
import modelo.Time;

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
	/*retorna os times que têm pontos maior que o do parâmetro */
	public List<Time> consultarTimesMaiorPorPontos(int ponto) {
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("pontos").constrain(ponto).or(q.constrain(ponto).greater());
		List<Time> times = q.execute();
		return times;
	}
	
	/*retorna os times que têm pontos menor que o do parâmetro */
	public List<Time> consultarTimesMenorPorPontos(int ponto) {
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("pontos").constrain(ponto).or(q.constrain(ponto).smaller());
		List<Time> times = q.execute();
		return times;
	}
	
	public Time localizarPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Time.class);
		q.descend("nome").constrain(nome);
		List<Time> times = q.execute();
		if(times.size()> 0)
			return times.get(0);
		return null;
		
		
	}
	
}
