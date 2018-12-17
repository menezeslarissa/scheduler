/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigInteger;

/**
 *
 * @author laris
 */
public class Consulta1 {
    private BigInteger qtde;
    private String disciplina;
    private String periodo;

    public Consulta1() {
    }

    public Consulta1(BigInteger qtde, String disciplina, String periodo) {
        this.qtde = qtde;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }

    public BigInteger getQtde() {
        return qtde;
    }

    public void setQtde(BigInteger qtde) {
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
