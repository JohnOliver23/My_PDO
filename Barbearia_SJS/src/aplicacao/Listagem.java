package aplicacao;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Barbeiro;
import model.Cliente;
import model.Pessoa;


public class Listagem {
	protected static EntityManager manager;
	public Listagem(){
		Query query;
		
		// INSTANCIA��O DO MANAGER--------------------------------
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("barbearia");
		manager = factory.createEntityManager();
	
		System.out.println("Listagem das pessoas");
		query = manager.createQuery("select p from Pessoa p  order by p.nome");
		List<Pessoa> resultados = (List<Pessoa>) query.getResultList();
		for(Pessoa p: resultados)
			System.out.println(p);
		
		System.out.println("Listagem dos Barbeiros");
		query = manager.createQuery("select b from Barbeiro b");
		List<Barbeiro> resultados2 = (List<Barbeiro>) query.getResultList();
		for(Barbeiro b: resultados2)
			System.out.println(b);
		
		System.out.println("Listagem dos Clientes");
		query = manager.createQuery("select c from Cliente c");
		List<Cliente> resultados3 = (List<Cliente>) query.getResultList();
		for(Cliente c: resultados3)
			System.out.println(c);
		
		manager.close();
		factory.close();
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Listagem();
	}
	

}