/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

package DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import modelo.Estadio;
import modelo.Jogo;
import modelo.Liga;
import modelo.Time;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void open(){	
		if(manager==null){		
			abrirBancoLocal();
			//abrirBancoServidor();
		}
	}
	private static void abrirBancoLocal(){
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // 0,1,2,3...
		config.common().objectClass(Liga.class).cascadeOnDelete(true);;
		config.common().objectClass(Liga.class).cascadeOnUpdate(true);;
		config.common().objectClass(Liga.class).cascadeOnActivate(true);
		config.common().objectClass(Time.class).cascadeOnDelete(false);;
		config.common().objectClass(Time.class).cascadeOnUpdate(true);;
		config.common().objectClass(Time.class).cascadeOnActivate(true);
		config.common().objectClass(Jogo.class).cascadeOnDelete(false);;
		config.common().objectClass(Jogo.class).cascadeOnUpdate(true);;
		config.common().objectClass(Jogo.class).cascadeOnActivate(true);
		config.common().objectClass(Estadio.class).cascadeOnDelete(false);;
		config.common().objectClass(Estadio.class).cascadeOnUpdate(true);;
		config.common().objectClass(Estadio.class).cascadeOnActivate(true);		
		
		manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
		IDControl.registrarManager(manager); 
	}
	private static void abrirBancoServidor(){
		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
		config.common().messageLevel(0);   //0,1,2,3,4
		config.common().messageLevel(0);  // 0,1,2,3...
		config.common().objectClass(Liga.class).cascadeOnDelete(true);;
		config.common().objectClass(Liga.class).cascadeOnUpdate(true);;
		config.common().objectClass(Liga.class).cascadeOnActivate(true);
		config.common().objectClass(Time.class).cascadeOnDelete(false);;
		config.common().objectClass(Time.class).cascadeOnUpdate(true);;
		config.common().objectClass(Time.class).cascadeOnActivate(true);
		config.common().objectClass(Jogo.class).cascadeOnDelete(false);;
		config.common().objectClass(Jogo.class).cascadeOnUpdate(true);;
		config.common().objectClass(Jogo.class).cascadeOnActivate(true);
		config.common().objectClass(Estadio.class).cascadeOnDelete(false);;
		config.common().objectClass(Estadio.class).cascadeOnUpdate(true);;
		config.common().objectClass(Estadio.class).cascadeOnActivate(true);	

		String ip = JOptionPane.showInputDialog("Digite o IP do servidor");
		if (ip==null || ip.isEmpty())	{
			System.out.println("ip invalido");
			System.exit(0);
		}
		manager = Db4oClientServer.openClient(config,ip,34000,"usuario1","senha1");	
		IDControl.registrarManager(manager); 
	}
	public static void close(){
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}

	//----------CRUD-----------------------

	public void create(T obj){
		manager.store( obj );
	}
	
	@SuppressWarnings("unchecked")
	public T read(int id){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		q.descend("id").constrain(id);
		List<T> resultados = q.execute();
		if (resultados.size()>0)
			return (T) resultados.get(0);
		else
			return null;
	}

	public T update(T obj){
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj){
		manager.delete(obj);
		manager.store(obj);
//		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}
	
	public List<T> readAll(String nome){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		q.descend("nome").constrain(nome).like();
		return (List<T>) q.execute();
	}
	
	public int getKey () {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		
		return q.execute().size()+1;
	}
	
	
	
	//--------transa��o---------------
	public static void begin(){	}		// tem que ser vazio
	public static void commit(){
		manager.commit();
	}
	public static void rollback(){
		manager.rollback();
	}
	


}