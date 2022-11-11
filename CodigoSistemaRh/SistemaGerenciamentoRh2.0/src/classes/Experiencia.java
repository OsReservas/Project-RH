package classes;

public class Experiencia {
	
	private String empresa;
	private String cargo;
	private String segmento;
	private String inicioExp;
	private String terminoExp;
	private String atualEmprego;  
	private String descricaoExp;
	private int idexperiencia;
	private Candidato candidato;
	
	
	public Experiencia(String empresa, String cargo, String segmento, String inicioExp, String terminoExp,
			String atualEmprego, String descricaoExp, int idexperiencia, Candidato candidato) {
		super();
		this.empresa = empresa;
		this.cargo = cargo;
		this.segmento = segmento;
		this.inicioExp = inicioExp;
		this.terminoExp = terminoExp;
		this.atualEmprego = atualEmprego;
		this.descricaoExp = descricaoExp;
		this.idexperiencia = idexperiencia;
		this.candidato = candidato;
	}


	public Experiencia() {
		super();
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSegmento() {
		return segmento;
	}


	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}


	public String getInicioExp() {
		return inicioExp;
	}


	public void setInicioExp(String inicioExp) {
		this.inicioExp = inicioExp;
	}


	public String getTerminoExp() {
		return terminoExp;
	}


	public void setTerminoExp(String terminoExp) {
		this.terminoExp = terminoExp;
	}


	public String getAtualEmprego() {
		return atualEmprego;
	}


	public void setAtualEmprego(String atualEmprego) {
		this.atualEmprego = atualEmprego;
	}


	public String getDescricaoExp() {
		return descricaoExp;
	}


	public void setDescricaoExp(String descricaoExp) {
		this.descricaoExp = descricaoExp;
	}


	public int getIdexperiencia() {
		return idexperiencia;
	}


	public void setIdexperiencia(int idexperiencia) {
		this.idexperiencia = idexperiencia;
	}


	public Candidato getCandidato() {
		return candidato;
	}


	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	


}