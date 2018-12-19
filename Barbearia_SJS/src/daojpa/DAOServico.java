/**IFPB - Curso SI - Disciplina de POB*/

package daojpa;
import javax.persistence.Query;

import model.Conta;
import model.Servico;

public class DAOServico extends DAO<Servico> {
	@SuppressWarnings("unchecked")
	public Conta consultarContaDoServico(int idservico){
		Query q = manager.createQuery(
				"select c from Conta c JOIN c.servicos s  where s.id= :n");
		q.setParameter("n", idservico);
		return (Conta) q.getSingleResult();
	}
	

}
