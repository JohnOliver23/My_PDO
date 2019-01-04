/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Barbeiro;
import model.Cliente;
import model.Tipo;


public class DAOTipo  extends DAO<Tipo>{

	public Tipo readByNome (String n){
		try{
			Query q = manager.createQuery("select t from Tipo t where t.nome= '" + n +"'");
			return (Tipo) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalTipos() {
		Query q = manager.createQuery(
				"select count(t) from Tipo t");
		return (Long) q.getSingleResult();
	}

	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultarAtendimentoAtual(){
		Query q = manager.createQuery(
				"select s.id, s.conta.cliente.nome, s.conta.cliente.sobrenome,  s.barbeiro.nome, s.barbeiro.sobrenome,"
				+ " t.nome, s.dthorario, t.preco from Tipo t JOIN t.servicos s where s.conta.pagamento is null and s.conta.dthorariofechamento is null ");
		return q.getResultList();
	}
	

	
	@SuppressWarnings("unchecked")
	public long totalAtendimentoAtual(){
		Query q = manager.createQuery(
				"select count(s) from Tipo t JOIN t.servicos s where s.conta.pagamento is null and s.conta.dthorariofechamento is null ");
		return (long) q.getSingleResult();
	}


}