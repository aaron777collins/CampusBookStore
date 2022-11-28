package com.bookstore.Items;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.bookstore.Models.Item;
import com.bookstore.Models.ItemInfo;
import com.bookstore.Models.ItemType;

public class ItemHelperTest {
    @Test
    void testMakeItem() throws InterruptedException {

        ArrayList<ItemInfo> itemInfosAuthor = new ArrayList<ItemInfo>();
        itemInfosAuthor.add(new ItemInfo("author", "John Smith"));

        Item testItem1 = ItemHelper.makeItem("test1", 22.99f, ItemType.OTHER, null);
        Item testItem2 = ItemHelper.makeItem("test2", 23.99f, ItemType.BOOK, itemInfosAuthor);
        assertNotEquals(testItem1.name, testItem2.name);
        assertNotEquals(testItem1.price, testItem2.price);
        assertNotEquals(testItem1.itemType, testItem2.itemType);
        assertNotEquals(testItem1.itemID, testItem2.itemID);

        Item identicalTestItem1 = ItemHelper.makeItem("test3", 22.99f, ItemType.OTHER, null);
        Thread.sleep(10);
        Item identicalTestItem2 = ItemHelper.makeItem("test3", 22.99f, ItemType.OTHER, null);

        assertEquals(identicalTestItem1.name, identicalTestItem2.name);
        assertEquals(identicalTestItem1.price, identicalTestItem2.price);
        assertEquals(identicalTestItem1.itemType, identicalTestItem2.itemType);
        assertNotEquals(identicalTestItem1.itemID, identicalTestItem2.itemID);
    }
}
