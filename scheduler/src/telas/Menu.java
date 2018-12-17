
package telas;

import controle.ControleAluno;
import controle.ControleHorarioReservado;
import controle.ControleLogin;
import controle.ControleMonitor;
import controle.ControlePeriodo;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public final class Menu extends javax.swing.JFrame {
    
    LocalDate dataAtual = LocalDate.now();
    private ControleLogin controleLogin;
    private ControlePeriodo controlePeriodo;
    private final ControleMonitor controleMonitor = new ControleMonitor();
    private final ControleAluno controleAluno = new ControleAluno();
    private final ControleHorarioReservado controleHorarioReservado = new ControleHorarioReservado();
    
    public Menu(login l, ControleLogin controleLogin,ControlePeriodo controlePeriodo) {
        l.dispose();
        initComponents();
        this.controleLogin = controleLogin;
        this.controlePeriodo = controlePeriodo;
        lblUsuario.setText(controleLogin.getLogin().getNome());
        verificarPermissoes();
    }

    public void verificarPermissoes()
    {
        if (controleLogin.getLogin().getPerfil() == 'C') {
            btMatriculas.setEnabled(false);
            btMonitoria.setEnabled(false);
        }
        else
        {
            btRelatorios.setEnabled(false);
            btDisciplinas.setEnabled(false);
            btSalas.setEnabled(false);
            btHorasLivres.setEnabled(false);
            btAlunos.setEnabled(false);
            btMonitor.setEnabled(false);
            if (controleLogin.getLogin().getPerfil() == 'A'){
                btMonitoria.setEnabled(false);
            }
            btRelatorios.setEnabled(false);
            btPeriodo.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btMatriculas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btDisciplinas = new javax.swing.JButton();
        btMonitoria = new javax.swing.JButton();
        btSalas = new javax.swing.JButton();
        btHorasLivres = new javax.swing.JButton();
        btAlunos = new javax.swing.JButton();
        btMonitor = new javax.swing.JButton();
        btRelatorios = new javax.swing.JButton();
        btPeriodo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Scheduler");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btMatriculas.setBackground(new java.awt.Color(255, 255, 255));
        btMatriculas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btMatriculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/matricula_64x64.png"))); // NOI18N
        btMatriculas.setText("         Matrículas");
        btMatriculas.setToolTipText("Matrículas de Monitoria");
        btMatriculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMatriculasActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair 64x64 2.png"))); // NOI18N
        jButton2.setText("          Fechar       ");
        jButton2.setToolTipText("Sair do Sistema");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btDisciplinas.setBackground(new java.awt.Color(255, 255, 255));
        btDisciplinas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btDisciplinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disciplinas 64x64.png"))); // NOI18N
        btDisciplinas.setText("         Disciplinas");
        btDisciplinas.setToolTipText("Cadastro de Disciplinas");
        btDisciplinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDisciplinasActionPerformed(evt);
            }
        });

        btMonitoria.setBackground(new java.awt.Color(255, 255, 255));
        btMonitoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btMonitoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/agendar 64x64.png"))); // NOI18N
        btMonitoria.setText("         Monitorias");
        btMonitoria.setToolTipText("Agendamento de Monitorias");
        btMonitoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMonitoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoriaActionPerformed(evt);
            }
        });

        btSalas.setBackground(new java.awt.Color(255, 255, 255));
        btSalas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salas 64x64.png"))); // NOI18N
        btSalas.setText("          Lab./Salas");
        btSalas.setToolTipText("Cadastro de Laboratórios/Salas");
        btSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalasActionPerformed(evt);
            }
        });

        btHorasLivres.setBackground(new java.awt.Color(255, 255, 255));
        btHorasLivres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btHorasLivres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/horalivre_64x.png"))); // NOI18N
        btHorasLivres.setText("       Horas Livres");
        btHorasLivres.setToolTipText("Horários Livres");
        btHorasLivres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHorasLivres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHorasLivresActionPerformed(evt);
            }
        });

        btAlunos.setBackground(new java.awt.Color(255, 255, 255));
        btAlunos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btAlunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/estudante 64x64.png"))); // NOI18N
        btAlunos.setText("       Alunos");
        btAlunos.setToolTipText("Cadastrar Alunos");
        btAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlunosActionPerformed(evt);
            }
        });

        btMonitor.setBackground(new java.awt.Color(255, 255, 255));
        btMonitor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/monitor 64x64.png"))); // NOI18N
        btMonitor.setText("  Monitores");
        btMonitor.setToolTipText("Cadastro de Monitores");
        btMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitorActionPerformed(evt);
            }
        });

        btRelatorios.setBackground(new java.awt.Color(255, 255, 255));
        btRelatorios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatórios.png"))); // NOI18N
        btRelatorios.setText("  Relatórios");
        btRelatorios.setToolTipText("Relatórios");
        btRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatoriosActionPerformed(evt);
            }
        });

        btPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        btPeriodo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/periodo 64x64.png"))); // NOI18N
        btPeriodo.setText("  Período    ");
        btPeriodo.setToolTipText("Cadastro de Períodos");
        btPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btDisciplinas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(btMatriculas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btMonitoria, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btHorasLivres, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addGap(267, 267, 267))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMonitoria, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(btMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btHorasLivres, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo pelo litrão.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(153, 96, 209));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Método para chamar a tela de matrícula em monitoria (Aluno)
    private void btMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMatriculasActionPerformed
    
        if ((dataAtual.getDayOfWeek().name() != "SATURDAY") && (dataAtual.getDayOfWeek().name() != "SUNDAY")){
            try {
                this.controleAluno.setAluno(controleAluno.procurarPorMatricula(controleLogin.getLogin().getUsuario()));
                new ConsultaAgendamentoAluno(controleAluno).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Fora do período para matrículas em monitorias.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btMatriculasActionPerformed

    // Método para fechar a aplicação   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int resp = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema ?", "Scheduler", JOptionPane.YES_NO_OPTION);
        
        if(resp == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btMonitoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoriaActionPerformed
        this.controleMonitor.setMonitor(controleMonitor.procurarPorMatricula(controleLogin.getLogin().getUsuario()));
        
        if (controleHorarioReservado.listarHorarioMonitor(this.controleMonitor.getMonitor().getId(),'F').isEmpty()){
            if ((dataAtual.getDayOfWeek().name() == "SATURDAY") || (dataAtual.getDayOfWeek().name() == "SUNDAY")){
                try {
                    new ConsultaAgendamentoMonitor(controleMonitor).setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            else{
                JOptionPane.showMessageDialog(null, "Fora do período para agendamento de monitorias.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            try {
                new ConsultaHorarioMonitor(controleMonitor, this.controleLogin).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btMonitoriaActionPerformed

    private void btSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalasActionPerformed
        try {
            new ConsultaSalas(this.controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalasActionPerformed

    private void btDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisciplinasActionPerformed
        try {
            new ConsultaDisciplina(controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btDisciplinasActionPerformed

    private void btHorasLivresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHorasLivresActionPerformed
        try {
            new CadastrarHoraLivre_new(controleLogin,controlePeriodo).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btHorasLivresActionPerformed

    private void btAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlunosActionPerformed
        try {
            new ConsultaAluno(this.controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAlunosActionPerformed

    private void btMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitorActionPerformed
        try {
            new ConsultaMonitor(this.controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btMonitorActionPerformed

    private void btRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatoriosActionPerformed
        try {
            // TODO add your handling code here:
            new ConsultaRelatorioMonitorias(this.controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRelatoriosActionPerformed

    private void btPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPeriodoActionPerformed
        try {
            new ConsultaPeriodo(this.controleLogin).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPeriodoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlunos;
    private javax.swing.JButton btDisciplinas;
    private javax.swing.JButton btHorasLivres;
    private javax.swing.JButton btMatriculas;
    private javax.swing.JButton btMonitor;
    private javax.swing.JButton btMonitoria;
    private javax.swing.JButton btPeriodo;
    private javax.swing.JButton btRelatorios;
    private javax.swing.JButton btSalas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
