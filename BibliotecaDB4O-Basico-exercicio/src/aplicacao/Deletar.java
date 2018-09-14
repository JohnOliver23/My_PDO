package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import java.util.Iterator;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import modelo.Autor;
import modelo.Livro;


public class Deletar {
	protected static ObjectContainer manager;

	public Deletar(){
		abrirBancoLocal();

		deletar();

		manager.close();	
		System.out.println("\n\n aviso: feche sempre o plugin eclipse antes de executar aplicação");
	}

	public void abrirBancoLocal(){
	EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
	config.common().messageLevel(0);
	config.common().objectClass(Autor.class).cascadeOnDelete(true);
	config.common().objectClass(Autor.class).cascadeOnUpdate(true);
	config.common().objectClass(Autor.class).cascadeOnActivate(true);
	config.common().objectClass(Livro.class).cascadeOnDelete(true);
	config.common().objectClass(Livro.class).cascadeOnUpdate(true);
	config.common().objectClass(Livro.class).cascadeOnActivate(true);
	manager = Db4oEmbedded.openFile(config,"banco.db4o");
	IDControl.registrarManager(manager);
	}

	public void deletar(){
		System.out.println("Excluindo...");
		//localizar livro titulo java
		Query q = manager.query();
		q.constrain(Livro.class);
		q.descend("titulo").constrain("java");
		List<Livro> livros = q.execute();
		Livro java = null;
		if(livros.size()>0) {
			java = livros.get(0);
		}
		//remover os autores do livro
		System.out.println(java.getTotalAutores());
		for(Autor a : java.getAutores()) {
			a.removerLivro(java);
		}
		manager.store(java);
		manager.commit();
		Iterator i = java.getAutores().iterator(); //obtém o iterator
		while(i.hasNext()) { //testa se há elementos
			Autor a = (Autor) i.next(); //acessa cada elemento
			i.remove(); //remove o elemento atual
		}
		manager.store(java);
		manager.commit();


	}


	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

