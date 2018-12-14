package fachada;
import java.util.Date;
import java.util.List;

import daojpa.DAO;
import daojpa.DAOBarbeiro;
import daojpa.DAOCliente;
import daojpa.DAOPessoa;
import model.Barbeiro;
import model.Cliente;
//import daodb4o.*;
import model.Pessoa;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

public class Fachada {
	private static DAOPessoa daopessoa = new DAOPessoa();
	private static DAOBarbeiro daobarbeiro = new DAOBarbeiro() ;
	private static DAOCliente daocliente = new DAOCliente() ;

	public static void inicializar(){
		DAO.open();
	}

	public static void finalizar(){
		DAO.close();
	}

	public static Pessoa cadastrarPessoa(String nome, String sobrenome, Date data) 
			throws  Exception{
		DAO.begin();			
		Pessoa p = daopessoa.readByNome(nome);
		if(p != null) {
			DAO.rollback();
			throw new Exception("Pessoa j� cadastrada:" + nome);
		}
		
		p = new Pessoa(nome,sobrenome, data);
		daopessoa.create(p);		
		DAO.commit();
		return p;
	}
	
	public static Barbeiro cadastrarBarbeiro(String nome, String sobrenome, Date data) 
			throws  Exception{
		DAO.begin();			
		Barbeiro b = daobarbeiro.readByNome(nome);
		if(b != null) {
			DAO.rollback();
			throw new Exception("Barbeiro j� cadastrada:" + nome);
		}
		
		b = new Barbeiro(nome,sobrenome, data);
		daobarbeiro.create(b);		
		DAO.commit();
		return b;
	}
	
