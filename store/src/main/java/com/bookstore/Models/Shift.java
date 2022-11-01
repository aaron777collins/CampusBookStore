package com.bookstore.Models;

import java.util.Date;

public class Shift{
    @Override
    public String toString() {
        return "Shift [start=" + start + ", end=" + end + "]";
    }
    Date start;
    Date end;


    /**
     * @param start start time of shift
     * @param end end time of shift
     */
}