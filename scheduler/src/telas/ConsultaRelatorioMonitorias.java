package telas;

import controle.ControleAluno;
import controle.ControleConsultas;
import controle.ControleDisciplina;
import controle.ControleHorarioAgendaAluno;
import controle.ControleHorarioReservado;
import controle.ControleLogin;
import controle.ControleMonitor;
import controle.ControlePeriodo;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Consulta1;
import modelo.Consulta2;
import modelo.HorarioAgendaAluno;
import modelo.HorarioReservado;
import modelo.Periodo;
import tableModel.TableModelMonitor_Disciplina;
import tableModel.TableModel_DisciplinasMaisProcuradas;
import tableModel.TableModel_MaiorQtdeAlunos;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ConsultaRelatorioMonitorias extends javax.swing.JFrame {

    private final ControleDisciplina controleDisciplina = new ControleDisciplina();
    private int linhaSelecionada;
    private final ControleMonitor cm = new ControleMonitor();
    private final ControleHorarioReservado controleHorarioReservado = new ControleHorarioReservado();
    private final ControleAluno controleAluno = new ControleAluno();
    private final ControleHorarioAgendaAluno controleHorarioAgendaAluno = new ControleHorarioAgendaAluno();
    private final ControlePeriodo controlePeriodo = new ControlePeriodo();
    private final ControleConsultas consultas = new ControleConsultas();
    private final ControleLogin login;

    public ConsultaRelatorioMonitorias(ControleLogin login) throws ParseException, SQLException {
        initComponents();
        this.login = login;
        carregarDados();
        carregarPeriodos();
        carregarOpcoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        dataDe = new cambodia.raven.DateChooser();
        dateChooser1 = new cambodia.raven.DateChooser();
        dateChooser2 = new cambodia.raven.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorio = new javax.swing.JTable();
        comboTipoRelatório = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboPeriodos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Scheduler - Relatórios");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setFocusable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/scheduler_pds_mini.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Scheduler");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btSair.setBackground(new java.awt.Color(255, 255, 255));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar.png"))); // NOI18N
        btSair.setText("    Sair");
        btSair.setToolTipText("Sair");
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Relatórios");

        tabelaRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRelatorio);

        comboTipoRelatório.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoRelatórioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Período");

        comboPeriodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboTipoRelatório, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)
                        .addComponent(comboTipoRelatório, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void carregarDados() throws ParseException, SQLException {
        if (this.comboTipoRelatório.getSelectedIndex() == 0) {
            TableModelMonitor_Disciplina modelo = new TableModelMonitor_Disciplina(this.controleHorarioReservado.listarTudo(controlePeriodo.listar().get(comboPeriodos.getSelectedIndex()).getId()));
            tabelaRelatorio.setModel(modelo);
        } else {
            if (this.comboTipoRelatório.getSelectedIndex() == 1) {
                List<Consulta1> c = this.consultas.listar(controlePeriodo.listar().get(comboPeriodos.getSelectedIndex()).getId());
                TableModel_DisciplinasMaisProcuradas modelo = new TableModel_DisciplinasMaisProcuradas(c);
                tabelaRelatorio.setModel(modelo);
            } else{
                if(this.comboTipoRelatório.getSelectedIndex() == 2){
                    List<Consulta2> c = this.consultas.listar2(controlePeriodo.listar().get(comboPeriodos.getSelectedIndex()).getId());
                    TableModel_MaiorQtdeAlunos modelo = new TableModel_MaiorQtdeAlunos(c);
                    tabelaRelatorio.setModel(modelo);
                }
            }
        }
    }

    private void selecionarLinha() {
        try {
controleHorarioReservado.setHorarioReservado(controleHorarioReservado.listarTudo(controlePeriodo.listar().get(comboPeriodos.getSelectedIndex()).getId()).get(linhaSelecionada));        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            carregarDados();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tabelaRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatorioMouseClicked
       if (this.comboTipoRelatório.getSelectedIndex() == 0) {
            this.linhaSelecionada = tabelaRelatorio.getSelectedRow();
            selecionarLinha();
            HorarioReservado h = controleHorarioReservado.getHorarioReservado();
            System.out.println(h.getId());
            if (h.getQtd_alunos() != 0) {
                List<HorarioAgendaAluno> lista = null;
                try {
                    lista = this.controleHorarioAgendaAluno.listarAlunosMatriculados(h.getId());
                } catch (ParseException | SQLException ex) {
                    Logger.getLogger(ConsultaRelatorioMonitorias.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new ConsultaAlunosMatriculados(this.login, controleHorarioReservado).setVisible(true);
                } catch (ParseException | SQLException ex) {
                    Logger.getLogger(ConsultaRelatorioMonitorias.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Não há nada a ser mostrado!");
            }
        }
        if (this.comboTipoRelatório.getSelectedIndex() == 1) {

        }

    }//GEN-LAST:event_tabelaRelatorioMouseClicked

    private void carregarOpcoes() {
        comboTipoRelatório.addItem("Todas as monitorias");
        comboTipoRelatório.addItem("Disciplinas mais procuradas"); //done 
        comboTipoRelatório.addItem("Maior quantidade de alunos"); 

    }

    private void carregarPeriodos() {
        comboPeriodos.removeAllItems();
        try {
            for (Periodo p : controlePeriodo.listar()) {
                comboPeriodos.addItem(p.getPeriodo());
            }
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaRelatorioMonitorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            carregarDados();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void comboTipoRelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoRelatórioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoRelatórioActionPerformed

//    private void carregarDados() throws ParseException, SQLException{
//        TableModelDisciplina modelo = new TableModelDisciplina(controleDisciplina.listar(edFiltro.getText()));
//        tabelaDisciplinas.setModel(modelo);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> comboPeriodos;
    private javax.swing.JComboBox<String> comboTipoRelatório;
    private cambodia.raven.DateChooser dataDe;
    private cambodia.raven.DateChooser dateChooser1;
    private cambodia.raven.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRelatorio;
    // End of variables declaration//GEN-END:variables
}
