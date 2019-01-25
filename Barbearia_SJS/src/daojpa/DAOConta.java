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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultarFilaDeEspera(){
		Query q = manager.createQuery(
				"select c.id, cli.nome, cli.sobrenome, c.dthorarioChegada from Conta c JOIN c.cliente cli where c.servicos is empty"
				+ " order by c.dthorarioChegada   ");
		return q.getResultList();
	}
	/*and c.dtChegada = CURRENT_DATE*/
	
	public long totalFilaDeEspera(){
		Query q = manager.createQuery(
				"select count(c) from Conta c JOIN c.cliente cli where c.servicos is empty   ");
		return (Long) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listarPagamentosDinheiro(){
		Query q = manager.createQuery(
				"select s.conta.cliente.nome, s.barbeiro.nome, t.nome, s.conta.pagamento.valorpago from Tipo t JOIN t.servicos s where s.conta.pagamento is not null and type(s.conta.pagamento) = Dinheiro ");
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> listarPagamentosCartao(){
		Query q = manager.createQuery(
				"select s.conta.cliente.nome, s.barbeiro.nome, t.nome, s.conta.pagamento.valorpago from Tipo t JOIN t.servicos s where s.conta.pagamento is not null and type(s.conta.pagamento) = Cartao ");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> consultarContasFechadas(){
		Query q = manager.createQuery(
				"select c.id, c.cliente.nome, c.cliente.sobrenome,c.dthorariofechamento, c.total from Conta c where c.pagamento is null "
				+ "and c.dthorariofechamento is not null order by c.dthorariofechamento desc ");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> consultarPagamentos(String data, String barbeiro, String tipoPagamento){
		Query q = manager.createQuery(
				"select c.id, c.cliente.nome, c.cliente.sobrenome,c.dthorariofechamento,c.pagamento.tipo, c.total from Conta c where c.pagamento is null "
				+ "and c.dthorariofechamento is not null order by c.dthorariofechamento desc ");
		return q.getResultList();
	}

}