
package telas;

import controle.ControleDisciplina;
import controle.ControleHoraLivre;
import controle.ControleLogin;
import controle.ControlePeriodo;
import controle.ControleSala;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.HoraLivre;
import modelo.Sala;
import tableModel.TableModelDiaSemana_HoraLivre;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class CadastrarHoraLivre_new extends javax.swing.JFrame {

    private ControleLogin controleLogin;
    private ControlePeriodo controlePeriodo;
    private final ControleDisciplina controleDisciplina = new ControleDisciplina();
    private final ControleSala controleSala = new ControleSala();
    private final ControleHoraLivre controleHoraLivre = new ControleHoraLivre();
    List<JCheckBox> horarios = new ArrayList<>();

    private Integer idSala;
    
    public CadastrarHoraLivre_new(ControleLogin controleLogin,ControlePeriodo controlePeriodo) throws ParseException, SQLException {
        initComponents();
        this.controleLogin = controleLogin;
        this.controlePeriodo = controlePeriodo;
        lblUsuario1.setText("Usuário logado: " + controleLogin.getLogin().getNome());
        formatarTela();
        carregarComboSalas();
        carregarDias();
        initLista();
        
        try {
            idSala = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarDados(idSala);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboSalas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        checkHora = new javax.swing.JCheckBox();
        txtMat = new javax.swing.JTextField();
        txtVes = new javax.swing.JTextField();
        txtNot = new javax.swing.JTextField();
        checkHora1 = new javax.swing.JCheckBox();
        checkHora2 = new javax.swing.JCheckBox();
        checkHora3 = new javax.swing.JCheckBox();
        checkHora4 = new javax.swing.JCheckBox();
        checkHora5 = new javax.swing.JCheckBox();
        checkHora6 = new javax.swing.JCheckBox();
        checkHora7 = new javax.swing.JCheckBox();
        checkHora8 = new javax.swing.JCheckBox();
        checkHora9 = new javax.swing.JCheckBox();
        checkHora10 = new javax.swing.JCheckBox();
        checkHora11 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        comboDiaDaSemana = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSegundaFeira = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTercaFeira = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaQuintaFeira = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaSextaFeira = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaQuartaFeira = new javax.swing.JTable();
        txtHoras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sheduler - Controle de Horas Livres");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setFocusable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/scheduler_pds_mini.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Scheduler");

        lblUsuario1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(153, 96, 209));
        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario1.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsuario1)))
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
                .addGap(9, 9, 9)
                .addComponent(btPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btPesquisar))
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboSalas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSalas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboSalasFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Laboratório/Sala:");

        checkHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora.setText("08:00 - 09:00");

        txtMat.setEditable(false);
        txtMat.setBackground(new java.awt.Color(204, 204, 255));
        txtMat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMat.setText("Horário Matutino");
        txtMat.setToolTipText("");
        txtMat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatActionPerformed(evt);
            }
        });

        txtVes.setEditable(false);
        txtVes.setBackground(new java.awt.Color(204, 204, 255));
        txtVes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtVes.setText("Horário Vespertino");
        txtVes.setToolTipText("");
        txtVes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtVes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVesActionPerformed(evt);
            }
        });

        txtNot.setEditable(false);
        txtNot.setBackground(new java.awt.Color(204, 204, 255));
        txtNot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNot.setText("Horário Noturno");
        txtNot.setToolTipText("");
        txtNot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotActionPerformed(evt);
            }
        });

        checkHora1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora1.setText("09:00 - 10:00");
        checkHora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHora1ActionPerformed(evt);
            }
        });

        checkHora2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora2.setText("10:00 - 11:00");

        checkHora3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora3.setText("11:00 - 12:00");

        checkHora4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora4.setText("14:00 - 15:00");
        checkHora4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHora4ActionPerformed(evt);
            }
        });

        checkHora5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora5.setText("13:00 - 14:00");

        checkHora6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora6.setText("15:00 - 16:00");

        checkHora7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora7.setText("17:00 - 18:00");

        checkHora8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora8.setText("19:00 - 20:00");
        checkHora8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHora8ActionPerformed(evt);
            }
        });

        checkHora9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora9.setText("18:00 - 19:00");
        checkHora9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHora9ActionPerformed(evt);
            }
        });

        checkHora10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora10.setText("20:00 - 21:00");

        checkHora11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkHora11.setText("21:00 - 22:00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Dia da semana:");

        comboDiaDaSemana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboDiaDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDiaDaSemana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboDiaDaSemana.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboDiaDaSemanaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(checkHora, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(checkHora5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkHora3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkHora4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkHora6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkHora7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkHora8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkHora9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkHora10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkHora11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNot, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkHora)
                    .addComponent(checkHora5)
                    .addComponent(checkHora9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkHora1)
                    .addComponent(checkHora4)
                    .addComponent(checkHora8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkHora2)
                    .addComponent(checkHora6)
                    .addComponent(checkHora10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkHora3)
                    .addComponent(checkHora7)
                    .addComponent(checkHora11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tabelaSegundaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaSegundaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Segunda-Feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaSegundaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaSegundaFeira.setUpdateSelectionOnSort(false);
        tabelaSegundaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSegundaFeiraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaSegundaFeira);

        tabelaTercaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaTercaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Terça-Feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTercaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaTercaFeira.setUpdateSelectionOnSort(false);
        tabelaTercaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTercaFeiraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaTercaFeira);

        tabelaQuintaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaQuintaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quinta-Feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaQuintaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaQuintaFeira.setUpdateSelectionOnSort(false);
        tabelaQuintaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaQuintaFeiraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaQuintaFeira);

        tabelaSextaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaSextaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sexta-Feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaSextaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaSextaFeira.setUpdateSelectionOnSort(false);
        tabelaSextaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSextaFeiraMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaSextaFeira);

        tabelaQuartaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaQuartaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quarta-Feira"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaQuartaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaQuartaFeira.setUpdateSelectionOnSort(false);
        tabelaQuartaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaQuartaFeiraMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaQuartaFeira);

        txtHoras.setEditable(false);
        txtHoras.setBackground(new java.awt.Color(204, 204, 255));
        txtHoras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHoras.setText("Horários Cadastrados");
        txtHoras.setToolTipText("");
        txtHoras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoras)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //método para carregar combo de salas
    private void carregarComboSalas() {
        comboSalas.removeAllItems();
        try {
            for (Sala s : controleSala.listar("")) {
                comboSalas.addItem(s.getDescricao());
            }
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastrarHoraLivre_new.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para carregar combo de dias da semana
    private void carregarDias() {
        comboDiaDaSemana.removeAllItems();
        comboDiaDaSemana.addItem("Segunda-Feira");
        comboDiaDaSemana.addItem("Terça-Feira");
        comboDiaDaSemana.addItem("Quarta-Feira");
        comboDiaDaSemana.addItem("Quinta-Feira");
        comboDiaDaSemana.addItem("Sexta-Feira");
    }

    //método para retonar disciplina selecionada 
    private Integer getDisciplina() {
        Integer idDisc = null;
        try {
            idDisc = controleDisciplina.listar("").get(comboSalas.getSelectedIndex()).getIddisc();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastrarHoraLivre_new.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idDisc;
    }

    //método para retornar sala selecionada
    private Integer getSala() {
        Integer idSala = null;
        try {
            idSala = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadastrarHoraLivre_new.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idSala;
    }
    
     // Método para carregar os horários livres por dia da semana
    private void carregarDados(Integer pID_Sala) throws ParseException, SQLException {
        TableModelDiaSemana_HoraLivre modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(1, pID_Sala), 1);
        tabelaSegundaFeira.setModel(modelo);
     
        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(2, pID_Sala), 2);
        tabelaTercaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(3, pID_Sala), 3);
        tabelaQuartaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(4, pID_Sala), 4);
        tabelaQuintaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(5, pID_Sala), 5);
        tabelaSextaFeira.setModel(modelo);
    }

    //método para retonar dia da semana
    private Integer getDiaDaSemana() {
        switch (comboDiaDaSemana.getSelectedIndex()) {
            case 0:
                return 1; //segunda-feira
            case 1:
                return 2; //terça-feira
            case 2:
                return 3; //quarta-feira
            case 3:
                return 4; //quinta-feira
            case 4:
                return 5; //sexta-feira

        }
        return null;
    }

    // Método para formatar os elementos visuais da tela
    private void formatarTela() {
        txtMat.setHorizontalAlignment(JTextField.CENTER);
        txtMat.setHorizontalAlignment(JTextField.CENTER);
        txtVes.setHorizontalAlignment(JTextField.CENTER);
        txtNot.setHorizontalAlignment(JTextField.CENTER);
        txtHoras.setHorizontalAlignment(JTextField.CENTER);

        ((DefaultTableCellRenderer) tabelaSegundaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaTercaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaQuartaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaQuintaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaSextaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    //método para salvar horariolivre
    private void salvar() throws ParseException, SQLException {
        char flag = 'N';
        
        for (String horario : getHorarios()) {
            flag = 'S';
            HoraLivre hl = new HoraLivre();
            hl.setDia_semana(getDiaDaSemana());
            hl.setSala(controleSala.pesquisarPorId(getSala()));
            hl.setHorario(horario);
            hl.setPeriodo(controlePeriodo.getPeriodo());
            System.out.println(controlePeriodo.getPeriodo().getId());
            if(!this.controleHoraLivre.salvar(hl)){
                JOptionPane.showMessageDialog(this, "Horário " + horario + " já cadastrado para a sala e dia da semana informado.", "Scheduler",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                flag = 'C';
            }
        }
        
        if (flag == 'N'){
            JOptionPane.showMessageDialog(this, "Nenhum horário selecionado.", "Scheduler",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (flag == 'S')
        {
            JOptionPane.showMessageDialog(this, "Nenhum horário cadastrado.", "Scheduler",JOptionPane.INFORMATION_MESSAGE);  
        } else if(flag == 'C')
        {
            JOptionPane.showMessageDialog(this, "Horários cadastrados com sucesso.", "Scheduler",JOptionPane.INFORMATION_MESSAGE);
        }

        carregarDados(idSala);
        limparSelecao();
    }
    
    private void limparSelecao(){
        checkHora.setSelected(false);
        checkHora1.setSelected(false);
        checkHora2.setSelected(false);
        checkHora3.setSelected(false);
        checkHora4.setSelected(false);
        checkHora5.setSelected(false);
        checkHora6.setSelected(false);
        checkHora7.setSelected(false);
        checkHora8.setSelected(false);
        checkHora9.setSelected(false);
        checkHora10.setSelected(false);
        checkHora11.setSelected(false);
    }
    
    
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        CadastrarHoraLivre_new.this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            salvar();
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarHoraLivre_new.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarHoraLivre_new.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvarActionPerformed
    private void initLista() {
        this.horarios.add(this.checkHora);
        this.horarios.add(this.checkHora1);
        this.horarios.add(this.checkHora2);
        this.horarios.add(this.checkHora3);
        this.horarios.add(this.checkHora4);
        this.horarios.add(this.checkHora5);
        this.horarios.add(this.checkHora6);
        this.horarios.add(this.checkHora7);
        this.horarios.add(this.checkHora8);
        this.horarios.add(this.checkHora9);
        this.horarios.add(this.checkHora10);
        this.horarios.add(this.checkHora11);
    }

    private List<String> getHorarios() {
        List<String> horarios = new ArrayList<>();
        if (this.horarios.get(0).isSelected()) {
            horarios.add(this.horarios.get(0).getText());
        }
        if (this.horarios.get(1).isSelected()) {
            horarios.add(this.horarios.get(1).getText());
        }
        if (this.horarios.get(2).isSelected()) {
            horarios.add(this.horarios.get(2).getText());
        }
        if (this.horarios.get(3).isSelected()) {
            horarios.add(this.horarios.get(3).getText());
        }
        if (this.horarios.get(4).isSelected()) {
            horarios.add(this.horarios.get(4).getText());
        }
        if (this.horarios.get(5).isSelected()) {
            horarios.add(this.horarios.get(5).getText());
        }
        if (this.horarios.get(6).isSelected()) {
            horarios.add(this.horarios.get(6).getText());
        }
        if (this.horarios.get(7).isSelected()) {
            horarios.add(this.horarios.get(7).getText());
        }
        if (this.horarios.get(8).isSelected()) {
            horarios.add(this.horarios.get(8).getText());
        }
        if (this.horarios.get(9).isSelected()) {
            horarios.add(this.horarios.get(9).getText());
        }
        if (this.horarios.get(10).isSelected()) {
            horarios.add(this.horarios.get(10).getText());
        }
        if (this.horarios.get(11).isSelected()) {
            horarios.add(this.horarios.get(11).getText());
        }
        return horarios;
    }
    private void comboSalasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSalasFocusLost
        try {
            idSala = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboSalasFocusLost

    private void txtMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatActionPerformed

    private void txtVesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVesActionPerformed

    private void txtNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotActionPerformed

    private void checkHora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkHora1ActionPerformed

    private void checkHora4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHora4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkHora4ActionPerformed

    private void checkHora8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHora8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkHora8ActionPerformed

    private void tabelaSegundaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSegundaFeiraMouseClicked

    }//GEN-LAST:event_tabelaSegundaFeiraMouseClicked

    private void tabelaTercaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTercaFeiraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaTercaFeiraMouseClicked

    private void tabelaQuintaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuintaFeiraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaQuintaFeiraMouseClicked

    private void tabelaSextaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSextaFeiraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaSextaFeiraMouseClicked

    private void tabelaQuartaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuartaFeiraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaQuartaFeiraMouseClicked

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasActionPerformed

    private void comboDiaDaSemanaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboDiaDaSemanaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDiaDaSemanaFocusLost

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            carregarDados(idSala);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void checkHora9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHora9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkHora9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox checkHora;
    private javax.swing.JCheckBox checkHora1;
    private javax.swing.JCheckBox checkHora10;
    private javax.swing.JCheckBox checkHora11;
    private javax.swing.JCheckBox checkHora2;
    private javax.swing.JCheckBox checkHora3;
    private javax.swing.JCheckBox checkHora4;
    private javax.swing.JCheckBox checkHora5;
    private javax.swing.JCheckBox checkHora6;
    private javax.swing.JCheckBox checkHora7;
    private javax.swing.JCheckBox checkHora8;
    private javax.swing.JCheckBox checkHora9;
    private javax.swing.JComboBox<String> comboDiaDaSemana;
    private javax.swing.JComboBox<String> comboSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JTable tabelaQuartaFeira;
    private javax.swing.JTable tabelaQuintaFeira;
    private javax.swing.JTable tabelaSegundaFeira;
    private javax.swing.JTable tabelaSextaFeira;
    private javax.swing.JTable tabelaTercaFeira;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtNot;
    private javax.swing.JTextField txtVes;
    // End of variables declaration//GEN-END:variables
}
