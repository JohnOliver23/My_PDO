package modelo;

public class Estadio {
	private int id;
	private String nome;
	
	/*constructor*/
	public Estadio(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	/*getters and setters */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
