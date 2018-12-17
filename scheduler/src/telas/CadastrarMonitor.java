
package telas;

import controle.ControleAluno;
import controle.ControleDisciplina;
import controle.ControleMonitor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Monitor;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class CadastrarMonitor extends javax.swing.JFrame {

    private ControleMonitor controleMonitor;
    private ControleDisciplina controleDisciplina = new ControleDisciplina();
    private ControleAluno controleAluno = new ControleAluno();
    private Monitor monitor;
    private char validar;
    private Integer idAluno;
    private Integer idDisciplina;

    
    public CadastrarMonitor(ControleMonitor controleMonitor, char v) throws ParseException, SQLException {
        initComponents();
        this.controleMonitor = controleMonitor;
        carregarAlunos();
        carregarDisciplinas();
        this.validar = v;
           
        if (v == 'A') {
            this.monitor = this.controleMonitor.getMonitor();
            
            /*
            txtDescricao.setText(s.getDescricao());
            txtLocal.setText(s.getLocal());
            if (s.getStatus() == 'A') {
                comboStatus.setSelectedIndex(0);
            } else {
                comboStatus.setSelectedIndex(1);
            }
            */
        }
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void carregarAlunos() throws ParseException, SQLException
    {
        try
        {
            comboAlunos.removeAllItems();
            for(Aluno obj : controleAluno.listar(""))
            {
                comboAlunos.addItem(obj.getNome());
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }        
    }
    
    private void carregarDisciplinas() throws ParseException, SQLException
    {
        try
        {
            comboDisciplinas.removeAllItems();
            for(Disciplina obj : controleDisciplina.listar(""))
            {
                comboDisciplinas.addItem(obj.getDescricao());
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new cambodia.raven.DateChooser();
        escolherData = new cambodia.raven.DateChooser();
        dateChooser2 = new cambodia.raven.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboAlunos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboDisciplinas = new javax.swing.JComboBox<>();
        txtCaminho = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        escolherData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escolherDataMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scheduler - Cadastro de Monitores");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        btSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btSalvar.setText("   Salvar");
        btSalvar.setToolTipText("Salvar");
        btSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                .addGap(0, 588, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Aluno:");

        comboAlunos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboAlunos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboAlunos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboAlunosFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Disciplina:");

        comboDisciplinas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDisciplinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboDisciplinas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboDisciplinasFocusLost(evt);
            }
        });

        txtCaminho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Caminho Imagem:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(comboAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(comboDisciplinas, 0, 512, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(txtCaminho))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void escolherDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escolherDataMouseClicked
        System.out.println(escolherData.getSelectedDate());
    }//GEN-LAST:event_escolherDataMouseClicked

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        CadastrarMonitor.this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (this.validar == 'C') {
            try {
                salvarCadastro();
            } catch (ParseException ex) {
                
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarMonitor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Monitor já cadastrado. Inclusão cancelada.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (this.validar == 'A') {
              //  salvarAlteracao();
            }
        } 
    }//GEN-LAST:event_btSalvarActionPerformed

    private void comboAlunosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboAlunosFocusLost
       
    }//GEN-LAST:event_comboAlunosFocusLost

    private void comboDisciplinasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboDisciplinasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDisciplinasFocusLost

    private void salvarCadastro() throws ParseException, SQLException {
        controleAluno.setAluno(controleAluno.listar("").get(comboAlunos.getSelectedIndex()));
        controleDisciplina.setDisciplina(controleDisciplina.listar("").get(comboDisciplinas.getSelectedIndex()));
       
        Monitor m = new Monitor();
        m.setMatricula(controleAluno.getAluno().getMatricula());
        m.setNome(controleAluno.getAluno().getNome());
        m.setDisciplina(controleDisciplina.getDisciplina());
        m.setImagem(txtCaminho.getText());

        try {
            this.controleMonitor.salvar(m);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarSala.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Monitor cadastrado com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
        CadastrarMonitor.this.dispose();
    }

    /*
    private void salvarAlteracao() {
        s.setLocal(txtLocal.getText());
        s.setDescricao(txtDescricao.getText());
        if (comboStatus.getSelectedIndex() == 0) {
            s.setStatus('A');
        } else {
            s.setStatus('I');
        }

        int resp = JOptionPane.showConfirmDialog(null, "Deseja confirmar alteração ?", "Scheduler", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            this.controleSala.update(s);
            JOptionPane.showMessageDialog(null, "Sala/laboratório alterado com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        
    }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> comboAlunos;
    private javax.swing.JComboBox<String> comboDisciplinas;
    private cambodia.raven.DateChooser dateChooser1;
    private cambodia.raven.DateChooser dateChooser2;
    private cambodia.raven.DateChooser escolherData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtCaminho;
    // End of variables declaration//GEN-END:variables
}
