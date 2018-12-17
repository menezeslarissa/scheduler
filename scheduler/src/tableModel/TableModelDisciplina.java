/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import controle.ControleDisciplina;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Disciplina;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDisciplina extends AbstractTableModel{
    private Disciplina disciplina;
    private List<Disciplina> listaDisciplinas;
    private ControleDisciplina controleDisciplina = new ControleDisciplina();
   
    
    public TableModelDisciplina(List<Disciplina> listaDisciplinas){
        this.listaDisciplinas = listaDisciplinas;
    }
    
    @Override
    public int getRowCount() {
        return listaDisciplinas.size();
       
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        disciplina = listaDisciplinas.get(linha);
        
        if (coluna == 0)
        {
            return disciplina.getIddisc();
        }
        else
        {
            if (coluna == 1)
            {
                return disciplina.getDescricao();
            }
            else
            {
                if (coluna == 2)
                {
                    return disciplina.getResumo();
                }
                else
                {
                    if (coluna == 3){
                        if (disciplina.getStatus() == 'A')
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
            case 1 : return "Sigla";  
            case 2 : return "Disciplina"; 
            case 3 : return "Situação";
        }
        return null;
    }
}
