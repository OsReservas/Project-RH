package classes;

public class Singleton {
	
	private static Singleton instance;
	
	private Candidato candidato;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
			instance = new Singleton();
		return instance;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
}
