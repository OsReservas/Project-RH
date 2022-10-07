package classes;

public class Usuario {
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String acesso;
	private String ativo;
	
	
	public Usuario() {
	}

	public Usuario(int id, String nome, String senha, String cpf, String acesso, String ativo) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.acesso = acesso;
		this.ativo = ativo;
	}
	
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	
	

}
