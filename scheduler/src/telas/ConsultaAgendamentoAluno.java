package telas;

import controle.ControleAluno;
import controle.ControleDisciplina;
import controle.ControleHorarioAgendaAluno;
import controle.ControleHorarioReservado;
import controle.ControleSala;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.Disciplina;
import modelo.HorarioAgendaAluno;
import modelo.Sala;
import tableModel.TableModelDiaSemana_HoraReservada;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ConsultaAgendamentoAluno extends javax.swing.JFrame {

    private final ControleHorarioReservado controleHorarioReservado = new ControleHorarioReservado();
    private final ControleDisciplina controleDisciplina = new ControleDisciplina();
    private final ControleHorarioAgendaAluno controleHorarioAgendaAluno = new ControleHorarioAgendaAluno();
    private final ControleSala controleSala = new ControleSala();
    private ControleAluno controleAluno;
    private String discAtual;
    private String discAnt;
    
    LocalDate dataAtual = LocalDate.now();
    private Integer idDisciplina;
    private Integer idSala;
    private Integer linhaSelecionada = 0;

    public ConsultaAgendamentoAluno(ControleAluno controleAluno) throws ParseException, SQLException {
        initComponents();
        this.controleAluno = controleAluno;
        lblUsuario.setText(controleAluno.getAluno().getNome());
        carregarDisciplinas();

        discAtual = comboDisciplinas.getSelectedItem().toString().trim();
        discAnt = comboDisciplinas.getSelectedItem().toString().trim();
        
        configurarDatas();

        limparDetalhesAula();
        formatarTela();

        try {
            idDisciplina = controleDisciplina.listar("").get(comboDisciplinas.getSelectedIndex()).getIddisc();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarSalas(idDisciplina); 
        idSala = controleSala.listarPorDisciplina(idDisciplina).get(comboSalas.getSelectedIndex()).getId();
        carregarDados(idDisciplina, idSala);
    }
    
    // Método para formatar as datas mostradas no formulário
    private String formatarData(String pData){
        String data = pData.substring(8,10) + '/' + pData.substring(5,7) + '/' + pData.substring(0,4); 
        return data; 
    }
    
    // Método para configurar as datas que serão mostradas no formulário
    private void configurarDatas(){
        String diaSemanaStr = dataAtual.getDayOfWeek().name();
        
        // Segunda-Feira
        if (diaSemanaStr.equals("MONDAY")){
            txtDataSeg.setText(formatarData(dataAtual.plusDays(0).toString()));
            txtDataTer.setText(formatarData(dataAtual.plusDays(1).toString()));
            txtDataQua.setText(formatarData(dataAtual.plusDays(2).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(3).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(4).toString()));           
        } 
        // Terça-Feira
        else if (diaSemanaStr.equals("TUESDAY")){
            txtDataSeg.setText(formatarData(dataAtual.minusDays(1).toString()));
            txtDataTer.setText(formatarData(dataAtual.plusDays(0).toString()));
            txtDataQua.setText(formatarData(dataAtual.plusDays(1).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(2).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(3).toString()));    
        }
        // Quarta-Feira
        else if (diaSemanaStr.equals("WEDNESDAY")){
            txtDataSeg.setText(formatarData(dataAtual.minusDays(2).toString()));
            txtDataTer.setText(formatarData(dataAtual.minusDays(1).toString()));
            txtDataQua.setText(formatarData(dataAtual.plusDays(0).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(1).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(2).toString()));    
        }
        // Quinta-Feira
        else if (diaSemanaStr.equals("THURSDAY")){
            txtDataSeg.setText(formatarData(dataAtual.minusDays(3).toString()));
            txtDataTer.setText(formatarData(dataAtual.minusDays(2).toString()));
            txtDataQua.setText(formatarData(dataAtual.minusDays(1).toString()));
            txtDataQui.setText(formatarData(dataAtual.plusDays(0).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(1).toString()));    
        }
        // Sexta-Feira
        else if (diaSemanaStr.equals("FRIDAY")){
            txtDataSeg.setText(formatarData(dataAtual.minusDays(4).toString()));
            txtDataTer.setText(formatarData(dataAtual.minusDays(3).toString()));
            txtDataQua.setText(formatarData(dataAtual.minusDays(2).toString()));
            txtDataQui.setText(formatarData(dataAtual.minusDays(1).toString()));
            txtDataSex.setText(formatarData(dataAtual.plusDays(0).toString()));    
        }  
    }
    
    // Método para formatar os elementos visuais da tela
    private void formatarTela() {
        txtDataSeg.setHorizontalAlignment(JTextField.CENTER);
        txtDataTer.setHorizontalAlignment(JTextField.CENTER);
        txtDataQua.setHorizontalAlignment(JTextField.CENTER);
        txtDataQui.setHorizontalAlignment(JTextField.CENTER);
        txtDataSex.setHorizontalAlignment(JTextField.CENTER);

        ((DefaultTableCellRenderer) tabelaSegundaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaTercaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaQuartaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaQuintaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((DefaultTableCellRenderer) tabelaSextaFeira.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void limparDetalhesAula() {
        lblDisciplina.setText("");
        lblHorario.setText("");
        lblMonitor.setText("");
        lblVagas.setText("");
        lblImagem.setIcon(new ImageIcon("C:\\Users\\vitor\\Desktop\\PDS\\PDS\\src\\imagens\\padrao.png"));
    }

    private void carregarDetalhesAula() {
        lblMonitor.setText(controleHorarioReservado.getHorarioReservado().getIdmon().getNome());
        lblDisciplina.setText(controleHorarioReservado.getHorarioReservado().getIddisc().getDescricao());
        lblHorario.setText(controleHorarioReservado.getHorarioReservado().getHorario());
        lblVagas.setText(controleHorarioReservado.getHorarioReservado().getQtd_alunos().toString());
        lblImagem.setIcon(new ImageIcon(controleHorarioReservado.getHorarioReservado().getIdmon().getImagem()));
    }

    private void selecionarHorario(Integer pDia) {
        try {
            controleHorarioReservado.setHorarioReservado(controleHorarioReservado.listar(pDia, idDisciplina, idSala, this.controleAluno.getAluno().getMatricula()).get(linhaSelecionada));
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarDados(Integer pID_Disciplina, Integer pID_Sala) throws ParseException, SQLException {
        TableModelDiaSemana_HoraReservada modelo = new TableModelDiaSemana_HoraReservada(controleHorarioReservado.listar(1, pID_Disciplina, pID_Sala, this.controleAluno.getAluno().getMatricula()), 1);
        tabelaSegundaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraReservada(controleHorarioReservado.listar(2, pID_Disciplina, pID_Sala, this.controleAluno.getAluno().getMatricula()), 2);
        tabelaTercaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraReservada(controleHorarioReservado.listar(3, pID_Disciplina, pID_Sala, this.controleAluno.getAluno().getMatricula()), 3);
        tabelaQuartaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraReservada(controleHorarioReservado.listar(4, pID_Disciplina, pID_Sala, this.controleAluno.getAluno().getMatricula()), 4);
        tabelaQuintaFeira.setModel(modelo);

        modelo = new TableModelDiaSemana_HoraReservada(controleHorarioReservado.listar(5, pID_Disciplina, pID_Sala, this.controleAluno.getAluno().getMatricula()), 4);
        tabelaSextaFeira.setModel(modelo);
    }

    private void carregarDisciplinas() throws ParseException, SQLException {
        try {
            comboDisciplinas.removeAllItems();
            for (Disciplina obj : controleDisciplina.listar("")) {
                comboDisciplinas.addItem(obj.getDescricao());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // Método para carregar o combo de salas de acordo com a disciplina selecionada
    private void carregarSalas(Integer pDisciplina) throws ParseException, SQLException {
        List<Sala> salas = this.controleSala.listarPorDisciplina(pDisciplina);
        System.out.println(idDisciplina);
        try {
            comboSalas.removeAllItems();
            for (Sala obj : salas) {
                comboSalas.addItem(obj.getDescricao());
                System.out.println(obj.getDescricao());
            }
        } catch (Exception e) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblLoad = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMonitor = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDisciplina = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblVagas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboDisciplinas = new javax.swing.JComboBox<>();
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
        setTitle("Scheduler - Matrícula em Monitoria");
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
        lblUsuario.setForeground(new java.awt.Color(153, 0, 204));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar.png"))); // NOI18N
        jButton1.setText("    Sair");
        jButton1.setToolTipText("Sair");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.setToolTipText("Confirmar matrícula");
        btConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton3.setText("Pesquisar");
        jButton3.setToolTipText("Pesquisar aulas");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblLoad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/horario_32x32.png"))); // NOI18N
        jButton2.setText("   Horários");
        jButton2.setToolTipText("Horários do Aluno");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(lblLoad)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(btConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/padrao.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Monitor:");

        lblMonitor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMonitor.setForeground(new java.awt.Color(0, 0, 153));
        lblMonitor.setText("Monitor Teste");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Disciplina:");

        lblDisciplina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDisciplina.setForeground(new java.awt.Color(0, 0, 153));
        lblDisciplina.setText("LPOO");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Horário:");

        lblHorario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHorario.setForeground(new java.awt.Color(0, 0, 153));
        lblHorario.setText("12:00 - 13:00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Vagas:");

        lblVagas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVagas.setForeground(new java.awt.Color(0, 0, 153));
        lblVagas.setText("12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisciplina)
                            .addComponent(lblMonitor)
                            .addComponent(lblHorario)
                            .addComponent(lblVagas)))
                    .addComponent(lblImagem))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonitor)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisciplina)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorario)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVagas)
                    .addComponent(jLabel12))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Disciplina:");

        comboDisciplinas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDisciplinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboDisciplinas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboDisciplinasFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Laboratório/Sala:");

        comboSalas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSalas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSalas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSalasItemStateChanged(evt);
            }
        });
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDisciplinas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDataSeg, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(comboSalas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDataTer, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDataQua, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDataQui, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataSex, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultaAgendamentoAluno.this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            idDisciplina = controleDisciplina.listar("").get(comboDisciplinas.getSelectedIndex()).getIddisc();

            discAtual = comboDisciplinas.getSelectedItem().toString().trim();
  
            if (discAnt != discAtual){
                carregarSalas(idDisciplina);
                discAnt = comboDisciplinas.getSelectedItem().toString().trim();
        
            }
        } catch (ParseException ex) {
            
        } catch (SQLException ex) {

        }

        try {
            idSala = controleSala.listarPorDisciplina(idDisciplina).get(comboSalas.getSelectedIndex()).getId();
        } catch (ParseException ex) {
            idSala = 0;
        } catch (SQLException ex) {
            idSala = 0;
        } catch (Exception e){
            idSala = 0;
        }
                             
        try {
            carregarDados(idDisciplina, idSala);
            
            if (tabelaSegundaFeira.getModel().getRowCount() == 0 && tabelaTercaFeira.getModel().getRowCount() == 0 && tabelaQuartaFeira.getModel().getRowCount() == 0 && tabelaQuintaFeira.getModel().getRowCount() == 0 && tabelaSextaFeira.getModel().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum horário de monitoria encontrado.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ParseException ex) {
            
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        limparDetalhesAula();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void tabelaSegundaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSegundaFeiraMouseClicked
        linhaSelecionada = tabelaSegundaFeira.getSelectedRow();
        selecionarHorario(1);
        carregarDetalhesAula();
    }//GEN-LAST:event_tabelaSegundaFeiraMouseClicked

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        String select = lblMonitor.getText();

        if (select.equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum horário selecionado.", "Scheduler", JOptionPane.ERROR_MESSAGE);
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "Confirmar a matrícula na monitoria selecionada ?", "Scheduler", JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                HorarioAgendaAluno a = new HorarioAgendaAluno(this.controleHorarioReservado.getHorarioReservado(), controleAluno.getAluno());
                this.controleHorarioAgendaAluno.salvar(a);
                JOptionPane.showMessageDialog(null, "Matrícula efetuada com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);

                try {
                    carregarDados(idDisciplina, idSala);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparDetalhesAula();
            } else {
                JOptionPane.showMessageDialog(null, "Matrícula cancelada.", "Scheduler", JOptionPane.ERROR_MESSAGE);
            }
        }
//        String select = lblMonitor.getText();
//
//        if (select.equals("")) {
//            JOptionPane.showMessageDialog(null, "Nenhum horário selecionado.", "Scheduler", JOptionPane.ERROR_MESSAGE);
//        } else {
//            int resp = JOptionPane.showConfirmDialog(null, "Confirmar a matrícula na monitoria selecionada ?", "Scheduler", JOptionPane.YES_NO_OPTION);
//
//            if (resp == JOptionPane.YES_OPTION) {
//                String mat = controleAluno.getAluno().getMatricula();
//                Integer id = controleHorarioReservado.getHorarioReservado().getId();
//                String resposta = this.controleHorarioAgendaAluno.salvar(mat, id);
//                if (resposta.equalsIgnoreCase("conflito monitor")) {
//                    JOptionPane.showMessageDialog(null, "Você já possui uma monitoria marcada nesse horário!", "Scheduler", JOptionPane.ERROR_MESSAGE);
//                }
//                if (resposta.equalsIgnoreCase("conflito aluno")) {
//                    JOptionPane.showMessageDialog(null, "Você já possui aula marcada nesse horário!", "Scheduler", JOptionPane.ERROR_MESSAGE);
//                }
//                if (resposta.equalsIgnoreCase("ok")) {
//                    JOptionPane.showMessageDialog(null, "Matrícula efetuada com sucesso.", "Scheduler", JOptionPane.INFORMATION_MESSAGE);
//                }
//                try {
//                    carregarDados(idDisciplina, idSala);
//                } catch (ParseException | SQLException ex) {
//                    Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                limparDetalhesAula();
//            } else {
//                JOptionPane.showMessageDialog(null, "Matrícula cancelada.", "Scheduler", JOptionPane.ERROR_MESSAGE);
//            }


    }//GEN-LAST:event_btConfirmarActionPerformed

    private void tabelaTercaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTercaFeiraMouseClicked
        linhaSelecionada = tabelaTercaFeira.getSelectedRow();
        selecionarHorario(2);
        carregarDetalhesAula();
    }//GEN-LAST:event_tabelaTercaFeiraMouseClicked

    private void comboSalasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSalasItemStateChanged

    }//GEN-LAST:event_comboSalasItemStateChanged

    private void comboSalasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSalasFocusLost
        try {
            try {
                idSala = controleSala.listarPorDisciplina(idDisciplina).get(comboSalas.getSelectedIndex()).getId();
            } catch (ParseException ex) {
                Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboSalasFocusLost

    private void comboDisciplinasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboDisciplinasFocusLost
        try {
            idDisciplina = controleDisciplina.listar("").get(comboDisciplinas.getSelectedIndex()).getIddisc();
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboDisciplinasFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            new ConsultaHorarioAluno(this.controleAluno).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAgendamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaQuartaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuartaFeiraMouseClicked
        linhaSelecionada = tabelaQuartaFeira.getSelectedRow();
        selecionarHorario(3);
        carregarDetalhesAula();
    }//GEN-LAST:event_tabelaQuartaFeiraMouseClicked

    private void tabelaQuintaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaQuintaFeiraMouseClicked
        linhaSelecionada = tabelaQuintaFeira.getSelectedRow();
        selecionarHorario(4);
        carregarDetalhesAula();
    }//GEN-LAST:event_tabelaQuintaFeiraMouseClicked

    private void tabelaSextaFeiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSextaFeiraMouseClicked
        linhaSelecionada = tabelaSextaFeira.getSelectedRow();
        selecionarHorario(5);
        carregarDetalhesAula();
    }//GEN-LAST:event_tabelaSextaFeiraMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JComboBox<String> comboDisciplinas;
    private javax.swing.JComboBox<String> comboSalas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblMonitor;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVagas;
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
