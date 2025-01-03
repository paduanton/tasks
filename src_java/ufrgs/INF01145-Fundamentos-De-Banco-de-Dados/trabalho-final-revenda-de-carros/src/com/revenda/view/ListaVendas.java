/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.revenda.view;

import com.revenda.dao.CarroDAO;
import com.revenda.dao.ClienteDAO;
import com.revenda.dao.VendaDAO;
import com.revenda.dao.VendedorDAO;
import com.revenda.model.Cliente;
import com.revenda.model.Venda;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antonio
 */
public class ListaVendas extends javax.swing.JPanel {

    VendaDAO vendaDAO = new VendaDAO();
    List<Venda> lista;
    ClienteDAO clienteDAO;
    CarroDAO carroDAO = new CarroDAO();
    VendedorDAO vendedorDAO = new VendedorDAO();
    /**
     * Creates new form ListaCarros
     */
    public ListaVendas() {
        try {
            initComponents();
            clienteDAO = new ClienteDAO();
            vendedorDAO = new VendedorDAO();
            carroDAO = new CarroDAO();
            carregarDadosTabela();
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarDadosTabela() throws SQLException {
        lista = vendaDAO.listarTodas();
        // Obtém o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Remove as linhas existentes na tabela (caso já tenha dados)
        model.setRowCount(0);

        // Preenche a tabela com os dados da lista de clientes
        for (Venda venda : lista) {
            model.addRow(new Object[]{
                clienteDAO.buscarPorId(venda.getId_cliente()).getNome(),
                vendedorDAO.buscarPorId(venda.getId_vendedor()).getNome(),
                carroDAO.buscarPorId(venda.getId_carro()).getModelo(),
                venda.getValor_total(),
                venda.getData_venda()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jButton1.setText("Nova Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir Venda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Vendedor", "Carro", "Valor", "Data"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastraVenda cadastraVenda = new CadastraVenda(null, true);
        cadastraVenda.pack();
        cadastraVenda.setLocationRelativeTo(this);
        cadastraVenda.setVisible(true);
        try {
            carregarDadosTabela();
        } catch (SQLException ex) {
            Logger.getLogger(ListaVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Você deve escolher uma venda primeiro!");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Tem certeza dessa exclusão?") == 0) {
                Venda venda = lista.get(jTable1.getSelectedRow());
                VendaDAO vendaDAO = new VendaDAO();
                try {
                    vendaDAO.deletar(venda.getId_venda());
                    carregarDadosTabela();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaVendas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
