package com.bookstore.Orders;

import java.util.List;

import com.bookstore.Models.Item;
import com.bookstore.Models.Order;

public class OrderHelper {
    public static Order makeOrder(String accountID, List<Item> items) {
        Order order = new Order(accountID, System.currentTimeMillis() + "", items);
        order.orderID = accountID + "-" + order.orderID + "-" + order.hashCode();
        return order;
    }
}
