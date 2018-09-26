package DAO;
import java.sql.Time;
import java.util.List;

import com.db4o.query.Query;
import modelo.Liga;

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
		q.descend("time").descend("nome").constrain(nome);
		List<Time> result = q.execute(); 
		return result;	
	}


}
