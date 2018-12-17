
package modelo;

import java.io.Serializable;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
@SqlResultSetMapping(
        name = "consulta2",
        classes = @ConstructorResult(
                targetClass = Consulta2.class,
                columns = {
                    @ColumnResult(name = "qtde", type = Double.class),
                    @ColumnResult(name = "descricao", type = String.class),
                    @ColumnResult(name = "periodo", type = String.class)}))

@Entity
public class Login implements Serializable {
    
    @Id
    @GeneratedValue
    private String id;
    private String usuario;
    private String senha;
    private String nome;
    private char perfil;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perfil
     */
    public char getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
