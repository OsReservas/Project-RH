package classes;

public class Vaga {
	
	 private int id;
	 private String titulo;
	 private String cargo;
	 private String formacao;
	 private String periodo;
	 private String regime;
	 private String descricao;
	 private String salario;
	 private String ativo;
	 
	 public Vaga() {
	}
	 
	public Vaga(int id, String titulo, String cargo, String formacao, String periodo, String regime,
			String descricao, String salario, String ativo) {
		this.id = id;
		this.titulo = titulo;
		this.cargo = cargo;
		this.formacao = formacao;
		this.periodo = periodo;
		this.regime = regime;
		this.descricao = descricao;
		this.salario = salario;
		this.ativo = ativo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String getRegime() {
		return regime;
	}
	public void setRegime(String regime) {
		this.regime = regime;
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

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	

}
