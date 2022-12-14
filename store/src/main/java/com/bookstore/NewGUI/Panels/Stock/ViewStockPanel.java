/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bookstore.NewGUI.Panels.Stock;

import com.bookstore.NewGUI.Panels.Stock.*;
import com.bookstore.DataManager.AccountManager;
import com.bookstore.DataManager.ItemManager;
import com.bookstore.DataManager.WeeklyOrdersManager;
import com.bookstore.DataStream.MongoConnector;
import com.bookstore.Helpers.CalendarHelper;
import com.bookstore.Models.Account;
import com.bookstore.Models.Item;
import com.bookstore.Models.ItemInfo;
import com.bookstore.Models.ItemType;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;
import com.bookstore.NewGUI.ButtonHelper.ButtonHelper;
import com.bookstore.NewGUI.MainDisplay;
import com.bookstore.NewGUI.Panels.AddOrder.AddItem.AddItemPanel;
import com.bookstore.NewGUI.Panels.AddOrder.AddOrderPanel;
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
public class ViewStockPanel extends javax.swing.JPanel {
    
    private List<Item> getItemData() {
        return MongoConnector.GetClassResults(Item.class, ItemManager.ITEMS_COLLECTION_NAME);
    }

    private String[] getColumnNames() {
                //                            (Account)
        // sendDate, AccountID, OrderID, FirstName, LastName, items list as string
        String[] columnNames = {
            "Name",
            "Price",
            "Item ID",
            "Item Type",
            "Item Info"
        };
        return columnNames;
    }

    private Item[] getRandomData() {
                // setup objects
                List<Item> items1 = new ArrayList<>();
                items1.add(new Item());
                Account accInit = AccountManager.getStoreAccount();
                ArrayList<ItemInfo> itemInfosAuthor = new ArrayList<ItemInfo>();
                itemInfosAuthor.add(new ItemInfo("author", "John Smith"));

                Item testItem1 = ItemManager.getItem("test1", 22.99f, ItemType.BOOK, itemInfosAuthor);
                Item testItem2 = ItemManager.getItem("test2", 23.99f, ItemType.OTHER, null);
                

                Calendar firstDayOfWeek = CalendarHelper.getFirstDayOfWeek();

                List<Item> items = getItemData();

                ItemManager.removeItem("test1", ItemType.BOOK);
                ItemManager.removeItem("test2", ItemType.OTHER);
               
                return items.toArray(new Item[items.size()]);
    }
    

    private Object[][] getData() {

        data = getRandomData();
        
        //                            (Account)
        // sendDate, AccountID, OrderID, FirstName, LastName, items list as string
        Object[][] dataArr = new Object[data.length][];

        for (int j = 0; j < data.length; j++) {
            dataArr[j] = new Object[]{  
                data[j].name,
                data[j].price,
                data[j].itemID,
                data[j].itemType,
                data[j].itemInfos
            };
        }

        return dataArr;
    }
    
    private void setEnabledEditAndDeleteButtons(boolean state) {
        jButton3.setEnabled(state);
        jButton4.setEnabled(state);
    }
    
    private void addTableSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    //System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    setEnabledEditAndDeleteButtons(true);
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
    public ViewStockPanel(MainDisplay display) {
        this.display = display;
        initComponents();
        this.buttons = new JButton[]{jButton1, jButton3, jButton4};
        ButtonHelper.addButtonHighlights(buttons);
        setEnabledEditAndDeleteButtons(false);
        addTableSelectionListener();
        sortTableRows();
    }
    
    private ItemType getItemType(String input) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.toString().equals(input)) {
                return itemType;
            }
        }
        return ItemType.OTHER;
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 33, 33));
        setForeground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(850, 500));
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

        jButton1.setText("Add Item");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton3.setText("Edit Selected Item");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setText("Delete Selected Item");
        jButton4.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.display.setNewPanel(new AddItemPanel(this.display));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        ItemManager.removeItem(jTable1.getValueAt(selectedRow, 0).toString(), getItemType(jTable1.getValueAt(selectedRow, 3).toString()));
        this.display.setNewPanel(new ViewStockPanel(this.display));
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private JButton[] buttons;
    private Item[] data;
    private MainDisplay display;

    
}
