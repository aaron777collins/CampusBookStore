package com.bookstore.Models;

import java.util.List;

public class Order {
    public String accountID;
    public String orderID;
    public List<Item> items;
    /**
     * @param accountID The account of the user
     * @param orderID The order of the user
     * @param items the items in the order
     */
    public Order(String accountID, String orderID, List<Item> items) {
        this.accountID = accountID;
        this.orderID = orderID;
        this.items = items;
    }
}
