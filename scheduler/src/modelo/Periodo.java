
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author Larissa Menezes e Vitor Furtado de Oliveira
 */

@NamedStoredProcedureQuery(
	name = "validacao_inserir_periodo", 
	procedureName = "validacao_inserir_periodo", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_periodo"), 
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "mensagem")
	}
)

@Entity
public class Periodo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String periodo;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
