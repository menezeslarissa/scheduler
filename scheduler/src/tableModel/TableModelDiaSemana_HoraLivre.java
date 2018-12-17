/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.HoraLivre;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDiaSemana_HoraLivre extends AbstractTableModel{

    private HoraLivre horalivre;
    private List<HoraLivre> listahoralivre;
    private Integer dia_semana;
    
    public TableModelDiaSemana_HoraLivre(List<HoraLivre> listahoralivre, Integer dia_semana)
    {
        this.listahoralivre = listahoralivre;
        this.dia_semana = dia_semana;
    }
    
    @Override
    public int getRowCount() {
        return listahoralivre.size();
       
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        horalivre = listahoralivre.get(linha);
        
        switch(coluna){
            case 0: return horalivre.getHorario();
           
        }
        
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(dia_semana)
        {
            case 1 : return "Segunda-Feira";  
            case 2 : return "Terça-Feira";  
            case 3 : return "Quarta-Feira";  
            case 4 : return "Quinta-Feira";  
            case 5 : return "Sexta-Feira";  
        }
        return null;
    }
}
