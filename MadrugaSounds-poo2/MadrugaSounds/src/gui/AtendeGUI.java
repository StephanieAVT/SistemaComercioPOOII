/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.AtendeDAO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Atende;


/**
 *
 * @author LILIAN
 */
public class AtendeGUI extends javax.swing.JFrame {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    AtendeDAO lista = new AtendeDAO();
    private int controle;
    public AtendeGUI() {
        initComponents();
        carregaTabela();
        desativarBotoes();
        desativarCampos();
        txtId.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtIdVendedor = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btPrimeiro = new javax.swing.JButton();
        btVolta = new javax.swing.JButton();
        btUltimo = new javax.swing.JButton();
        btAvança = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAtende = new javax.swing.JTable();
        btSair = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(591, 422));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimento"));

        jLabel1.setText("Codigo Atendimento:");

        jLabel2.setText("Data:");

        jLabel3.setText("Id Vendedor:");

        jLabel4.setText("Cpf do Cliente:");

        txtIdVendedor.setText(" ");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons/resultset_first.png"))); // NOI18N
        btPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimeiroActionPerformed(evt);
            }
        });

        btVolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons/resultset_previous.png"))); // NOI18N
        btVolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltaActionPerformed(evt);
            }
        });

        btUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons/resultset_last.png"))); // NOI18N
        btUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltimoActionPerformed(evt);
            }
        });

        btAvança.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons/resultset_next.png"))); // NOI18N
        btAvança.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvançaActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tbAtende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Atendimento", "Data", "Id Vendedor", "Cpf do Cliente"
            }
        ));
        tbAtende.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAtendeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAtende);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdVendedor))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(54, 54, 54)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 75, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btSair)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btVolta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAvança))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btPrimeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUltimo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btNovo)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btGravar)
                                    .addComponent(btSair)))
                            .addGap(19, 19, 19)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btExcluir)
                                .addComponent(btAlterar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btUltimo)
                            .addComponent(btPrimeiro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVolta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAvança, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparTela();
        ativarBotoes();
        ativarCampos();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        int Vendedor_idVendedor = Integer.parseInt(txtIdVendedor.getText());
        
        Atende atende = new Atende();
        atende.setData(txtData.getText());
        atende.setVendedor_idVendedor(Vendedor_idVendedor);
        atende.setCliente_cpf(txtCpf.getText());
        if((txtData.getText().isEmpty())|| (txtIdVendedor.getText().isEmpty()) || (txtCpf.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Favor inserir os dados");
        }else{
            AtendeDAO dao = new AtendeDAO();
            dao.adiciona(atende);
            carregaTabela();
            JOptionPane.showMessageDialog(null,"Atendimeto "+txtId.getText()+"inserido com sucesso!");
        }
        
    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        
        int Vendedor_idVendedor = Integer.parseInt(txtIdVendedor.getText());
        Atende atende = new Atende();
        AtendeDAO dao = new AtendeDAO();
        
        int index = tbAtende.getSelectedRow();//retorna o numero da linha selecionada
        atende = dao.listar().get(index);//retorna o objeto dentro do arrayList de acordo com a posição index
        
        //seta as novas informações para o objeto selecionado
        atende.setData(txtData.getText());
        atende.setVendedor_idVendedor(Vendedor_idVendedor);
        atende.setCliente_cpf(txtCpf.getText());
        
        dao.alterar(atende);//faz as alterações no banco de dados
        carregaTabela();
        
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Atende atende = new Atende();
        AtendeDAO dao = new AtendeDAO();
        
        int index = tbAtende.getSelectedRow();//retorna o numero da linha selecionada
        atende = dao.listar().get(index);//retorna o objeto dentro do arrayList de acordo com a posição index
        
        dao.remove(atende);
        carregaTabela();
        limparTela();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrimeiroActionPerformed
        controle=0;
        setarCampos(lista.listar().get(controle));
    }//GEN-LAST:event_btPrimeiroActionPerformed

    private void btUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltimoActionPerformed
        controle = tbAtende.getRowCount()-1;
        setarCampos(lista.listar().get(controle));
    }//GEN-LAST:event_btUltimoActionPerformed

    private void btVoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltaActionPerformed
        controle--;
        if(controle>=0){
        setarCampos(lista.listar().get(controle));
        }
        else{
            controle=0;
            setarCampos(lista.listar().get(controle));
            JOptionPane.showMessageDialog(null,"Você está no primeiro registro"," Alerta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btVoltaActionPerformed

    private void btAvançaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvançaActionPerformed
        controle++;
        if(controle<tbAtende.getRowCount()){
        setarCampos(lista.listar().get(controle));
        }
        else{
            controle = tbAtende.getRowCount()-1;
            setarCampos(lista.listar().get(controle));
            JOptionPane.showMessageDialog(null,"Você está no último registro"," Alerta",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btAvançaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tbAtendeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtendeMouseClicked
        Atende atende = new Atende();
        AtendeDAO dao = new AtendeDAO();
        
        int index = tbAtende.getSelectedRow();//retorna o numero da linha selecionada
        atende = dao.listar().get(index);
        txtId.setText(String.valueOf(atende.getCodAtendimento()));
        txtData.setText(atende.getData());
        txtIdVendedor.setText(String.valueOf(atende.getVendedor_idVendedor()));
        txtCpf.setText(atende.getCliente_cpf());
        btGravar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbAtendeMouseClicked
 
    private void limparTela(){
        txtId.setText("");
        txtData.setText("");
        txtIdVendedor.setText("");
        txtCpf.setText("");
    }
    private void desativarBotoes(){
        btGravar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    private void desativarCampos(){
        txtId.setEnabled(false);
        txtData.setEnabled(false);
        txtIdVendedor.setEnabled(false);
        txtCpf.setEnabled(false);
    }
    private void ativarBotoes(){
        btGravar.setEnabled(true);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }
    private void ativarCampos(){
        txtId.setEnabled(true);
        txtData.setEnabled(true);
        txtIdVendedor.setEnabled(true);
        txtCpf.setEnabled(true);
    }
    private void carregaTabela(){
    DefaultTableModel modeloPadrao = (DefaultTableModel) tbAtende.getModel();
    modeloPadrao.setNumRows(0);
    
        try {
            this.connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from atende;");
            rs = stmt.executeQuery();
            while(rs.next()){
                modeloPadrao.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4)
                });
            
            }
            } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    
}
     private void setarCampos(Atende atende){
        txtId.setText(String.valueOf(atende.getCodAtendimento()));
        txtData.setText(atende.getData());
        txtIdVendedor.setText(String.valueOf(atende.getVendedor_idVendedor()));
        txtCpf.setText(atende.getCliente_cpf());
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtendeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtendeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtendeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtendeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtendeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btAvança;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPrimeiro;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btUltimo;
    private javax.swing.JButton btVolta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbAtende;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdVendedor;
    // End of variables declaration//GEN-END:variables
}