/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.NewGUI.ComboBoxHelper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author aaron
 */
public class ComboBoxRenderer extends DefaultListCellRenderer {
    
    private ListCellRenderer defaultRenderer;
    
    public ComboBoxRenderer(ListCellRenderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
    }
    
    
    public ListCellRenderer getListCellRenderer() {
        ListCellRenderer newListCellRenderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
              Component c = defaultRenderer.getListCellRendererComponent(list, value,
                  index, isSelected, cellHasFocus);
              if (c instanceof JLabel) {
                if (isSelected) {
                  c.setBackground(new Color(71, 1, 194));
                  c.setForeground(new Color(255,255,255));
                } else {
                  c.setBackground(new Color(255,255,255));
                  c.setForeground(new Color(0,0,0));
                }
              } else {
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                    cellHasFocus);
                c.setBackground(new Color(71, 1, 194));
              }
              return c;
            }
        };
        return newListCellRenderer;
    }
}
