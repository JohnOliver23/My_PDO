package fachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import daojpa.DAO;
import daojpa.DAOBarbeiro;
import daojpa.DAOCartao;
import daojpa.DAOCliente;
import daojpa.DAOConta;
import daojpa.DAODinheiro;
import daojpa.DAOPessoa;
import daojpa.DAOServico;
import daojpa.DAOTipo;
import model.Barbeiro;
import model.Cartao;
import model.Cliente;
import model.Conta;
import model.Dinheiro;
import model.Pagamento;
//import daodb4o.*;
import model.Pessoa;
import model.Servico;
import model.Tipo;

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
	private static DAOTipo daotipo = new DAOTipo() ;
	private static DAOConta daoconta = new DAOConta() ;
	private static DAOServico daoservico = new DAOServico() ;
	private static DAODinheiro daodinheiro = new DAODinheiro() ;
	private static DAOCartao daocartao = new DAOCartao() ;

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
			throw new Exception("Pessoa já cadastrada: " + nome);
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
			throw new Exception("Barbeiro já cadastrada: " + nome);
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
			throw new Exception("Cliente já cadastrada: " + nome);
		}
		
		c = new Cliente(nome,sobrenome, data);
		daocliente.create(c);		
		DAO.commit();
		return c;
	}
	
	
	public static Tipo cadastrarTipos(String nome, double preco) 
			throws  Exception{
		DAO.begin();			
		Tipo t = daotipo.readByNome(nome);
		if(t != null) {
			DAO.rollback();
			throw new Exception("Tipo já cadastrado: " + nome);
		}
		
		t = new Tipo(nome,preco);
		daotipo.create(t);		
		DAO.commit();
		return t;
	}
	
	public static Conta cadastrarConta(int idcliente)
			throws Exception{		
			DAO.begin();			
			Cliente c = daocliente.read(idcliente);
			if(c == null) {
				DAO.rollback();
				throw new Exception("Cliente não encontrado");
			}
			List<Conta> lista = daocliente.localizarContasByCliente(idcliente);
			if(lista.size()>=1) {
				Conta ultima = lista.get(lista.size()-1);
				if(ultima.getTotal()==0) {
					throw new Exception("Cliente já está na fila de espera");
				}
				if(ultima.getPagamento()==null) {
					throw new Exception("O cliente já está sendo atendido");
				}
			}
			Conta conta = new Conta(c);
			daoconta.create(conta);
			DAO.commit();
			return conta;
			
		
	}
	public static int totalFilaDeEspera() {
		return (int) daoconta.totalFilaDeEspera();
	}
	
	public static int totalAtendimentoAtual() {
		return (int) daotipo.totalAtendimentoAtual();
	}
	
	public static Servico cadastrarServico(String barbeiro, String tipo, int idconta)
			throws Exception{		
			DAO.begin();			
			Barbeiro b = daobarbeiro.readByNome(barbeiro);
			if(b == null) {
				DAO.rollback();
				throw new Exception("Barbeiro não encontrado : "+barbeiro);
			}
			Tipo t = daotipo.readByNome(tipo);
			if(t == null) {
				DAO.rollback();
				throw new Exception("Tipo de serviço não encontrado : "+tipo);
			}
			Conta c = daoconta.read(idconta);
			if(c == null) {
				DAO.rollback();
				throw new Exception("conta não encontrada : "+idconta);
			}
			if(b.isOcupado()) {
				throw new Exception("o barbeiro está atendendo no momento : "+barbeiro);
			}
			b.setOcupado(true);
			Servico s = new Servico(b,t,c);
			b.adicionar(s);
			c.setTotal(c.getTotal()+ s.getTipo().getPreco());
			daoservico.create(s);
			DAO.commit();
			return s;
	}
	
	/*updates*/
	public static Barbeiro AtualizaBarbeiro(int idBarbeiro, String nome, String sobrenome, Date data) 
			throws  Exception{
		DAO.begin();	
		Barbeiro b = daobarbeiro.read(idBarbeiro);
		if(b == null) {
			DAO.rollback();
			throw new Exception("Barbeiro não encontado: " + idBarbeiro);
		}
		b.setNome(nome);
		b.setSobrenome(sobrenome);
		b.setDatanasc(data);
		daobarbeiro.update(b);
		DAO.commit();
		return b;
	}
	
	public static Cliente AtualizaCliente(int idCliente, String nome, String sobrenome, Date data) 
			throws  Exception{
		DAO.begin();	
		Cliente c = daocliente.read(idCliente);
		if(c == null) {
			DAO.rollback();
			throw new Exception("Cliente não encontado: " + idCliente);
		}
		c.setNome(nome);
		c.setSobrenome(sobrenome);
		c.setDatanasc(data);
		daocliente.update(c);
		DAO.commit();
		return c;
	}
	
	public static Tipo AtualizaTipo(int idTipo, String nome, double preco) 
			throws  Exception{
		DAO.begin();	
		Tipo t = daotipo.read(idTipo);
		if(t == null) {
			DAO.rollback();
			throw new Exception("Tipo de serviço não encontrado: " + idTipo);
		}
		t.setNome(nome);
		t.setPreco(preco);
		daotipo.update(t);
		DAO.commit();
		return t;
	}
	
	/*fechar conta */
	public static int fecharConta(int idservico)
			throws Exception {
		DAO.begin();
		Servico s = daoservico.read(idservico);
		if(s == null) {
			DAO.rollback();
			throw new Exception("Servico não encontrado : "+idservico);
		}
		Conta c  = daoservico.consultarContaDoServico(idservico);
		if(c == null) {
			DAO.rollback();
			throw new Exception("Conta não encontrada");
		}else if(c.getDtHorarioFechamento()!=null) {
			throw new Exception("a conta já está fechada : "+c.getId());
		}else {
			c.setDtHorarioFechamento(new Date());
			s.getBarbeiro().setOcupado(false);
			DAO.commit();
		
		}
		return c.getId();
	}

	public static Pagamento pagarConta(int idconta, String tipo, int percentual, String cartao, int quantidade) 
			throws Exception {
		DAO.begin();
		Conta c = daoconta.read(idconta);
		if(c== null) {
			throw new Exception("Conta não encontrada");
		}
		if(c.getDtHorarioFechamento() == null) {
			throw new Exception("A conta não está fechada : "+idconta);
		}
		if(c.getPagamento()!= null) {
			throw new Exception("Essa conta ja foi paga !");
		}
		if(tipo.equalsIgnoreCase("Dinheiro")) {
			if(percentual <0 || percentual >5) {
				throw new Exception("Desconto não permitido");
			}
			Dinheiro pd = new Dinheiro(c.getTotal(), percentual);
			pd.calcularPagamento(c.getTotal());
			c.setPagamento(pd);
			daodinheiro.create(pd);
			DAO.commit();
			return pd;
		}else if(tipo.equalsIgnoreCase("cartão")) {
			if(quantidade <0 || quantidade >4) {
				throw new Exception("quantidade de parcelas inválido");
			}
			if(c.getTotal()/quantidade <100 && quantidade !=1) {
				throw new Exception("valor da parcela não permitida");
			}
			Cartao pc = new Cartao(c.getTotal(), cartao, quantidade);
			pc.calcularPagamento(c.getTotal());
			c.setPagamento(pc);
			daocartao.create(pc);
			DAO.commit();
			
			return pc;
			
		}
		return null;
	}
	
	public static Barbeiro deletarBarbeiro(int id) 
			throws  Exception{
		DAO.begin();			
		Barbeiro b = daobarbeiro.read(id);
		if(b == null)throw new Exception("Barbeiro não cadastrado: " + id);
		if(b.isOcupado())throw new Exception("Barbeiro está atendendo no momento: " + id);
		daobarbeiro.delete(b);
		DAO.commit();
		return b;
	}
	
	public static void deletarCliente(int id) 	
			throws  Exception{
		DAO.begin();		
		Cliente c = daocliente.read(id);
		if(c == null) 	{
			DAO.rollback();
			throw new Exception("Cliente não cadastrado" + id);
		}
		daocliente.delete(c);		
		DAO.commit();
	}
	
	public static void deletarConta(int id) 	
			throws  Exception{
		DAO.begin();		
		Conta c = daoconta.read(id);
		if(c == null) 	{
			DAO.rollback();
			throw new Exception("Conta não Encontrada" + id);
		}
		daoconta.delete(c);		
		DAO.commit();
	}
	
	public static Tipo deletarTipo(int id) 	
			throws  Exception{
		DAO.begin();		
		Tipo t = daotipo.read(id);
		if(t == null) 	{
			DAO.rollback();
			throw new Exception("Tipo de serviço não Encontrado" + id);
		}
		daotipo.delete(t);		
		DAO.commit();
		return t;
	}
	
	public static String listarPessoas() {
		List<Pessoa> aux = daopessoa.readAll();
		String texto = "\nListagem de pessoas: ";
		if (aux.isEmpty())
			texto += "não tem pessoas cadastradas";
		else {	
			for(Pessoa p: aux) {
				texto += "\n" + p; 
			}
		}
		return texto;		
	}
	public static Cliente localizarClienteById(int id)
		
	{
		Cliente c = daocliente.read(id);
		if(c == null) {
			return null;
		}
		return c;
	}
	
	public static Barbeiro localizarBarbeiroById(int id)
	
	{
		Barbeiro b = daobarbeiro.read(id);
		if(b == null) {
			return null;
		}
		return b;
	}
	
	public static Barbeiro localizarBarbeiroByName(String name)
	{
		Barbeiro b = daobarbeiro.readByNome(name);
		if(b == null) {
			return null;
		}
		return b;
	}
	
	public static Tipo localizarTipoById(int id)
	
	{
		Tipo t = daotipo.read(id);
		if(t == null) {
			return null;
		}
		return t;
	}
	public static Object[][] listarClientes() {
		List<Cliente> aux = daocliente.readAll();
		Object[][] lista = new Object[aux.size()][3];
		int i = 0;
		if (aux.isEmpty())
			return null;
		else {	
			for(Cliente c: aux) {
				lista[i][0] = c.getId();
				lista[i][1]= c.getNome()+" "+c.getSobrenome();
				lista[i][2] = c.getDatanasc();
				i++;
			}
		}
		return lista;
	}
	
	public static Object[][] listarBarbeiros() {
		List<Barbeiro> aux = daobarbeiro.readAll();
		Object[][] lista = new Object[aux.size()][3];
		int i = 0;
		if (aux.isEmpty())
			return null;
		else {	
			for(Barbeiro b: aux) {
				lista[i][0] = b.getId();
				lista[i][1]= b.getNome()+" "+b.getSobrenome();
				lista[i][2] = b.getDatanasc();
				i++;
			}
		}
		return lista;
	}
	
	public static Object[][] listarTipos() {
		List<Tipo> aux = daotipo.readAll();
		Object[][] lista = new Object[aux.size()][3];
		int i = 0;
		if (aux.isEmpty())
			return null;
		else {	
			for(Tipo t: aux) {
				lista[i][0] = t.getId();
				lista[i][1]= t.getNome();
				lista[i][2] = t.getPreco();
				i++;
			}
		}
		return lista;
	}
	
	
	public static String listarContas() {
		List<Conta> aux = daoconta.readAll();
		String texto = "\nListagem de Contas: ";
		if (aux.isEmpty())
			texto += "não tem contas cadastradas";
		else {	
			for(Conta c: aux) {
				texto += "\n" + c; 
			}
		}
		return texto;		
	}
	
	public static Object[][]listarAtendimentoAtual() {
		List<Object[]> aux = daotipo.consultarAtendimentoAtual();
		Object[][] lista = new Object[aux.size()][5];
		if (aux.isEmpty())
			return null;
		else {	
			for (int i =0; i<aux.size(); i++) {
				Object[]resultado= (Object[]) aux.get(i);
				lista[i][0] = (int)resultado[0];
				lista[i][1] = (String)resultado [1]+" "+(String)resultado[2];
				lista[i][2] = (String)resultado [3]+" "+(String)resultado[4];
				lista[i][3] = (String)resultado[5];
				lista[i][4] = (Double)resultado [6];
			}
		}
		return lista;		
	}
	
	public static String[] listarNomeBarbeiros() {
		List<Barbeiro> barbeiros = daobarbeiro.readAll();
		String array[] = new String[barbeiros.size()];
		int i =0;
		for(Barbeiro b: barbeiros) {
		    array[i] = b.getNome();
		    i++;
		}
		return array;
	}
	
	public static String[] listarNomeServicos() {
		List<Tipo> tipos = daotipo.readAll();
		String array[] = new String[tipos.size()];
		int i =0;
		for(Tipo t: tipos) {
		    array[i] = t.getNome();
		    i++;
		}
		return array;
	}
	
	public static ArrayList<Servico> listarNomeServicoss() {
		return (ArrayList<Servico>) daoservico.readAll();
	}
	
	public static Object[][] listarFilaDeEspera() {
		List<Object[]> aux = daoconta.consultarFilaDeEspera();
		
		Object[][] lista = new Object[aux.size()][3];
		if (aux.isEmpty())
			return null;
		else {	
			
			for (int i =0; i<aux.size(); i++) {
				Object[]resultado= (Object[]) aux.get(i);
				String cliente = (String)resultado [0];
				String sobrenome = (String)resultado[1];
				Calendar calendar = Calendar.getInstance();
				calendar.setTime((Date) resultado[2]);
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				int seconds = calendar.get(Calendar.SECOND);
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1;
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String dayParse = Integer.toString(day);
				String monthParse = Integer.toString(month);
				String hourParse = Integer.toString(hours);
				String minutesParse = Integer.toString(minutes);
				String secondParse = Integer.toString(seconds);
				if(dayParse.length()==1) {
					dayParse = "0"+dayParse;
				}
				if(monthParse.length()==1) {
					monthParse = "0"+monthParse;
				}
				if(hourParse.length()==1) {
					hourParse = "0"+hourParse;
				}
				if(minutesParse.length()==1) {
					minutesParse = "0"+minutesParse;
				}
				if(secondParse.length()==1) {
					secondParse = "0"+secondParse;
				}
				String nomeCompleto = cliente+" "+sobrenome;
				String data = dayParse+"/"+monthParse+"/"+year;
				String horaCompleta = hourParse+":"+minutesParse+":"+secondParse;
				lista[i][0] = nomeCompleto;
				lista[i][1] = data;
				lista[i][2] = horaCompleta;
			}
		}
		return lista;		
	}
	
	public static String listarPagamentosPorPeriodo(String periodo, String tipoPagamento)
		throws Exception{
		if(!(tipoPagamento.equalsIgnoreCase("Dinheiro")||tipoPagamento.equalsIgnoreCase("Cartão"))) {
			throw new Exception("Tipo de serviço inválido");
		}
		List<Object[]> aux;
		if(tipoPagamento.equalsIgnoreCase("Dinheiro")) {
			 aux = daoconta.listarPagamentosDinheiro();
		}else {
			aux = daoconta.listarPagamentosCartao();
		}
		String texto = "";
		if (aux.isEmpty())
			texto += "não tem Pagamentos no momento :"+tipoPagamento;
		else {	
			for (int i =0; i<aux.size(); i++) {
				Object[]resultado= (Object[]) aux.get(i);
				String cliente = (String)resultado [0];
				String barbeiro = (String)resultado [1];
				String tipoServico = (String)resultado [2];
				double valorpago = (double)resultado [3];
				System.out.println("oi");
				texto+="Cliente : "+cliente+", Barbeiro: "+barbeiro+" , Tipo de Serviço : "+tipoServico+", valorpago : "+valorpago+", Tipo de pagamento : "+tipoPagamento+"\n";
			}
		}
		return texto;		
	}

	
}
