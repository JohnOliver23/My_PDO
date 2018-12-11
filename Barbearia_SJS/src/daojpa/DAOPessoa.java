/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Pessoa;


public class DAOPessoa  extends DAO<Pessoa>{

	public Pessoa readByNome (String n){
		try{
			Query q = manager.createQuery("select p from Pessoa p where p.nome= '" + n +"'");
			return (Pessoa) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalPessoa() {
		Query q = manager.createQuery(
				"select count(p) from Pessoa p");
		return (Long) q.getSingleResult();
	}

}
