
package controle;

import dao.MonitorDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Monitor;

/**
 *
 * @author laris
 * Alterado por Vitor Furtado de Oliveira
 */

public class ControleMonitor {

    private Monitor monitor;
    private List<Monitor> listaMonitor = new ArrayList<>();
    private final MonitorDAO monitorDAO = new MonitorDAO();

    public Monitor procurarPorMatricula(String pMatricula){
        this.monitor = monitorDAO.procurarPorMatricula(pMatricula);
        return this.monitor;
    }
    
     public Monitor procurarPorId(Integer id){
        this.monitor = monitorDAO.procurarPorId(id);
        return this.monitor;
    }
    
    public void setMonitor(Monitor monitor){
        this.monitor = monitor;
    }
    
    public Monitor getMonitor(){
        return this.monitor;
    }
           
    public List<Monitor> listarMonitores(String pDesc){
        this.listaMonitor = monitorDAO.listarMonitores(pDesc);
        return this.listaMonitor;
    }      
    
    public void salvar(Monitor m) throws ParseException{
        this.monitorDAO.salvar(m);
    }
}
