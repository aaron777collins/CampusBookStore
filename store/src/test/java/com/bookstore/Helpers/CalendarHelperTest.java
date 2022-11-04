package com.bookstore.Helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class CalendarHelperTest {
    @Test
    void testGetFirstDayOfWeek() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-01-01 00:00:00");
        Calendar cal = CalendarHelper.toCalendar(date);
        Calendar firstDayOfWeek = CalendarHelper.getFirstDayOfWeek(cal);
        assertEquals(firstDayOfWeek.getTime().toString(), "Sun Dec 26 00:00:00 EST 2021");
    }

    @Test
    void testGetFirstDayOfWeekAutomatic() {
        Calendar calendar = Calendar.getInstance();
        assertEquals(
            CalendarHelper.getFirstDayOfWeek().getTime().toString(),
            CalendarHelper.getFirstDayOfWeek(calendar).getTime().toString()
            );
    }

    @Test
    void testToCalendar() {
        Date date = new Date();
        Calendar res = CalendarHelper.toCalendar(date);
        assertEquals(date.toString(), res.getTime().toString());
    }
}
