
package telas;

import controle.ControleAluno;
import controle.ControleDisciplina;
import controle.ControleHoraLivre;
import controle.ControleHorarioReservado;
import controle.ControleMonitor;
import controle.ControleSala;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.HoraLivre;
import modelo.HorarioReservado;
import modelo.Sala;
import tableModel.TableModelDiaSemana_HoraLivre;
import tableModel.TableModelDiaSemana_HorarioAgendaMonitor;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ConsultaAgendamentoMonitor extends javax.swing.JFrame {

    private final ControleDisciplina controleDisciplina = new ControleDisciplina();
    private final ControleSala controleSala = new ControleSala();
    private final ControleAluno controleAluno = new ControleAluno();
    private final ControleHoraLivre controleHoraLivre = new ControleHoraLivre();
    private final ControleHorarioReservado controleHorarioReservado = new ControleHorarioReservado();
    private final ControleMonitor controleMonitor;
    
    LocalDate dataAtual = LocalDate.now();
    private Integer diaSemana;
    private String dataselecionada;
    private Integer idSala;
    private Integer linhaSelecionada = 0;
    
    // Construtor da classe ConsultaAgendamentoMonitor
    public ConsultaAgendamentoMonitor(ControleMonitor controleMonitor) throws ParseException, SQLException {
       
        initComponents();
        this.controleMonitor = controleMonitor;
        lblUsuario.setText(controleMonitor.getMonitor().getNome());
        carregarSalas();
        carregarMenuPopup();
        formatarTela();
        configurarDatas();
        
        try {
            idSala = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

        carregarDados(idSala);
        validarHoras();
    }
    
    // Método para formatar as datas mostradas no formulário
    private String formatarData(String pData){
        String data = pData.substring(8,10) + '/' + pData.substring(5,7) + '/' + pData.substring(0,4); 
        return data; 
    }
    
    // Método para configurar as datas que serão mostradas no formulário
    private void configurarDatas(){
        String diaSemanaStr = dataAtual.getDayOfWeek().name();
        
        // Sábado
        if (diaSemanaStr.equals("SATURDAY")){
            txtDataSeg.setText(formatarData(dataAtual.plusDays(2).toString()));
            txtDataTer.setText(formatarData(dataAtual.plusDays(3).toString()));
            txtDataQua.setText(formatarData(dataAtual.plusDays(4).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(5).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(6).toString()));           
        } 
        // DOMINGO
        else if (diaSemanaStr.equals("SUNDAY")){
            txtDataSeg.setText(formatarData(dataAtual.plusDays(1).toString()));
            txtDataTer.setText(formatarData(dataAtual.plusDays(2).toString()));
            txtDataQua.setText(formatarData(dataAtual.plusDays(3).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(4).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(5).toString()));    
        }
    }
           
    // Método para formatar os elementos visuais da tela
    private void formatarTela(){
        txtDataSeg.setHorizontalAlignment(JTextField.CENTER);
        txtDataTer.setHorizontalAlignment(JTextField.CENTER);
        txtDataQua.setHorizontalAlignment(JTextField.CENTER);
        txtDataQui.setHorizontalAlignment(JTextField.CENTER);
        txtDataSex.setHorizontalAlignment(JTextField.CENTER);
       
        ((DefaultTableCellRenderer)tabelaSegundaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer)tabelaTercaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer)tabelaQuartaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer)tabelaQuintaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer)tabelaSextaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

    }
    
    // Método para selecionar o horário ao clicar no na tabela de cada dia da semana
    private void selecionarHorario(Integer pDia) {
        try {
            controleHoraLivre.setHorarioLivre(controleHoraLivre.listar(pDia, idSala).get(linhaSelecionada));
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para carregar os itens do menu pop up das tabelas
    private void carregarMenuPopup() {
        JMenuItem itemReservar = new JMenuItem("Reservar horário");
        itemReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer qtdRegistros = tabelaHorariosMonitor.getModel().getRowCount();

                if(qtdRegistros == 12){
                    JOptionPane.showMessageDialog(null, "Quantidade máxima de horas de monitoria já reservada.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    try {
                        HoraLivre horaLivre = controleHoraLivre.getHorarioLivre();
                        int id = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
                        String dataFormatada = dataselecionada.substring(6,10) + '-' + dataselecionada.substring(3,5) + '-' + dataselecionada.substring(0,2);
                           
                        if (controleHorarioReservado.salvar(horaLivre,dataFormatada, controleMonitor.getMonitor().getDisciplina(), controleMonitor.getMonitor(), id)){
                            JOptionPane.showMessageDialog(null, "Monitoria reservada com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);    
                            carregarDados(idSala);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Reserva cancelada. Monitoria já reservada para o mesmo horário e dia da semana.", "Scheduler", JOptionPane.INFORMATION_MESSAGE); 
                        }

                    } catch (Exception t) {
                        JOptionPane.showMessageDialog(null, "Nenhum registro selecionado.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
            }
        });

        menuTabela.add(itemReservar);
    }

    // Método para carregar os horários livres por dia da semana
    private void carregarDados(Integer pID_Sala) throws ParseException, SQLException {
        TableModelDiaSemana_HoraLivre modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(1, pID_Sala), 1);
        tabelaSegundaFeira.setModel(modelo);
        tabelaSegundaFeira.setComponentPopupMenu(menuTabela);
     
        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(2, pID_Sala), 2);
        tabelaTercaFeira.setModel(modelo);
        tabelaTercaFeira.setComponentPopupMenu(menuTabela);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(3, pID_Sala), 3);
        tabelaQuartaFeira.setModel(modelo);
        tabelaQuartaFeira.setComponentPopupMenu(menuTabela);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(4, pID_Sala), 4);
        tabelaQuintaFeira.setModel(modelo);
        tabelaQuintaFeira.setComponentPopupMenu(menuTabela);

        modelo = new TableModelDiaSemana_HoraLivre(controleHoraLivre.listar(5, pID_Sala), 5);
        tabelaSextaFeira.setModel(modelo);
        tabelaSextaFeira.setComponentPopupMenu(menuTabela);

        TableModelDiaSemana_HorarioAgendaMonitor modeloMonitor = new TableModelDiaSemana_HorarioAgendaMonitor(controleHorarioReservado.listarHorarioMonitor(controleMonitor.getMonitor().getId(),'P'));
        tabelaHorariosMonitor.setModel(modeloMonitor);
        
        lblQtdHoras.setText("Quantidade selecionada : " + tabelaHorariosMonitor.getModel().getRowCount());
        
        validarHoras();
    }

    //
    // Método para carregar o combobox de salas/laboratórios
    private void carregarSalas() throws ParseException, SQLException {
        try {
            comboSalas.removeAllItems();
            for (Sala obj : controleSala.listar("")) {
                comboSalas.addItem(obj.getDescricao());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabela = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        lblLoad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHorariosMonitor = new javax.swing.JTable();
        lblQtdHoras = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboSalas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSegundaFeira = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTercaFeira = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaQuartaFeira = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaQuintaFeira = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaSextaFeira = new javax.swing.JTable();
        txtDataSeg = new javax.swing.JTextField();
        txtDataTer = new javax.swing.JTextField();
        txtDataQua = new javax.swing.JTextField();
        txtDataQui = new javax.swing.JTextField();
        txtDataSex = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Scheduler - Agendamento de Monitorias");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setFocusable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/scheduler_pds_mini.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Scheduler");

        lblUsuario.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(153, 0, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addContainerGap()
                        .addComponent(lblUsuario))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)))
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

        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.setToolTipText("Confirmar Agendamento");
        btConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setToolTipText("Pesquisar horários disponíveis");
        btPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        lblLoad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(lblLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPesquisar)
                            .addComponent(lblLoad)
                            .addComponent(btSair))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Horários Selecionados");

        tabelaHorariosMonitor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabelaHorariosMonitor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaHorariosMonitor);

        lblQtdHoras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQtdHoras.setForeground(new java.awt.Color(0, 0, 102));
        lblQtdHoras.setText("Quantidade selecionada: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblQtdHoras)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblQtdHoras)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Laboratório/Sala:");

        comboSalas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSalas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboSalasFocusLost(evt);
            }
        });

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
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Terça-Feira"
            }
        ));
        tabelaTercaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaTercaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTercaFeiraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaTercaFeira);

        tabelaQuartaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaQuartaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Quarta-Feira"
            }
        ));
        tabelaQuartaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaQuartaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaQuartaFeiraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaQuartaFeira);

        tabelaQuintaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaQuintaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Quinta-Feira"
            }
        ));
        tabelaQuintaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaQuintaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaQuintaFeiraMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaQuintaFeira);

        tabelaSextaFeira.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabelaSextaFeira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Sexta-Feira"
            }
        ));
        tabelaSextaFeira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaSextaFeira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSextaFeiraMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaSextaFeira);

        txtDataSeg.setEditable(false);
        txtDataSeg.setBackground(new java.awt.Color(204, 204, 255));
        txtDataSeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataSeg.setText("15/10/2018");
        txtDataSeg.setToolTipText("");
        txtDataSeg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDataTer.setEditable(false);
        txtDataTer.setBackground(new java.awt.Color(204, 204, 255));
        txtDataTer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataTer.setText("16/10/2018");
        txtDataTer.setToolTipText("");
        txtDataTer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDataQua.setEditable(false);
        txtDataQua.setBackground(new java.awt.Color(204, 204, 255));
        txtDataQua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataQua.setText("17/10/2018");
        txtDataQua.setToolTipText("");
        txtDataQua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDataQui.setEditable(false);
        txtDataQui.setBackground(new java.awt.Color(204, 204, 255));
        txtDataQui.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataQui.setText("18/10/2018");
        txtDataQui.setToolTipText("");
        txtDataQui.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDataSex.setEditable(false);
        txtDataSex.setBackground(new java.awt.Color(204, 204, 255));
        txtDataSex.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataSex.setText("19/10/2018");
        txtDataSex.setToolTipText("");
        txtDataSex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(comboSalas, 0, 185, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDataSeg, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataTer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataQua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataQui))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataSex, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataTer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataQua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataQui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Evento click do botão sair
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        ConsultaAgendamentoMonitor.this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    // Evento click do botão pesquisar
    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            carregarDados(idSala);
            
            if (tabelaSegundaFeira.getModel().getRowCount() == 0 && tabelaTercaFeira.getModel().getRowCount() == 0 && tabelaQuartaFeira.getModel().getRowCount() == 0 && tabelaQuintaFeira.getModel().getRowCount() == 0 && tabelaSextaFeira.getModel().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum horário livre encontrado.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    // Método para confirmar o agendamento das monitorias selecionadas pelo monitor
    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Confirmar agendamento ?", "Scheduler", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                List<HorarioReservado> lista = controleHorarioReservado.listarHorarioMonitor(1,'P');

                for(HorarioReservado h  : lista){
                   controleHorarioReservado.atualizarStatus(1);
                }
                JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
                ConsultaAgendamentoMonitor.this.dispose();
            } catch (HeadlessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    // Método para selecionar o horário livre na tabela terça-feira
    private void tabelaTercaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTercaFeiraMouseClicked
        linhaSelecionada = tabelaTercaFeira.getSelectedRow();
        dataselecionada = txtDataTer.getText();
        selecionarHorario(2);
        this.diaSemana = 2;
    }//GEN-LAST:event_tabelaTercaFeiraMouseClicked

    // Método para validar se o monitor possui entre 6 e 12 horários de monitoria selecionados
    private void validarHoras(){
        Integer qtdRegistros = tabelaHorariosMonitor.getModel().getRowCount();
        
        if(qtdRegistros >= 6 && qtdRegistros <= 12){
            this.btConfirmar.setEnabled(true);
        } else{
            this.btConfirmar.setEnabled(false);
        }
    }
    // Método FocusLost do combobox de salas
    private void comboSalasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSalasFocusLost
        try {
            idSala = controleSala.listar("").get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboSalasFocusLost

    // Método para selecionar o horário livre na tabela quarta-feira
    private void tabelaQuartaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuartaFeiraMouseClicked
        linhaSelecionada = tabelaQuartaFeira.getSelectedRow();
        dataselecionada = txtDataQua.getText();
        selecionarHorario(3);
        this.diaSemana = 3;
    }//GEN-LAST:event_tabelaQuartaFeiraMouseClicked

    // Método para selecionar o horário livre na tabela quinta-feira
    private void tabelaQuintaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuintaFeiraMouseClicked
        linhaSelecionada = tabelaQuintaFeira.getSelectedRow();
        dataselecionada = txtDataQui.getText();
        selecionarHorario(4);
        this.diaSemana = 4;
    }//GEN-LAST:event_tabelaQuintaFeiraMouseClicked

    // Método para selecionar o horário livre na tabela sexta-feira
    private void tabelaSextaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSextaFeiraMouseClicked
        linhaSelecionada = tabelaSextaFeira.getSelectedRow();
        dataselecionada = txtDataSex.getText();
        selecionarHorario(5);
        this.diaSemana = 5;
    }//GEN-LAST:event_tabelaSextaFeiraMouseClicked

    // Método para selecionar o horário livre na tabela segunda-feira
    private void tabelaSegundaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSegundaFeiraMouseClicked
        linhaSelecionada = tabelaSegundaFeira.getSelectedRow();
        dataselecionada = txtDataSeg.getText();
        selecionarHorario(1);
        this.diaSemana = 1;
    }//GEN-LAST:event_tabelaSegundaFeiraMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> comboSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblQtdHoras;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPopupMenu menuTabela;
    private javax.swing.JTable tabelaHorariosMonitor;
    private javax.swing.JTable tabelaQuartaFeira;
    private javax.swing.JTable tabelaQuintaFeira;
    private javax.swing.JTable tabelaSegundaFeira;
    private javax.swing.JTable tabelaSextaFeira;
    private javax.swing.JTable tabelaTercaFeira;
    private javax.swing.JTextField txtDataQua;
    private javax.swing.JTextField txtDataQui;
    private javax.swing.JTextField txtDataSeg;
    private javax.swing.JTextField txtDataSex;
    private javax.swing.JTextField txtDataTer;
    // End of variables declaration//GEN-END:variables
}
