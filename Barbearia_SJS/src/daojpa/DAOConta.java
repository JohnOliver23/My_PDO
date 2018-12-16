/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Barbeiro;
import model.Cliente;
import model.Conta;
import model.Tipo;


public class DAOConta  extends DAO<Conta>{

	public Tipo readByNome (String n){
		try{
			Query q = manager.createQuery("select c from Conta c where c.nome= '" + n +"'");
			return (Tipo) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalContas() {
		Query q = manager.createQuery(
				"select count(c) from Conta c");
		return (Long) q.getSingleResult();
	}


}