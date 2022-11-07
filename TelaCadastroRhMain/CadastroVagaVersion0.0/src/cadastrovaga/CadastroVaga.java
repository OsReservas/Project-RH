package cadastrovaga;

class CadastroVaga {
    private String tituloVaga;
    private String cargo;
    private String formacaoAcademica;
    private String periodo;
    private String regime;
    private String descricaoVaga;
    private String salario;

//construtores
    public CadastroVaga(String tituloVaga, String cargo, String formacaoAcademica, String periodo, String regime, String descricaoVaga, String salario) {
        this.tituloVaga = tituloVaga;
        this.cargo = cargo;
        this.formacaoAcademica = formacaoAcademica;
        this.periodo = periodo;
        this.regime = regime;
        this.descricaoVaga = descricaoVaga;
        this.salario = salario;
    }

//buscadores de informação
    public String getTituloVaga() {
        return tituloVaga;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getRegime() {
        return regime;
    }

    public String getDescricaoVaga() {
        return descricaoVaga;
    }

    public String getSalario() {
        return salario;
    }

//definidores de informação
    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public void setDescricaoVaga(String descricaoVaga) {
        this.descricaoVaga = descricaoVaga;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
}
