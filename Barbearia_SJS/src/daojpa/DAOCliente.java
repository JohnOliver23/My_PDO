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
import model.Pessoa;


public class DAOCliente  extends DAO<Cliente>{

	public Cliente readByNome (String n){
		try{
			Query q = manager.createQuery("select c from Cliente c where c.nome= '" + n +"'");
			return (Cliente) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	public List<Conta> localizarContasByCliente (int idcliente){
		try{
			Query q = manager.createQuery("select c from Conta c where c.cliente.id = :id");
			q.setParameter("id", idcliente);
			return (List<Conta>) q.getResultList();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalClientes() {
		Query q = manager.createQuery(
				"select count(c) from Cliente c");
		return (Long) q.getSingleResult();
	}
	
	public List<Cliente> readAll(){
		
		Query query = manager.createQuery("select c from Cliente c order by c.nome");
		return (List<Cliente>) query.getResultList();
	}


}