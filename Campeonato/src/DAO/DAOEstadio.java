package DAO;

import java.sql.Time;
import java.util.List;

import com.db4o.query.Query;

import modelo.Estadio;

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
}
