/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
/**
 *
 * @author larissa
 */

@NamedStoredProcedureQuery(
name = "validacao_agendamento", 
procedureName = "validacao_agendamento", 
parameters = { 
@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_matricula"), 
@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_id_horarioreservado"), 
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "mensagem")
}
)
    
    


@Entity
@Table(name="horario_agenda_aluno")
public class HorarioAgendaAluno {
    
    @Id
    @GeneratedValue
    private Integer idagendaaluno;
    
    @OneToOne
    @JoinColumn(name="id")
    private HorarioReservado horarioReservado;
    
    @OneToOne
    @JoinColumn(name="matricula")
    private Aluno aluno;

    public HorarioAgendaAluno(){}
    
    public HorarioAgendaAluno(HorarioReservado h, Aluno a){
        this.horarioReservado = h;
        this.aluno = a;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return idagendaaluno;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.idagendaaluno = id;
    }

    /**
     * @return the horarioReservado
     */
    public HorarioReservado getHorarioReservado() {
        return horarioReservado;
    }

    /**
     * @param horarioReservado the horarioReservado to set
     */
    public void setHorarioReservado(HorarioReservado horarioReservado) {
        this.horarioReservado = horarioReservado;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
