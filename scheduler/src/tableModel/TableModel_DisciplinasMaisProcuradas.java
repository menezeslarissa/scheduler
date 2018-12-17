/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Consulta1;

/**
 *
 * @author laris
 */
public class TableModel_DisciplinasMaisProcuradas extends AbstractTableModel {

    private final List<Consulta1> consulta1;
 

    public TableModel_DisciplinasMaisProcuradas(List<Consulta1> consulta) {
        this.consulta1 = consulta;
    }

    @Override
    public int getRowCount() {
        return this.consulta1.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Consulta1 c = consulta1.get(linha);

        switch (coluna) {
            case 0:
              return c.getDisciplina();
            case 1:
                return c.getQtde();
            case 2:

                return c.getPeriodo();

        }

        return null;
    }

    public String getColumnName(int coluna) {

        switch (coluna) {
            case 0:
                return "Disciplina";
            case 1:
                return "Quantidade";
            case 2:
                return "Período";
        }
        return null;
    }
}
