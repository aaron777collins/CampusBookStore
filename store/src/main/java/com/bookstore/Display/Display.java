package com.bookstore.Display;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {
    public static void createWindow(){
        JFrame mainDisplay = new JFrame("Employee Menu");
        JFrame addItemDisplay = new JFrame("Item Entry");

        JButton button[] = new JButton[6];
        mainDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("UNIVERSITY OF WINDSOR BOOKSTORE");
        title.setHorizontalAlignment(JLabel.CENTER);

        title.setPreferredSize(new Dimension(JLabel.WIDTH, 100));
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        // software label styling

        JPanel gridFrame = new JPanel();

        JButton button1 = new JButton("View Stock");
        JButton button2 = new JButton("Add item to store +");
        JButton button3 = new JButton("Create new customer/employee account");
        JButton button4 = new JButton("Alter Availability");
        JButton button5 = new JButton("View Today's Shifts");
        JButton button6 = new JButton("Edit/Create Weekly Order");

        // text fields for adding item
        JLabel addItemLabel = new JLabel("Add Item");
        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField itemID = new JTextField();
        JButton submitItem = new JButton("Submit");
        JButton menuReturn = new JButton("Return to Main Menu");

        itemName.setBounds(100, 100, 200, 40);
        itemPrice.setBounds(100, 150, 200, 40);
        itemID.setBounds(100, 200, 200, 40);
        addItemLabel.setBounds(100, 40, 200, 50);
        submitItem.setBounds(100, 300, 100, 100);
        menuReturn.setBounds(210, 300, 100, 100);

        addItemDisplay.add(addItemLabel);
        addItemDisplay.add(itemName);
        addItemDisplay.add(itemPrice);
        addItemDisplay.add(itemID);


        // display for adding an item
        addItemDisplay.getContentPane().add(title, BorderLayout.NORTH);
        addItemDisplay.setPreferredSize(new Dimension(1280, 720));
        addItemDisplay.setLocationRelativeTo(null);
        addItemDisplay.pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.setVisible(false);
                addItemDisplay.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        gridFrame.add(button1);
        gridFrame.add(button2);
        gridFrame.add(button3);
        gridFrame.add(button4);
        gridFrame.add(button5);
        gridFrame.add(button6);

        gridFrame.setLayout(new GridLayout(2, 3, 25, 25));

        gridFrame.setSize(600, 600);
        gridFrame.setVisible(true);
        gridFrame.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainDisplay.add(gridFrame);

        // adding title to content pane and setting the window to be visible
        mainDisplay.getContentPane().add(title, BorderLayout.NORTH);
        mainDisplay.setPreferredSize(new Dimension(1280, 720));
        mainDisplay.setLocationRelativeTo(null);
        mainDisplay.pack();
        mainDisplay.setVisible(true);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
