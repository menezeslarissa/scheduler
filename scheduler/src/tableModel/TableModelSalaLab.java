/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import controle.ControleSala;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Sala;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelSalaLab extends AbstractTableModel{
    private Sala sala;
    private List<Sala> listaSalas;
    private ControleSala controleSala = new ControleSala();
   
    
    public TableModelSalaLab(List<Sala> listaSalas){
        this.listaSalas = listaSalas;
    }
    
    @Override
    public int getRowCount() {
        return listaSalas.size();
       
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        sala = listaSalas.get(linha);
        
        if (coluna == 0)
        {
            return sala.getId();
        }
        else
        {
            if (coluna == 1)
            {
                return sala.getDescricao();
            }
            else
            {
                if (coluna == 2)
                {
                    return sala.getLocal();
                }
                else
                {
                    if (coluna == 3){
                        if (sala.getStatus() == 'A')
                        {
                            return "Ativo";
                        }
                        else
                        {
                            return "Inativo";
                        }
                    }
                }
            } 
        }
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "ID";  
            case 1 : return "Nome";  
            case 2 : return "Local"; 
            case 3 : return "Situação";
        }
        return null;
    }
}
