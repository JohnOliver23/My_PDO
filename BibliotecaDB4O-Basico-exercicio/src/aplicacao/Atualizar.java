package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import modelo.Autor;
import modelo.Livro;


public class Atualizar {
	protected static ObjectContainer manager;

	public Atualizar(){
		abrirBancoLocal();

		alterar();
		
		manager.close();	
		System.out.println("\n\n aviso: feche sempre o plugin eclipse antes de executar aplicação");
	}

	public void abrirBancoLocal(){
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0);
		config.common().objectClass(Autor.class).cascadeOnDelete(false);
		config.common().objectClass(Autor.class).cascadeOnUpdate(true);
		config.common().objectClass(Autor.class).cascadeOnActivate(true);
		config.common().objectClass(Livro.class).cascadeOnDelete(false);
		config.common().objectClass(Livro.class).cascadeOnUpdate(true);
		config.common().objectClass(Livro.class).cascadeOnActivate(true);
		manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
		IDControl.registrarManager(manager);
		}
	
	public void alterar(){
		System.out.println("Alterando...");
		//localizar livro titulo java
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain("java");
		List<Livro> livros = q.execute();
		Livro java = null;
		if(livros.size() >0) {
			 java = livros.get(0);
		}
		//localizar autor nome jose
		Query q2 = manager.query();
		q2.constrain(Autor.class);
		q2.descend("nome").constrain("jose");
		List<Autor> autores = q2.execute();
		Autor jose = null;
		if(autores.size() > 0) {
			 jose = autores.get(0);
		}
		//adicionar autor no livro
		java.adicionarAutor(jose);
		jose.adicionarLivro(java);
		manager.store(java);
		manager.commit();
		
	}
	
	

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

