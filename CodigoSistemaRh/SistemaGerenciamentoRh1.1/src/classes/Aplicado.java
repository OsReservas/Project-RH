package classes;

public class Aplicado {
	
	private int id;
	private String data;
	private Candidato candidato;
	private Vaga vaga;
	
	
	public Aplicado() {
		super();
	}

	public Aplicado(int id, String data, Candidato candidato, Vaga vaga) {
		super();
		this.id = id;
		this.data = data;
		this.candidato = candidato;
		this.vaga = vaga;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	

}
