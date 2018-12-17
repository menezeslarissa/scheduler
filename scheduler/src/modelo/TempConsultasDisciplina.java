/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;



/**
 *
 * @author laris
 */

public class TempConsultasDisciplina {
    
    @Transient
    @OneToOne
    @JoinColumn(name="iddisc")
    private Disciplina disciplina;

    private Integer qtde_alunos;  
    
    @Transient
    @OneToOne
    @JoinColumn(name="idperiodo")
    private Periodo periodo;
    
    public TempConsultasDisciplina(){}

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getQtde_alunos() {
        return qtde_alunos;
    }

    public void setQtde_alunos(Integer qtde_alunos) {
        this.qtde_alunos = qtde_alunos;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    
    
}
