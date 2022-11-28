package com.bookstore.DataManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.bookstore.DataManager.ItemManager;
import com.bookstore.Models.Item;
import com.bookstore.Models.ItemInfo;
import com.bookstore.Models.ItemType;

public class ItemManagerTest {
    @Test
    void testItems() {

        ArrayList<ItemInfo> itemInfosAuthor = new ArrayList<ItemInfo>();
        itemInfosAuthor.add(new ItemInfo("author", "John Smith"));

        Item testItem1 = ItemManager.getItem("test1", 22.99f, ItemType.BOOK, itemInfosAuthor);
        Item testItem2 = ItemManager.getItem("test2", 23.99f, ItemType.OTHER, null);

        assertNotEquals(testItem1.name, testItem2.name);
        assertNotEquals(testItem1.price, testItem2.price);
        assertNotEquals(testItem1.itemType, testItem2.itemType);
        assertEquals(testItem1.name, "test1");
        assertEquals(testItem1.price, 22.99f);
        assertEquals(testItem1.itemType, ItemType.BOOK);
        assertEquals(testItem2.name, "test2");
        assertEquals(testItem2.price, 23.99f);
        assertEquals(testItem2.itemType, ItemType.OTHER);

        assertTrue(ItemManager.removeItem(testItem1.name, testItem1.itemType));
        assertTrue(ItemManager.removeItem(testItem2.name, testItem2.itemType));

    }

}
