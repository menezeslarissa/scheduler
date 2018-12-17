
package tableModel;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.HorarioReservado;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDiaSemana_HorarioAgendaMonitor extends AbstractTableModel{

    private HorarioReservado horarioreservado;
    private List<HorarioReservado> listahorarioreservado;
    
    public TableModelDiaSemana_HorarioAgendaMonitor(List<HorarioReservado> listahorarioreservado)
    {
        this.listahorarioreservado = listahorarioreservado;
    }
    
    @Override
    public int getRowCount() {
        return listahorarioreservado.size();
       
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        horarioreservado = listahorarioreservado.get(linha);
        
        
        if (coluna == 0){
            Integer diasemana = horarioreservado.getDia_semana();
            
            switch(diasemana){
                case 1 : return "Segunda-Feira";
                case 2 : return "Terça-Feira";
                case 3 : return "Quarta-Feira";
                case 4 : return "Quinta-feira";
                case 5 : return "Sexta-Feira";
            }
        }
        else if (coluna == 1){
            String dataStr = horarioreservado.getData().toString();
            return dataStr.substring(8,10) + '/' + dataStr.substring(5,7) + '/' + dataStr.substring(0,4);
        }
        else if (coluna == 2){
            return horarioreservado.getHorario();
        } 
        else if (coluna == 3){
            return horarioreservado.getIdsala().getDescricao();
        } else if (coluna == 4){
            return horarioreservado.getQtd_alunos().toString();
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
            case 4 : return "Qtd. de Alunos";
        }
        return null;
    }
}
