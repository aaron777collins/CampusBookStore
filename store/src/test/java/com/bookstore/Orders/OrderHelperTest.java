package com.bookstore.Orders;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.bookstore.Models.Item;
import com.bookstore.Models.ItemType;
import com.bookstore.Models.Order;

public class OrderHelperTest {

    @Test
    void testMakeOrder() throws InterruptedException {

        MakeOrderTester tester = new MakeOrderTester();
        Thread thread = new Thread(tester);
        thread.start();
        thread.join();
        String orderID1 = tester.getOrderID1();
        String orderID2 = tester.getOrderID2();

        assertNotEquals(orderID1, orderID2);

        MakeOrderTester tester2 = new MakeOrderTester();
        Thread thread2 = new Thread(tester2);
        thread2.start();
        thread2.join();
        String orderID3 = tester2.getOrderID1();
        String orderID4 = tester2.getOrderID2();

        assertNotEquals(orderID3, orderID4);

    }

    private Order makeOrderTest() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("testItem", 22.99f, "1234", ItemType.OTHER));
        return OrderHelper.makeOrder("test", items);
    }
}

class MakeOrderTester implements Runnable{

    private volatile String orderID1 = null;
    private volatile String orderID2 = null;

    @Override
    public void run() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("testItem", 22.99f, "1234", ItemType.OTHER));
        Order order = OrderHelper.makeOrder("test", items);
        orderID1 = order.orderID;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Item> items2 = new ArrayList<Item>();
        items2.add(new Item("testItem", 22.99f, "1234", ItemType.OTHER));
        Order order2 = OrderHelper.makeOrder("test", items);
        orderID1 = order2.orderID;
    }


    public String getOrderID1() {
        return orderID1;
    }
    public String getOrderID2() {
        return orderID2;
    }
}

class MakeOrderTesterSameTime implements Runnable{

    private volatile String orderID1 = null;
    private volatile String orderID2 = null;

    @Override
    public void run() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("testItem", 22.99f, "1234", ItemType.OTHER));
        Order order = OrderHelper.makeOrder("test", items);
        orderID1 = order.orderID;
        List<Item> items2 = new ArrayList<Item>();
        items2.add(new Item("testItem2", 22.99f, "1234", ItemType.OTHER));
        Order order2 = OrderHelper.makeOrder("test", items);
        orderID1 = order2.orderID;
    }


    public String getOrderID1() {
        return orderID1;
    }
    public String getOrderID2() {
        return orderID2;
    }
}