	public static Cliente cadastrarCliente(String nome, String sobrenome, Date data) 
			throws  Exception{
		DAO.begin();			
		Cliente c = daocliente.readByNome(nome);
		if(c != null) {
			DAO.rollback();
			throw new Exception("Cliente j� cadastrada:" + nome);
		}
		
		c = new Cliente(nome,sobrenome, data);
		daocliente.create(c);		
		DAO.commit();
		return c;
	}
	/*
	public static Produto apagarProduto(String nome) throws  Exception{
		DAO.begin();			
		Produto p = daoproduto.readByNome(nome);
		if(p == null)throw new Exception("produto nao cadastrado:" + nome);

		if(p.getPrateleira() != null){
			Prateleira pt = p.getPrateleira();
			pt.removerProduto(p);
			daoprateleira.update(pt);
		}
		daoproduto.delete(p);		
		DAO.commit();
		return p;
	}

	public static void apagarPrateleira(int id) 	throws  Exception{
		DAO.begin();		
		Prateleira pt = daoprateleira.read(id);
		if(pt == null) 	{
			DAO.rollback();
			throw new Exception("prateleira nao cadastrada:" + id);
		}
		daoprateleira.delete(pt);		
		DAO.commit();
	}
	public static Prateleira cadastrarPrateleira(double pesomax)throws  Exception{
		DAO.begin();	

		Prateleira pt;		
		pt = new Prateleira(pesomax);	
		daoprateleira.create(pt);		//id sera criado	
		DAO.commit();

		return pt;
	}

	public static void inserirProdutoPrateleira(int id, String nome) throws  Exception {
		DAO.begin();	

		Prateleira pt = daoprateleira.read(id);
		if(pt == null) {
			DAO.rollback();
			throw new Exception("prateleira nao cadastrada:" + nome);
		}

		Produto p = daoproduto.readByNome(nome);
		if(p == null) {
			DAO.rollback();
			throw new Exception("produto nao cadastrado:" + nome);
		}


		if(p.getPrateleira() != null) {
			DAO.rollback();
			throw new Exception("produto ja alocado numa prateleira:" + nome);
		}

		pt.adicionarProduto(p);
		daoprateleira.update(pt);		//atualiza a prateleira e o produto em cascata
		//daoproduto.update(p);			//opcional 	devido a cascata de atualiza��o de produto
		DAO.commit();
	}

	public static void retirarProdutoPrateleira(String nome) throws  Exception {
		DAO.begin();			
		Produto p = daoproduto.readByNome(nome);
		if(p == null) {
			DAO.rollback();
			throw new Exception("produto nao cadastrado:" + nome);
		}

		if(p.getPrateleira() == null) {
			DAO.rollback();
			throw new Exception("produto nao alocado numa prateleira:" + nome);
		}
		Prateleira pt = p.getPrateleira();
		pt.removerProduto(p);
		daoprateleira.update(pt);
		daoproduto.update(p);		// Cuidado: o produto foi alterado e deve ser gravado		
		DAO.commit();
	}
*/
	public static String listarPessoas() {
		List<Pessoa> aux = daopessoa.readAll();
		String texto = "\nListagem de pessoas: ";
		if (aux.isEmpty())
			texto += "n�o tem pessoas cadastradas";
		else {	
			for(Pessoa p: aux) {
				texto += "\n" + p; 
			}
		}
		return texto;		
	}
	
/*
	public static String listarPrateleiras() {
		List<Prateleira> aux = daoprateleira.readAll();
		String texto = "\nListagem de Prateleiras:";

		if (aux.isEmpty())
			texto += "n�o tem prateleira cadastrada";
		else {	
			for(Prateleira p: aux) {
				texto += "\n" + p; 
			}
		}
		return texto;
	}

	//consultas	
	public static String consultarPrateleirasVazias(){
		List<Prateleira> resultados = daoprateleira.consultarPrateleirasVazias();
		if(resultados.isEmpty())
			return "\nNao existem prateleiras vazias";
		else
		{	String texto="\nPrateleiras vazias";
		for(Prateleira pt : resultados){
			texto += "\nid=" + pt.getId();
		}
		return texto;
		}		
	}

	public static String consultarProdutosSemPrateleira(){		
		List<Produto> resultados = daoproduto.consultarProdutoSemPareteleira();	
		if(resultados.isEmpty())
			return "\nNao existem  produtos sem prateleira";
		else
		{	
			String texto="\nProdutos sem prateleira";
			for(Produto pt : resultados){
				texto += "\nnome=" + pt.getNome();
			}
			return texto;
		}
	}

	public static String consultarTotalProdutos(){		
		long i = daoproduto.consultarTotalProdutos();	
		String texto="\nTotal de produtos = "+i;
		return texto;	
	}

	public static String consultarPrateleiraComDoisProdutos() {
		List<Prateleira> resultados = daoprateleira.consultarPrateleiraComDoisProdutos();
		if(resultados.isEmpty())
			return "\nNao existem prateleiras com menos de dois produtos";
		else{	
			String texto="\nPrateleiras com menos de dois produtos";
			for(Prateleira pt : resultados){
				texto += "\nid=" + pt.getId();
			}
			return texto;
		}		
	}

	public static String consultarProdutosVizinhos(String nome) {
		List<Produto> resultados = daoproduto.consultarVizinhos(nome);	
		if(resultados.isEmpty())
			return "\nNao existem  produtos vizinhos";
		else
		{	
			String texto="\nProdutos vizinhos ao "+nome;
			for(Produto pt : resultados){
				texto += "\nnome=" + pt.getNome();
			}
			return texto;
		}
	}

	public static String consultarPrateleiraDoProduto(String nome) {
		Prateleira prat = daoprateleira.consultarPrateleiraDoProduto(nome);
		if(prat==null)
			return "\nNao existe prateleira do  " +nome;
		else	
			return "\nPrateleira do " +nome + "="+prat.getId();
	}
	
	public static String consultarProdutosDaPrateleira(int id) {		
		List<Produto> resultados = daoproduto.consultarProdutosDaPrateleira(id);	
			if(resultados.isEmpty())
			return "\nNao existe produto da prateleira "+id;
		else
		{	
			String texto="\nProdutos da prateleira "+id;
			for(Produto p : resultados){
				texto += "\nnome=" + p.getNome();
			}
			return texto;
		}

	}

*/
	//...outras consultas
}
