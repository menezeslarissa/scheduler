
package tableModel;


import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.HorarioAgendaAluno;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelDiaSemana_AlunosMatriculados extends AbstractTableModel{

    private HorarioAgendaAluno horarioagendaaluno;
    private List<HorarioAgendaAluno> listaHorarioAgendaAluno;
    char p;
    
    public TableModelDiaSemana_AlunosMatriculados(List<HorarioAgendaAluno> listaHorarioAgendaAluno, char perfil)
    {
        this.listaHorarioAgendaAluno = listaHorarioAgendaAluno;
        this.p = perfil;
    }
    
    @Override
    public int getRowCount() {
        return listaHorarioAgendaAluno.size();
    }

    @Override
    public int getColumnCount() {
        if(p == 'C'){
           return 2;
        } else{
            if(p == 'M'){
                 return 3;
            }
        }
       return 0;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        horarioagendaaluno = listaHorarioAgendaAluno.get(linha);
        
        switch(coluna){
            case 0:
               return horarioagendaaluno.getAluno().getMatricula(); 
            case 1:
               return horarioagendaaluno.getAluno().getNome();
            case 2:
                
               return "Presente/Faltou";
               
        }
        
        
        return null;
    }
     
    public String getColumnName(int coluna)
    {
  
        switch(coluna)
        {
            case 0 : return "Matrícula";  
            case 1 : return "Nome";
            case 2:
                return "Presença";
        }
        return null;
    }
}
