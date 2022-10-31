package com.bookstore.Models;

public class Item {
    public String name;
    public float price;
    public String itemID;
    public ItemType itemType;
    /**
     * @param name The name of the item
     * @param price The price of the item
     * @param itemID The ID of the item
     * @param itemType The type of the item
     */
    public Item(String name, float price, String itemID, ItemType itemType) {
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.itemType = itemType;
    }
}
