
package controle;
import dao.PeriodoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Periodo;

/**
 *
 * @author Vitor Furtado de Oliveira
 */

public class ControlePeriodo {
    private Periodo periodo;
    private List<Periodo> listaPeriodo = new ArrayList<>();
    private final PeriodoDAO periodoDAO = new PeriodoDAO();
  
    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    public List<Periodo> listar() throws ParseException, SQLException
    {
       this.listaPeriodo = periodoDAO.listarPeriodos();
       return this.listaPeriodo;
    }
 
    public Periodo buscarUltimoPeriodo(){
        this.periodo = periodoDAO.buscarUltimoPeriodo();
        return this.periodo;
    }
    
    public boolean salvar(Periodo p){
       return this.periodoDAO.salvar(p);
    }
}