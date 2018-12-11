/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Barbeiro;


public class DAOBarbeiro  extends DAO<Barbeiro>{

	public Barbeiro readByNome (String n){
		try{
			Query q = manager.createQuery("select b from Barbeiro b where b.nome= '" + n +"'");
			return (Barbeiro) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalBarbeiros() {
		Query q = manager.createQuery(
				"select count(b) from Barbeiro b");
		return (Long) q.getSingleResult();
	}


}
