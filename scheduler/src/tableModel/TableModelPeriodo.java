
package tableModel;

import controle.ControlePeriodo;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Periodo;

/**
 *
 * @author Vitor Furtado de Oliveira
 */

public class TableModelPeriodo extends AbstractTableModel{
    private Periodo periodo;
    private List<Periodo> listaPeriodos;
    private ControlePeriodo controlePeriodo = new ControlePeriodo();
   
    
    public TableModelPeriodo (List<Periodo> listaPeriodos){
        this.listaPeriodos = listaPeriodos;
    }
    
    @Override
    public int getRowCount() {
        return listaPeriodos.size();
       
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        periodo = listaPeriodos.get(linha);
        
        if (coluna == 0)
        {
            return periodo.getId();
        }
        else
        {
            if (coluna == 1)
            {
                return periodo.getPeriodo();
            }  
        }
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "ID";  
            case 1 : return "Período";  
        }
        return null;
    }
}
