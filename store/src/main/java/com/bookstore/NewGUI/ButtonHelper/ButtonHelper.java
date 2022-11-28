/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.NewGUI.ButtonHelper;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author aaron
 */
public class ButtonHelper {
    public static void addButtonHighlights(JButton[] buttons) {
        for (JButton button : buttons) {
            button.setBackground(new Color(255, 255, 255));
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setForeground(new Color(0,0,0));
                    button.setBackground(new Color(167, 161, 179));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setForeground(new Color(0,0,0));
                    button.setBackground(new Color(255, 255, 255));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setForeground(new Color(255,255,255));
                    button.setBackground(new Color(71, 1, 194));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    button.setForeground(new Color(0,0,0));
                    button.setBackground(new Color(255, 255, 255));
                }
            });
        }
    }
}
