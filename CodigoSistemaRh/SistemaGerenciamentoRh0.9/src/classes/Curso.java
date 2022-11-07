package classes;

public class Curso {

	private String nomeCurso;
	private String InstituiçãoCurso;
	private String segmento;
	private String anoConclusao;
	private String nivelCurso;
	private String idioma;  
	private int id;
	
	
	public Curso() {
		super();
	}


	public Curso(String nomeCurso, String instituiçãoCurso, String segmento, String anoConclusao, String nivelCurso,
			String idioma, int id) {
		super();
		this.nomeCurso = nomeCurso;
		InstituiçãoCurso = instituiçãoCurso;
		this.segmento = segmento;
		this.anoConclusao = anoConclusao;
		this.nivelCurso = nivelCurso;
		this.idioma = idioma;
		this.id = id;
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
