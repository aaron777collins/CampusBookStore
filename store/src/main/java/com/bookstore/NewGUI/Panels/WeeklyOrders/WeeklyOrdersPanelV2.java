/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bookstore.NewGUI.Panels.WeeklyOrders;

import com.bookstore.DataManager.AccountManager;
import com.bookstore.DataManager.WeeklyOrdersManager;
import com.bookstore.Helpers.CalendarHelper;
import com.bookstore.Models.Account;
import com.bookstore.Models.Item;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author aaron
 */
public class WeeklyOrdersPanelV2 extends javax.swing.JPanel {
    
    private void addButtonListeners() {
        for (JButton button : this.buttons) {
            button.setBackground(new Color(255, 255, 255));
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setBackground(new Color(167, 161, 179));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setBackground(new Color(255, 255, 255));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setBackground(new Color(71, 1, 194));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setBackground(new Color(255, 255, 255));
                }
            });
        }
    }
    
    private WeeklyOrder getWeeklyData() {
        return WeeklyOrdersManager.getWeeklyOrder(CalendarHelper.getFirstDayOfWeek());
    }

    private String[] getColumnNames() {
                //                            (Account)
        // sendDate, AccountID, OrderID, FirstName, LastName, items list as string
        String[] columnNames = {
            "Send Date",
            "Account ID",
            "Order ID",
            "First Name",
            "Last Name",
            "Items"
        };
        return columnNames;
    }

    private WeeklyOrder[] getRandomData() {
                // setup objects
                List<Item> items1 = new ArrayList<Item>();
                items1.add(new Item());
                Account accInit = AccountManager.getStoreAccount();
                Order testOrder1 = new Order(accInit.accountID, "ordertest1", items1);
                Order testOrder2 = new Order(accInit.accountID, "ordertest2", items1);
                Order testOrder3 = new Order(accInit.accountID, "ordertest3", items1);
                Order testOrder4 = new Order(accInit.accountID, "ordertest4", items1);
                Order testOrder5 = new Order(accInit.accountID, "ordertest5", items1);

                Calendar firstDayOfWeek = CalendarHelper.getFirstDayOfWeek();

                // insert our test classes
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder1, firstDayOfWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder2, firstDayOfWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder3, firstDayOfWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder4, firstDayOfWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder5, firstDayOfWeek);

                WeeklyOrder data = getWeeklyData();

                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder1, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder2, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder3, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder4, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder5, firstDayOfWeek);
                
                List<Item> items2 = new ArrayList<Item>();
                items2.add(new Item());
                Order testOrder6 = new Order(accInit.accountID, "ordertest6", items2);
                Order testOrder7 = new Order(accInit.accountID, "ordertest7", items2);
                Order testOrder8 = new Order(accInit.accountID, "ordertest8", items2);
                Order testOrder9 = new Order(accInit.accountID, "ordertest9", items2);
                Order testOrder10 = new Order(accInit.accountID, "ordertest10", items2);

                Calendar prevWeek = CalendarHelper.getFirstDayOfWeek();
                prevWeek.add(Calendar.DAY_OF_WEEK, -7);

                // insert our test classes
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder6, prevWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder7, prevWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder8, prevWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder9, prevWeek);
                WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder10, prevWeek);

                WeeklyOrder data2 = WeeklyOrdersManager.getWeeklyOrder(prevWeek);

                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder6, prevWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder7, prevWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder8, prevWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder9, prevWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder10, prevWeek);

                WeeklyOrder[] orders = new WeeklyOrder[2];
                orders[1] = data;
                orders[0] = data2;
                return orders;
    }
    

    private Object[][] getData() {

        data = getRandomData();
        
        int numOrders = 0;
        
        for (WeeklyOrder weeklyOrder : data) {
            numOrders += weeklyOrder.orders.size();
        }

        //                            (Account)
        // sendDate, AccountID, OrderID, FirstName, LastName, items list as string
        Object[][] dataArr = new Object[numOrders][];

        int currentRow = 0;
        for (WeeklyOrder weeklyOrder : data) {
            for (int j = 0; j < weeklyOrder.orders.size(); j++, currentRow++) {
                Order order = weeklyOrder.orders.get(j);
                Account acc = AccountManager.getAccount(weeklyOrder.orders.get(j).accountID);
                dataArr[currentRow] = new Object[]{  weeklyOrder.sendDate,
                    order.accountID,
                    order.orderID,
                    acc.firstName,
                    acc.lastName,
                    order.items.toString()
                };
            }
        }

        return dataArr;
    }
    
    private void setEnabledEditAndDeleteButtons(boolean state) {
        jButton2.setEnabled(state);
        jButton3.setEnabled(state);
    }
    
    private void addTableSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    //System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    Date selectedDate = (Date)(jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                    setEnabledEditAndDeleteButtons(selectedDate.compareTo(CalendarHelper.getFirstDayOfWeek().getTime()) >= 0);
                }
            }
        });
    }
    
    private void sortTableRows() {
        jTable1.setAutoCreateRowSorter(true);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(1);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
        jTable1.getRowSorter().setSortKeys(sortKeys);
    }
    
    /**
     * Creates new form WeeklyOrdersPanelV2
     */
    public WeeklyOrdersPanelV2() {
        initComponents();
        this.buttons = new JButton[]{jButton1, jButton2, jButton3};
        addButtonListeners();
        setEnabledEditAndDeleteButtons(false);
        addTableSelectionListener();
        sortTableRows();
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
        jTable1 = new javax.swing.JTable() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 33, 33));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(820, 500));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(33, 33, 33));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setAlignmentY(0.0F);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(850, 410));
        jScrollPane1.setRowHeaderView(null);
        jScrollPane1.setViewportView(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(getData(), getColumnNames()));
        jTable1.setSelectionBackground(new java.awt.Color(71, 1, 194));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(33, 33, 33));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 50));

        jButton1.setText("Add Order");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Edit Selected Order");
        jButton2.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(jButton2);

        jButton3.setText("Delete Order");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private JButton[] buttons;
    private WeeklyOrder[] data;

    
}
