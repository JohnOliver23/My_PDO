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


}