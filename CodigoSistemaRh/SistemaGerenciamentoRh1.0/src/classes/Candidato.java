package classes;

public class Candidato extends Usuario {
	
	private  int idcandidato;
	private String nascimento;
	private String nacionalidade;
	private String sexo;
	private String raca;
	private String linkedin;
	private String telefone;
	private String celular;
	private String cep;
	private String logadouro;
	private String endereco;
	private String numero;
	private String cidade;
	private String complemento;
	private Usuario usuario;
	private Formacao formacao;
	private Curso curso;
	private Experiencia experiencia;
	
	
	public Candidato() {
		super();
	}

	public Candidato(int idcandidato, String nascimento, String nacionalidade, String sexo, String raca, String linkedin,
			String telefone, String celular, String cep, String logadouro, String endereco, String numero,
			String cidade, String complemento, Usuario usuario, Formacao formacao, Curso curso,
			Experiencia experiencia) {
		super();
		this.idcandidato = idcandidato;
		this.nascimento = nascimento;
		this.nacionalidade = nacionalidade;
		this.sexo = sexo;
		this.raca = raca;
		this.linkedin = linkedin;
		this.telefone = telefone;
		this.celular = celular;
		this.cep = cep;
		this.logadouro = logadouro;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.complemento = complemento;
		this.usuario = usuario;
		this.formacao = formacao;
		this.curso = curso;
		this.experiencia = experiencia;
	}

	public int getId() {
		return idcandidato;
	}

	public void setId(int idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nascionalidade) {
		this.nacionalidade = nascionalidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	

}
