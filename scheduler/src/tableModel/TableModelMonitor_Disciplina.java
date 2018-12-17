/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import controle.ControleHorarioReservado;
import controle.ControleMonitor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.HorarioAgendaAluno;
import modelo.HorarioReservado;
import modelo.HorarioReservado_;
import modelo.Monitor;

/**
 *
 * @author laris
 */
public class TableModelMonitor_Disciplina extends AbstractTableModel {

    private HorarioAgendaAluno horarioagendaaluno;
    private List<HorarioAgendaAluno> listaHorarioAgendaAluno;
    private List<Monitor> monitores;
    private List<HorarioReservado> horarios;
    private HorarioReservado horario;
    private ControleMonitor controleMonitor = new ControleMonitor();
    private ControleHorarioReservado horariosReservados = new ControleHorarioReservado();

    public TableModelMonitor_Disciplina(List<HorarioReservado> h) {
        this.horarios = h;
        // this.monitores = monitores;
    }

    @Override
    public int getRowCount() {
        return this.horarios.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        //if (!this.monitores.isEmpty()) {
        //List<HorarioReservado> listarHorarioMonitor = this.horariosReservados.listarHorarioMonitor(this.monitores.get(linha).getId(), 'F');
        HorarioReservado h = this.horarios.get(linha);
        //for (HorarioReservado h : this.horarios) {
        switch (coluna) {
            case 0:
                return h.getIdmon().getNome();
            case 1:
                return h.getIddisc().getDescricao();
            case 2:
                return h.getHorario();
            case 3:
                if (h.getDia_semana() == 1) {
                    return "Segunda-feira";
                }
                if (h.getDia_semana() == 2) {
                    return "Terça-feira";
                }
                if (h.getDia_semana() == 3) {
                    return "Quarta-feira";
                }
                if (h.getDia_semana() == 4) {
                    return "Quinta-feira";
                }
                if (h.getDia_semana() == 5) {
                    return "Sexta-feira";
                }
                return h.getDia_semana();
            case 4:
                String dataStr = h.getData().toString();
            return dataStr.substring(8,10) + '/' + dataStr.substring(5,7) + '/' + dataStr.substring(0,4);
            case 5:
                return h.getQtd_alunos();

        }

        return null;
    }
    //horario = listarHorarioMonitor.get(linha);

    // }
    @Override
    public String getColumnName(int coluna) {

        switch (coluna) {
            case 0:
                return "Monitor";
            case 1:
                return "Disciplina";
            case 2:
                return "Horário";
            case 3:
                return "Dia da semana";
            case 4:
                return "Data";
            case 5:
                return "Quantidade de alunos inscritos";
        }
        return null;
    }

}
