package com.bookstore.Items;

import java.util.List;

import com.bookstore.Models.Item;
import com.bookstore.Models.ItemInfo;
import com.bookstore.Models.ItemType;

public class ItemHelper {
    public static Item makeItem(String name, float price, ItemType itemType, List<ItemInfo> itemInfos) {
        Item item = new Item(name, price, System.currentTimeMillis() + "", itemType, itemInfos);
        // itemID is the currentTimeMillis right now
        item.itemID = item.itemID + "-" + item.hashCode();
        return item;
    }
}
