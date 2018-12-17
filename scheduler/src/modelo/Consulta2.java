/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author laris
 */
public class Consulta2 {
    private Double qtde;
    private String disciplina;
    private String periodo;

    public Consulta2() {
    }

    public Consulta2(Double qtde, String disciplina, String periodo) {
        this.qtde = qtde;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }


    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
}
