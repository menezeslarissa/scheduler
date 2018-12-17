
package controle;
import dao.AlunoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

/**
 *
 * @author laris
 * Alterado por Vitor Furtado de Oliveira em 03/10/2018
 */

public class ControleAluno {
    private Aluno aluno;
    private List<Aluno> listaAluno = new ArrayList<>();
    private final AlunoDAO alunoDAO = new AlunoDAO();
    
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
    
    public List<Aluno> listar(String pDesc) throws ParseException, SQLException
    {
       this.listaAluno = alunoDAO.listarAlunos(pDesc);
       return this.listaAluno;
    }
    
    public void salvar(Aluno a){
        this.alunoDAO.salvar(a);
    }
    
    public void update(Aluno a){
        this.alunoDAO.update(a);
    }
    
    public Aluno procurarPorMatricula(String pMatricula){
        this.aluno = alunoDAO.procurarPorMatricula(pMatricula);
        return this.aluno;
    }
    
    public Aluno procurarPorId(Integer pId){
        this.aluno = alunoDAO.procurarPorId(pId);
        return this.aluno;
    }
}