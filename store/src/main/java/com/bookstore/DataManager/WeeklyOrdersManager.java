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

    public static boolean insertOrderInWeeklyOrder(Order order, Calendar sendDate) {

        WeeklyOrder currentweek = getWeeklyOrder(sendDate);

        currentweek.orders.add(order);
        return MongoConnector.RemoveMany(eq("sendDate", sendDate.getTime()), WEEKLY_ORDERS_COLLECTION_NAME)
        && MongoConnector.InsertClass(currentweek, WEEKLY_ORDERS_COLLECTION_NAME);

    }
    public static boolean removeOrderInWeeklyOrder(Order order, Calendar sendDate) {

        WeeklyOrder currentweek = getWeeklyOrder(sendDate);

        currentweek.orders.remove(order);

        return MongoConnector.RemoveMany(eq("sendDate", sendDate.getTime()), WEEKLY_ORDERS_COLLECTION_NAME)
        && MongoConnector.InsertClass(currentweek, WEEKLY_ORDERS_COLLECTION_NAME);

    }

    public static WeeklyOrder getWeeklyOrder(Calendar sendDate) {

        List<WeeklyOrder> weeklyOrders =  MongoConnector.GetClassResultsWithFilter(WeeklyOrder.class, eq("sendDate", sendDate.getTime()), WEEKLY_ORDERS_COLLECTION_NAME);

        WeeklyOrder currentweek;

        if (weeklyOrders.size() == 0) {
            // Order doesn't exist so we make one and insert it
            currentweek = new WeeklyOrder(new ArrayList<Order>(), sendDate);
            if(!(MongoConnector.InsertClass(currentweek, WEEKLY_ORDERS_COLLECTION_NAME))) {
                // if it cannot insert new week
                System.err.println("Could not insert new weekly order!");
            }
        } else {
            currentweek = weeklyOrders.get(0);
        }


        return currentweek;
    }

}
