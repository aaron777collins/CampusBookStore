package com.bookstore.NewGUI.Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bookstore.DataManager.AccountManager;
import com.bookstore.DataManager.WeeklyOrdersManager;
import com.bookstore.Helpers.CalendarHelper;
import com.bookstore.Models.Account;
import com.bookstore.Models.Item;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;

public class WeeklyOrdersPanel extends JPanel{

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

    private WeeklyOrder getRandomData() {
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
                System.out.println(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder1, firstDayOfWeek));
                System.out.println(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder2, firstDayOfWeek));
                System.out.println(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder3, firstDayOfWeek));
                System.out.println(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder4, firstDayOfWeek));
                System.out.println(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder5, firstDayOfWeek));

                WeeklyOrder data = getWeeklyData();

                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder1, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder2, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder3, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder4, firstDayOfWeek);
                WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder5, firstDayOfWeek);


                return data;
    }

    private Object[][] getData() {

        WeeklyOrder data = getRandomData();

        //                            (Account)
        // sendDate, AccountID, OrderID, FirstName, LastName, items list as string
        Object[][] dataArr = new Object[data.orders.size()][];

        for (int i = 0; i < data.orders.size(); i++) {
            Order order = data.orders.get(i);
            Account acc = AccountManager.getAccount(data.orders.get(i).accountID);
            dataArr[i] = new Object[]{  data.sendDate.toString(),
                            order.accountID,
                            order.orderID,
                        acc.firstName,
                        acc.lastName,
                        order.items.toString()
                        };

        }

        return dataArr;
    }

    public WeeklyOrdersPanel(JPanel parent) {

        // Makes the table selectable, but NOT Editable
        JTable table = new JTable(getData(), getColumnNames()) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.setLayout(new BorderLayout());
        this.add(table.getTableHeader(), BorderLayout.PAGE_START);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setPreferredSize(parent.getPreferredSize());
        this.setVisible(true);
    }

}

