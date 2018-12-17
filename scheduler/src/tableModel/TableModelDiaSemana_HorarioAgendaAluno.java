/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.HorarioAgendaAluno;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDiaSemana_HorarioAgendaAluno extends AbstractTableModel{

    private HorarioAgendaAluno horarioagendaaluno;
    private List<HorarioAgendaAluno> listaHorarioAgendaAluno;
    
    public TableModelDiaSemana_HorarioAgendaAluno(List<HorarioAgendaAluno> listaHorarioAgendaAluno)
    {
        this.listaHorarioAgendaAluno = listaHorarioAgendaAluno;
    }
    
    @Override
    public int getRowCount() {
        return listaHorarioAgendaAluno.size();
       
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        horarioagendaaluno = listaHorarioAgendaAluno.get(linha);
        
        
        if (coluna == 0){
            Integer diasemana = horarioagendaaluno.getHorarioReservado().getDia_semana();
            
            switch(diasemana){
                case 1 : return "Segunda-Feira";
                case 2 : return "Terça-Feira";
                case 3 : return "Quarta-Feira";
                case 4 : return "Quinta-feira";
                case 5 : return "Sexta-Feira";
            }
        }
        else if (coluna == 1){
            String dataStr = horarioagendaaluno.getHorarioReservado().getData().toString();
            return dataStr.substring(8,10) + '/' + dataStr.substring(5,7) + '/' + dataStr.substring(0,4);
        }
        else if (coluna == 2){
            return horarioagendaaluno.getHorarioReservado().getHorario();
        } 
        else if (coluna == 3){
            return horarioagendaaluno.getHorarioReservado().getIdsala().getDescricao();
        } 
        else if (coluna == 4){
            return horarioagendaaluno.getHorarioReservado().getIddisc().getDescricao();
        } 
        else if (coluna == 5){
            return horarioagendaaluno.getHorarioReservado().getIdmon().getNome();
        }
            
      
        return null;
    }
     
    public String getColumnName(int coluna)
    {
  
        switch(coluna)
        {
            case 0 : return "Dia da Semana";  
            case 1 : return "Data";
            case 2 : return "Horário";
            case 3 : return "Sala";
            case 4 : return "Disciplina";
            case 5 : return "Monitor";
        }
        return null;
    }
}
