package classes;


public class FormacaoSin {
	
	private static FormacaoSin instance ;
	private Formacao formacao;
	
	private FormacaoSin() {}
	
	public static FormacaoSin getInstance() {
		if(instance == null) {
			instance = new FormacaoSin();
		}
			return instance;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	
	



	
	
	
	
}
