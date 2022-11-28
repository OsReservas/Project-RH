package classes;

import java.util.Date;

public class Aplicado {
	
	private Integer idaplicado;
	private Date data;
	private Candidato candidato;
	private Vaga vaga;
	private String andamento;
	private String observacao;
	
	public Aplicado(Integer idaplicado, Date data, Candidato candidato, Vaga vaga, String andamento,
			String observacao) {
		super();
		this.idaplicado = idaplicado;
		this.data = data;
		this.candidato = candidato;
		this.vaga = vaga;
		this.andamento = andamento;
		this.observacao = observacao;
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

	public String getAndamento() {
		return andamento;
	}

	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}