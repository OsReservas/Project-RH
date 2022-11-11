package classes;

import java.util.Date;

public class Aplicado {
	
	private Integer idaplicado;
	private Date data;
	private Candidato candidato;
	private Vaga vaga;
	
	
	public Aplicado(Integer idaplicado, Date data, Candidato candidato, Vaga vaga) {
		super();
		this.idaplicado = idaplicado;
		this.data = data;
		this.candidato = candidato;
		this.vaga = vaga;
	}


	public Aplicado() {
		super();
	}


	public Integer getIdAplicado() {
		return idaplicado;
	}


	public void setIdAplicado(Integer idaplicado) {
		this.idaplicado = idaplicado;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
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