package com.bookstore.Models;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ScheduleMaker {

    JFrame f;    
    ScheduleMaker(){    
    f=new JFrame();    
    String data[][]={ {}};    
    String column[]={"DAY","ID","SHIFT"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);    
    


    
}
