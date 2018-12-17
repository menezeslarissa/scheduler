
package tableModel;

import controle.ControleMonitor;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Monitor;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelMonitor extends AbstractTableModel{
    private Monitor monitor;
    private List<Monitor> listaMonitores;
    private ControleMonitor controleMonitor = new ControleMonitor();
   
    
    public TableModelMonitor(List<Monitor> listaMonitores){
        this.listaMonitores = listaMonitores;
    }
    
    @Override
    public int getRowCount() {
        return listaMonitores.size();
       
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        monitor = listaMonitores.get(linha);
        
        if (coluna == 0)
        {
            return monitor.getId();
        }
        else
        {
            if (coluna == 1)
            {
                return monitor.getMatricula();
            }
            else
            {
                if (coluna == 2)
                {
                    return monitor.getNome();
                }
                else if (coluna == 3)
                {
                    return monitor.getDisciplina().getResumo();
                }
            } 
        }
        
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Id";  
            case 1 : return "Matrícula";  
            case 2 : return "Nome";  
            case 3 : return "Disciplina";  
        }
        return null;
    }
}
