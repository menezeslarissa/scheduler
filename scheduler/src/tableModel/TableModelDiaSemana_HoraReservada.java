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
import modelo.HorarioReservado;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDiaSemana_HoraReservada extends AbstractTableModel{

    private HorarioReservado horarioreservado;
    private List<HorarioReservado> listaHorarioReservado;
    private Integer dia_semana;
    
    public TableModelDiaSemana_HoraReservada(List<HorarioReservado> listaHorarioReservado, Integer pdia_semana)
    {
        this.listaHorarioReservado = listaHorarioReservado;
        this.dia_semana = pdia_semana;
    }
    
    @Override
    public int getRowCount() {
        return listaHorarioReservado.size();
       
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        horarioreservado = listaHorarioReservado.get(linha);
       
        switch(coluna){
            case 0: return horarioreservado.getHorario();
           
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
