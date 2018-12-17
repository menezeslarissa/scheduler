
package modelo;

import java.io.Serializable;
import java.util.Date;
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
 * @author Vitor Furtado de Oliveira
 */
//p_data varchar(10), p_horario varchar(45),
//p_dia_semana int(11), p_iddisc int(11), p_idmon int(11), p_idsala int(11)
@NamedStoredProcedureQuery(
	name = "validacao_inserir", 
	procedureName = "validacao_inserir", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_data"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_horario"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_dia_semana"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_iddisc"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_idmon"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_idsala"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "mensagem")
	}
)

@Entity
@Table(name="horario_reservado")
public class HorarioReservado implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Date data;
    private Integer dia_semana;
    private char status;
        
    @OneToOne
    @JoinColumn(name = "idsala")
    private Sala idsala;
    
    @OneToOne
    @JoinColumn(name = "idmon")
    private Monitor idmon;
    
    private Integer qtd_alunos;
        
    @OneToOne
    @JoinColumn(name = "iddisc")
    private Disciplina iddisc;
    
    @OneToOne
    @JoinColumn(name = "periodo")
    private Periodo periodo;
    
    
    private String horario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(Integer dia_semana) {
        this.dia_semana = dia_semana;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Sala getIdsala() {
        return idsala;
    }

    public void setIdsala(Sala idsala) {
        this.idsala = idsala;
    }

    public Monitor getIdmon() {
        return idmon;
    }

    public void setIdmon(Monitor idmon) {
        this.idmon = idmon;
    }

    public Integer getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(Integer qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public Disciplina getIddisc() {
        return iddisc;
    }

    public void setIddisc(Disciplina iddisc) {
        this.iddisc = iddisc;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    
}