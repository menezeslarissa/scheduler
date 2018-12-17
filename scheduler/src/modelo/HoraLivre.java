/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vitor Furtado de Oliveira
 */

@NamedStoredProcedureQuery(
	name = "validacao_inserir_horalivre", 
	procedureName = "validacao_inserir_horalivre", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_dia_semana"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_sala"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_horario"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_idperiodo"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "mensagem")
	}
)

@Entity
@Table(name="horalivre")
public class HoraLivre implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private Integer dia_semana;
    private String horario;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    @OneToOne
    @JoinColumn(name="sala")
    private Sala sala;
    
    @OneToOne
    @JoinColumn(name="periodo")
    private Periodo periodo;
     
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the dia_semana
     */
    public Integer getDia_semana() {
        return dia_semana;
    }

    /**
     * @param dia_semana the dia_semana to set
     */
    public void setDia_semana(Integer dia_semana) {
        this.dia_semana = dia_semana;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(String sala) {
        this.setSala(sala);
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    

    
}
