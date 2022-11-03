package com.bookstore.Helpers;

import java.util.Calendar;

public class CalendarHelper {
    public static Calendar getFirstDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        return calendar;
    }
}
