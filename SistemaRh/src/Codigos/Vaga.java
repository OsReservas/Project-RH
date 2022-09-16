/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos;

/**
 *
 * @author marce
 */
public class Vaga {
    
    private String tituloVaga;
    private String cargo;
    private String formacaoAcademica;
    private String periodo;
    private String regime;
    private String descricaoVaga;
    private double salario;

    
    //caracteristicas que a vaga tem que ter para ser criada
        public Vaga(String tituloVaga, String cargo, String formacaoAcademica, String periodo, String regime, String descricaoVaga, double salario) {
        this.tituloVaga = tituloVaga;
        this.cargo = cargo;
        this.formacaoAcademica = formacaoAcademica;
        this.periodo = periodo;
        this.regime = regime;
        this.descricaoVaga = descricaoVaga;
        this.salario = salario;
    }
    
        
    //metodos para manipulação dos atributos
        
    public String getTituloVaga() {
        return tituloVaga;
    }

    public void setTituloVaga(String tituloVaga) {
        this.tituloVaga = tituloVaga;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
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

    public String getDescricaoVaga() {
        return descricaoVaga;
    }

    public void setDescricaoVaga(String descricaoVaga) {
        this.descricaoVaga = descricaoVaga;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
    
    
    
}
