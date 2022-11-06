package javafx.model.domain;

public class Vaga {
	
	private int idVaga;
	private String tituloVaga;
	private String cargo;
	private String formacao;
	private String periodo;
	private String RegimeDeTrabalho;
	private String descricao;
	private String salario;
	
	
	

	// Super Contruct
	public Vaga() {
		
	}
	
	
	
	// Contruct
	

	public String getTituloVaga() {
		return tituloVaga;
	}
	public Vaga(int idVaga, String tituloVaga, String cargo, String formacao, String periodo, String regimeDeTrabalho,
			String descricao, String salario) {
		super();
		this.idVaga = idVaga;
		this.tituloVaga = tituloVaga;
		this.cargo = cargo;
		this.formacao = formacao;
		this.periodo = periodo;
		RegimeDeTrabalho = regimeDeTrabalho;
		this.descricao = descricao;
		this.salario = salario;
	}
	
	

	
	
	// Getters and Setters
	
	
	




	public void setTituloVaga(String tituloVaga) {
		this.tituloVaga = tituloVaga;
	}
	public int getIdVaga() {
		return idVaga;
	}



	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	


	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getRegimeDeTrabalho() {
		return RegimeDeTrabalho;
	}
	public void setRegimeDeTrabalho(String regimeDeTrabalho) {
		RegimeDeTrabalho = regimeDeTrabalho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	
	
	

}
