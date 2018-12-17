
package controle;
import dao.LoginDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Login;

/**
 *
 * @author Vitor Furtado de Oliveira
 */

public class ControleLogin {
    private Login login;
    private List<Login> listaLogin = new ArrayList<>();
    private final LoginDAO loginDAO = new LoginDAO();
    
    public Login getLogin() {
        return this.login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Login buscarLogin(String pUsuario, String pSenha)
    {
        this.login = loginDAO.buscarLogin(pUsuario, pSenha);
        return this.login;
    }
    
    
    /*
    
    public List<Login> listar(String pDesc) throws ParseException, SQLException
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
*/
}
