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
	/*8
	"select c.nome cliente,b.nome barbeiro, t.nome tipo, t.preco from pessoa c  join conta co on c.id = co.cliente_id\r\n" + 
	"join servico s on s.conta_id = co.id join tipo t on t.id = s.tipo_id join pessoa b on s.barbeiro_id = b.id\r\n" + 
	"where dthorariofechamento is null"*/
	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultarAtendimentoAtual(){
		Query q = manager.createQuery(
				"select s.conta.cliente.nome, s.barbeiro.nome, t.preco, t.nome from Tipo t JOIN t.servicos s ");
		return q.getResultList();
	}


}