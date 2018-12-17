/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
@SqlResultSetMapping(
        name = "consulta1",
        classes = @ConstructorResult(
                targetClass = Consulta1.class,
                columns = {
                    @ColumnResult(name = "qtde", type = BigInteger.class),
                    @ColumnResult(name = "descricao", type = String.class),
                    @ColumnResult(name = "periodo", type = String.class)}))

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable{
    @Id
    @GeneratedValue
    private Integer iddisc;
    private String descricao; 
    private String resumo;
    private char status;

    public Integer getIddisc() {
        return iddisc;
    }

    /**
     * @return the id
     */
    /**
     * @param id the id to set
     */
    public void setIddisc(Integer iddisc) {   
        this.iddisc = iddisc;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }
}
