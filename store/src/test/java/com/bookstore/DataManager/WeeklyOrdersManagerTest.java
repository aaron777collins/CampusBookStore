package com.bookstore.DataManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bookstore.Helpers.CalendarHelper;
import com.bookstore.Models.Item;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;

public class WeeklyOrdersManagerTest {

    @Test
    void testWeeklyOrderFunctions() throws ParseException {
        // setup objects
        List<Item> items1 = new ArrayList<Item>();
        List<Item> items2 = new ArrayList<Item>();
        items2.add(new Item());
        Order testOrder1 = new Order("test1", "ordertest1", items1);
        Order testOrder2 = new Order("test2", "ordertest2", items2);
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-01-01 00:00:00");
        Calendar cal = CalendarHelper.toCalendar(date);
        Calendar firstDayOfWeek = CalendarHelper.getFirstDayOfWeek(cal);

        // get current order (should be empty)
        WeeklyOrder order1 = WeeklyOrdersManager.getWeeklyOrder(firstDayOfWeek);

        // assert that its empty
        assertEquals(order1, new WeeklyOrder(new ArrayList<Order>(), firstDayOfWeek));

        // insert our test classes
        assertTrue(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder1, firstDayOfWeek));
        assertTrue(WeeklyOrdersManager.insertOrderInWeeklyOrder(testOrder2, firstDayOfWeek));

        // get updated weekly order
        WeeklyOrder order2 = WeeklyOrdersManager.getWeeklyOrder(firstDayOfWeek);

        assertEquals(order1.orders.size() + 2, order2.orders.size());
        // gets the first test item we added and asserts its the same
        // Note that the indexes are 0 ordered so the size of
        // order1 is the index of our first testOrder
        assertEquals(order2.orders.get(order1.orders.size()), testOrder1);
        // Same for testOrder2
        assertEquals(order2.orders.get(order1.orders.size()+1), testOrder2);

        // Removing testOrder1
        assertTrue(WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder1, firstDayOfWeek));

        // assert that the new weekly order only has test2
        WeeklyOrder order3 = WeeklyOrdersManager.getWeeklyOrder(firstDayOfWeek);
        assertEquals(order3.orders.size(), 1);
        assertEquals(order3.orders.get(0), testOrder2);

        // remove testOrder2
        assertTrue(WeeklyOrdersManager.removeOrderInWeeklyOrder(testOrder2, firstDayOfWeek));

        // Get new order
        WeeklyOrder order4 = WeeklyOrdersManager.getWeeklyOrder(firstDayOfWeek);


        // assert that the new weekly order is empty
        assertEquals(order4.orders.size(), 0);

    }


}
