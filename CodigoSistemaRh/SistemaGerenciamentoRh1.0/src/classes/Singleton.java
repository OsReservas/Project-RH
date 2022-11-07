package classes;

public class Singleton {
	
	private static Singleton instance;
	
	private String nomeUsuario;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public void setNomeUsuario(String nome) {
		this.nomeUsuario = nome;
	}
	
	public String getNomeUsuario() {
	    return this.nomeUsuario;
	}

}
