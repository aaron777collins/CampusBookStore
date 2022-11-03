package com.bookstore.DataManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bookstore.DataStream.MongoConnector;
import com.bookstore.Helpers.CalendarHelper;
import com.bookstore.Models.Order;
import com.bookstore.Models.WeeklyOrder;
import static com.mongodb.client.model.Filters.eq;

public class WeeklyOrdersManager {

    public static final String WEEKLY_ORDERS_COLLECTION_NAME = "WeeklyOrders";

    public static boolean insertOrderInWeeklyOrder(Order order) {

        Calendar firstDayOfWeek = CalendarHelper.getFirstDayOfWeek();
        List<WeeklyOrder> weeklyOrders = MongoConnector.GetClassResultsWithFilter(WeeklyOrder.class, eq("sendDate", firstDayOfWeek), WEEKLY_ORDERS_COLLECTION_NAME);

        WeeklyOrder currentweek;

        if (weeklyOrders.size() == 0) {
            currentweek = new WeeklyOrder(new ArrayList<Order>(), firstDayOfWeek);
        } else {
            currentweek = weeklyOrders.get(0);
        }

        currentweek.orders.add(order);
        return MongoConnector.RemoveMany(eq("sendDate", firstDayOfWeek), WEEKLY_ORDERS_COLLECTION_NAME)
        && MongoConnector.InsertClass(currentweek, WEEKLY_ORDERS_COLLECTION_NAME);

    }

}
