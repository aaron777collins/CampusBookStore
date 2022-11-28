/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bookstore.NewGUI.Panels.AddOrder.AddItem.OtherPanel;

import com.bookstore.NewGUI.Panels.AddOrder.AddItem.OtherPanel.*;

/**
 *
 * @author aaron
 */
public class OtherPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewBookPanel
     */
    public OtherPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NamePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        PricePanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 220), new java.awt.Dimension(0, 220), new java.awt.Dimension(32767, 220));

        setBackground(new java.awt.Color(33, 33, 33));
        setMinimumSize(new java.awt.Dimension(850, 270));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(850, 270));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        NamePanel.setBackground(new java.awt.Color(33, 33, 33));
        NamePanel.setPreferredSize(new java.awt.Dimension(750, 40));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5);
        flowLayout1.setAlignOnBaseline(true);
        NamePanel.setLayout(flowLayout1);

        jPanel2.setBackground(new java.awt.Color(33, 33, 33));
        jPanel2.setPreferredSize(new java.awt.Dimension(340, 100));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 5);
        flowLayout5.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");
        jPanel2.add(jLabel1);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setToolTipText("Enter Book Name");
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 28));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 28));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);

        NamePanel.add(jPanel2);

        add(NamePanel);

        PricePanel.setBackground(new java.awt.Color(33, 33, 33));
        PricePanel.setPreferredSize(new java.awt.Dimension(750, 40));
        java.awt.FlowLayout flowLayout7 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5);
        flowLayout7.setAlignOnBaseline(true);
        PricePanel.setLayout(flowLayout7);

        jPanel4.setBackground(new java.awt.Color(33, 33, 33));
        jPanel4.setPreferredSize(new java.awt.Dimension(340, 100));
        java.awt.FlowLayout flowLayout6 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 5);
        flowLayout6.setAlignOnBaseline(true);
        jPanel4.setLayout(flowLayout6);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Price:");
        jPanel4.add(jLabel2);

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField2.setToolTipText("Enter Book Name");
        jTextField2.setMinimumSize(new java.awt.Dimension(200, 28));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 28));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField2);

        PricePanel.add(jPanel4);

        add(PricePanel);
        add(filler1);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NamePanel;
    private javax.swing.JPanel PricePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}