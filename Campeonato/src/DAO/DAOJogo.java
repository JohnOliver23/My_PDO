package DAO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.db4o.query.Query;

import modelo.Jogo;
import modelo.Liga;

public class DAOJogo extends DAO<Jogo> {
	
	/*retorna todos os jogos de uma data */
	public List<Jogo> consultarJogosPorData (Date data){	
		Query q = manager.query();
		q.constrain(Jogo.class);
		q.descend("dataHorario").constrain(data);
		List<Jogo> jogos = q.execute();
		return jogos;
			
	}
	/*retorna todos os jogos de um time */
	public List<Jogo> consultarJogosDeUmTime(Time time) {
		Query q = manager.query();
		q.constrain(Jogo.class);
		q.descend("time").constrain(time);
		List<Jogo> jogos = q.execute();
		return jogos;
	}
	
	public List<Jogo> consultarJogosNaoRealisados(Liga l){
		Query q = manager.query();
		q.constrain(Jogo.class);
		q.descend("finalizado").constrain(false).and(q.descend("timeMandante")
		.descend("liga").constrain(l));
		List<Jogo> jogos = q.execute();
		return jogos;
	}
	


}
