
package tableModel;

import controle.ControleAluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Aluno;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class TableModelAluno extends AbstractTableModel{
    private Aluno aluno;
    private List<Aluno> listaAlunos;
    private ControleAluno controleAluno = new ControleAluno();
   
    
    public TableModelAluno (List<Aluno> listaAlunos){
        this.listaAlunos = listaAlunos;
    }
    
    @Override
    public int getRowCount() {
        return listaAlunos.size();
       
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        aluno = listaAlunos.get(linha);
        
        if (coluna == 0)
        {
            return aluno.getMatricula();
        }
        else
        {
            if (coluna == 1)
            {
                return aluno.getNome();
            }
            else
            {
                if (coluna == 2)
                {
                    if (aluno.getStatus() == 'A')
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
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Matrícula";  
            case 1 : return "Nome";  
            case 2 : return "Situação"; 
        }
        return null;
    }
}
