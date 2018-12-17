/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
@Entity
@Table(name="sala")
public class Sala implements Serializable{
    @Id
    @GeneratedValue
    private Integer idsala;
    private String descricao; 
    private String local;
    private char status;

    /**
     * @return the id
     */
    public Integer getId() {
        return getIdsala();
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.setIdsala(id);
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
     * @return the idsala
     */
    public Integer getIdsala() {
        return idsala;
    }

    /**
     * @param idsala the idsala to set
     */
    public void setIdsala(Integer idsala) {
        this.idsala = idsala;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
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