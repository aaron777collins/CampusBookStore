/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bookstore.NewGUI.Panels.AddOrder.AddItem;

import com.bookstore.DataManager.ItemManager;
import com.bookstore.Items.ItemHelper;
import com.bookstore.Models.Item;
import com.bookstore.Models.ItemInfo;
import com.bookstore.Models.ItemType;
import com.bookstore.NewGUI.ButtonHelper.ButtonHelper;
import com.bookstore.NewGUI.ComboBoxHelper.ComboBoxRenderer;
import com.bookstore.NewGUI.MainDisplay;
import com.bookstore.NewGUI.Panels.AddOrder.AddItem.BookPanel.BookPanel;
import com.bookstore.NewGUI.Panels.AddOrder.AddItem.ClothingPanel.ClothingPanel;
import com.bookstore.NewGUI.Panels.AddOrder.AddItem.OtherPanel.OtherPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author aaron
 */
public class AddItemPanel extends javax.swing.JPanel {
        
    JPanel dynamicPanel;
    
    public void setScrollPanel(JPanel panel) {
        this.dynamicPanel = panel;
        jPanel5.removeAll();
        jPanel5.add(this.dynamicPanel);
        this.revalidate();
        this.repaint();
    }

    
    private String[] getTypes() {
        ItemType[] itemTypes = ItemType.values();
        String[] itemTypeStrArr = new String[itemTypes.length];
        for(int i = 0; i < itemTypes.length; i++) {
            itemTypeStrArr[i] = itemTypes[i].toString();
        }
        return itemTypeStrArr;
    }
    
    private void setComboBoxHighlights() {
        ListCellRenderer renderer = new ComboBoxRenderer(jComboBox1.getRenderer()).getListCellRenderer();
        jComboBox1.setRenderer(renderer);
        jComboBox1.setBackground(new Color(255,255,255));
    }
    
    private void updateScrollPanel() {
            
        String selected = jComboBox1.getSelectedItem().toString();
        if (selected.equals(ItemType.BOOK.toString())) {
            setScrollPanel(new BookPanel());
        } else if (selected.equals(ItemType.CLOTHING.toString())) {
            setScrollPanel(new ClothingPanel());
        } else {
            // other
            setScrollPanel(new OtherPanel());
        }
        
    }
    
    private void setScrollPanelListener() {
        this.jComboBox1.addItemListener((ItemEvent evt) -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                updateScrollPanel();
            }
        });
    }
    
    private ItemType getItemType(String input) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.toString().equals(input)) {
                return itemType;
            }
        }
        return ItemType.OTHER;
    }
    
    private Item collectData() throws NumberFormatException {
        
        ItemType itemType = getItemType(this.jComboBox1.getSelectedItem().toString());
        
        String name = "";
        float price = 0.0f;
        List<ItemInfo> itemInfos = new ArrayList<>();
        
        if (itemType == ItemType.BOOK) {
            BookPanel panel = (BookPanel) dynamicPanel;
            name = panel.BookNameField.getText();
            price = Float.parseFloat(panel.PriceField.getText());
            itemInfos.add(new ItemInfo("author", panel.AuthorField.getText()));
            itemInfos.add(new ItemInfo("ISBN", panel.ISBNField.getText()));
        } else if (itemType == ItemType.CLOTHING) {
            ClothingPanel panel = (ClothingPanel) dynamicPanel;
            name = panel.NameField.getText();
            price = Float.parseFloat(panel.PriceField.getText());
            itemInfos.add(new ItemInfo("sizes", panel.SizesField.getSelectedValuesList().toString()));
            itemInfos.add(new ItemInfo("colors", panel.ColorsField.getSelectedValuesList().toString()));
        } else {
            OtherPanel panel = (OtherPanel) dynamicPanel;
            name = panel.NameField.getText();
            price = Float.parseFloat(panel.PriceField.getText());

        }
        
        return ItemHelper.makeItem(name, price, itemType, itemInfos);

    }
    
    /**
     * Creates new form AddItem
     */
    public AddItemPanel(MainDisplay display) {
        this.display = display;
        initComponents();
        this.buttons = new JButton[] {jButton1};
        ButtonHelper.addButtonHighlights(buttons);
        setComboBoxHighlights();
        updateScrollPanel();
        setScrollPanelListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 33, 33));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(850, 66));
        setPreferredSize(new java.awt.Dimension(850, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(33, 33, 33));
        jPanel3.setMinimumSize(new java.awt.Dimension(850, 140));
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 140));

        jPanel1.setBackground(new java.awt.Color(33, 33, 33));
        jPanel1.setMinimumSize(new java.awt.Dimension(838, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(838, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Item");
        jPanel1.add(jLabel1);

        jPanel2.setBackground(new java.awt.Color(33, 33, 33));
        jPanel2.setMinimumSize(new java.awt.Dimension(850, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item Type");
        jPanel2.add(jLabel2);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(getTypes()));
        jComboBox1.setMinimumSize(new java.awt.Dimension(150, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel2.add(jComboBox1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel3, java.awt.BorderLayout.NORTH);

        jScrollPane1.setBackground(new java.awt.Color(33, 33, 33));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(850, 310));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(850, 310));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(850, 310));

        jPanel5.setBackground(new java.awt.Color(33, 33, 33));
        jPanel5.setMinimumSize(new java.awt.Dimension(850, 270));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(850, 270));
        jPanel5.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(jPanel5);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(33, 33, 33));
        jPanel4.setMinimumSize(new java.awt.Dimension(850, 50));
        jPanel4.setPreferredSize(new java.awt.Dimension(850, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 5));

        jButton1.setText("Create Item");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        add(jPanel4, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Item newItem = collectData();
            ItemManager.getItem(newItem.name, newItem.price, newItem.itemType, newItem.itemInfos);
            this.display.setNewPanel(new AddItemPanel(this.display));
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a proper price!", "Format Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private JButton[] buttons;
    private MainDisplay display;

}
