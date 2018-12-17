
package controle;

import dao.HorarioAgendaAlunoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.HorarioAgendaAluno;
import modelo.HorarioReservado;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ControleHorarioAgendaAluno {
    private HorarioAgendaAluno horarioagendaaluno = new HorarioAgendaAluno();
    private HorarioReservado horarioReservado = new HorarioReservado();
    private List<HorarioAgendaAluno> listaHorarioAgendaAluno = new ArrayList<>();
    private HorarioAgendaAlunoDAO dao = new HorarioAgendaAlunoDAO();
    
    public void salvar(HorarioAgendaAluno a ){
        dao.salvar(a);
    }

    public void setHorarioReservado(HorarioReservado horarioReservado) {
        this.horarioReservado = horarioReservado;
    }

    public void setAgendaAluno(HorarioAgendaAluno horarioagendaaluno) {
        this.horarioagendaaluno = horarioagendaaluno;
    }
    
    public List<HorarioAgendaAluno> listar(String pMatricula) throws ParseException, SQLException
    {
       this.listaHorarioAgendaAluno = dao.listarHorarioAgendaAluno(pMatricula);
       return this.listaHorarioAgendaAluno;
    }
    
    public String salvar(String matricula, Integer id ){
        return dao.salvar(matricula, id);
    }
    
    public List<HorarioAgendaAluno> listarAlunosMatriculados(Integer pId) throws ParseException, SQLException
    {
       this.listaHorarioAgendaAluno = dao.listarAlunosMatriculados(pId);
       return this.listaHorarioAgendaAluno;
    }
    
    public List<HorarioAgendaAluno> listarPorId(Integer id){
        this.listaHorarioAgendaAluno = dao.listarPorId(id);
       return this.listaHorarioAgendaAluno;
    }

}
