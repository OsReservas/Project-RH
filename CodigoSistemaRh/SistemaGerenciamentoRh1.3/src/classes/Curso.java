package classes;

public class Curso {

	private String nomeCurso;
	private String InstituiçãoCurso;
	private String segmento;
	private String anoConclusao;
	private String nivelCurso;
	private String idioma;  
	private int idcurso;
	private Candidato candidato;
	
	public Curso(String nomeCurso, String instituiçãoCurso, String segmento, String anoConclusao, String nivelCurso,
			String idioma, int idcurso, Candidato candidato) {
		super();
		this.nomeCurso = nomeCurso;
		InstituiçãoCurso = instituiçãoCurso;
		this.segmento = segmento;
		this.anoConclusao = anoConclusao;
		this.nivelCurso = nivelCurso;
		this.idioma = idioma;
		this.idcurso = idcurso;
		this.candidato = candidato;
	}

	public Curso() {
		super();
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getInstituiçãoCurso() {
		return InstituiçãoCurso;
	}

	public void setInstituiçãoCurso(String instituiçãoCurso) {
		InstituiçãoCurso = instituiçãoCurso;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(String anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	
	
}
