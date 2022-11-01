package com.bookstore.Models;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OwnerSchedule {

    JFrame f;    
    public OwnerSchedule(){    
    f=new JFrame();    

    //{"id","mon","tue","wed","thurs","fri","sat","sun"} ---- format for table

    String data[][]={ {"410","9-5","9-5","9-5","9-5","9-5","",""},    
                      {"411","5-10","5-10","5-10","5-10","5-10","",""},    
                      {"412","","","","","","12-5","12-5"},
                      {"413","","","","12-5","12-5","5-8","5-8"}};    
    String column[]={"ID","MONDAY","TUESDAY","WEDNESAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(60,80,400,500);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(400,300);    
    f.setVisible(true);    
    


    
}
}
