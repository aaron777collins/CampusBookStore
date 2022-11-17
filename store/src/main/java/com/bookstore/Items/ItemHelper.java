package com.bookstore.Items;

import com.bookstore.Models.Item;
import com.bookstore.Models.ItemType;

public class ItemHelper {
    public static Item makeItem(String name, float price, ItemType itemType) {
        Item item = new Item(name, price, System.currentTimeMillis() + "", itemType);
        // itemID is the currentTimeMillis right now
        item.itemID = item.itemID + "-" + item.hashCode();
        return item;
    }
}
