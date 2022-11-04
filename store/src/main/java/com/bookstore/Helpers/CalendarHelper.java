package com.bookstore.Helpers;

import java.util.Calendar;
import java.util.Date;

public class CalendarHelper {
    public static Calendar getFirstDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return getFirstDayOfWeek(calendar);
    }
    public static Calendar getFirstDayOfWeek(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        return calendar;
    }
    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
      }
}
