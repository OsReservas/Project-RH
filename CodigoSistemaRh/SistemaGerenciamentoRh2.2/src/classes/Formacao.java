package classes;

public class Formacao {
	
	private int id;
	private String tipoFormacao;
	private String nomeFormacao;
	private String instituicao;
	private String inicioFormacao;
	private String terminoFormacao;
	private String situacao;
	private Candidato candidato;
	
	public Formacao(int id, String tipoFormacao, String nomeFormacao, String instituicao, String inicioFormacao,
			String terminoFormacao, String situacao, Candidato candidato) {
		super();
		this.id = id;
		this.tipoFormacao = tipoFormacao;
		this.nomeFormacao = nomeFormacao;
		this.instituicao = instituicao;
		this.inicioFormacao = inicioFormacao;
		this.terminoFormacao = terminoFormacao;
		this.situacao = situacao;
		this.candidato = candidato;
	}

	public Formacao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoFormacao() {
		return tipoFormacao;
	}

	public void setTipoFormacao(String tipoFormacao) {
		this.tipoFormacao = tipoFormacao;
	}

	public String getNomeFormacao() {
		return nomeFormacao;
	}

	public void setNomeFormacao(String nomeFormacao) {
		this.nomeFormacao = nomeFormacao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getInicioFormacao() {
		return inicioFormacao;
	}

	public void setInicioFormacao(String inicioFormacao) {
		this.inicioFormacao = inicioFormacao;
	}

	public String getTerminoFormacao() {
		return terminoFormacao;
	}

	public void setTerminoFormacao(String terminoFormacao) {
		this.terminoFormacao = terminoFormacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	} 
	
	
	

}
