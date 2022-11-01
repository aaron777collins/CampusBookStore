package com.bookstore.Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    public static void createWindow(){
        JFrame mainDisplay = new JFrame("Employee Menu");
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("UNIVERSITY OF WINDSOR BOOKSTORE");
        title.setHorizontalAlignment(JLabel.CENTER);

        title.setPreferredSize(new Dimension(JLabel.WIDTH, 100));
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        // software label styling
        JLabel softwareLabel = new JLabel("Employee Software System");
        softwareLabel.setHorizontalAlignment(JLabel.CENTER);
        softwareLabel.setPreferredSize(new Dimension(JLabel.WIDTH, 50));
        softwareLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        mainDisplay.getContentPane().add(title, BorderLayout.NORTH);
        mainDisplay.getContentPane().add(softwareLabel, BorderLayout.NORTH);
        mainDisplay.setPreferredSize(new Dimension(1280, 720));
        mainDisplay.setLocationRelativeTo(null);
        mainDisplay.pack();
        mainDisplay.setVisible(true);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
