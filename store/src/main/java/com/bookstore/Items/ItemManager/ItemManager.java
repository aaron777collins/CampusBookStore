package com.bookstore.Items.ItemManager;

import com.bookstore.DataStream.MongoConnector;
import com.bookstore.Items.ItemHelper;
import com.bookstore.Models.Account;
import com.bookstore.Models.Item;
import com.bookstore.Models.ItemType;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import static com.mongodb.client.model.Filters.and;


public class ItemManager {

    public static final String ITEMS_COLLECTION_NAME = "Accounts";

    public static boolean removeItem(String name, ItemType itemType) {


        Item item = getItem(name, 0, itemType);

        if (item == null) {
            return false;
        }

        return MongoConnector.RemoveMany(eq("itemID", item.itemID), ITEMS_COLLECTION_NAME);

    }

    public static Item getItem(String name, float price, ItemType itemType) {

        List<Item> Items =  MongoConnector.GetClassResultsWithFilter(Item.class, and(eq("name", name), eq("itemType", itemType)), ITEMS_COLLECTION_NAME);

        Item currentItem = null;

        if (Items.size() == 0) {
            // Order doesn't exist so we make one and insert it
            currentItem = ItemHelper.makeItem(name, price, itemType);
            if(!(MongoConnector.InsertClass(currentItem, ITEMS_COLLECTION_NAME))) {
                // if it cannot insert new week
                System.err.println("Could not insert new Item!");
            }
        } else {
            currentItem = Items.get(0);
        }


        return currentItem;
    }
}
