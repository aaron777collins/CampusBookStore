package com.bookstore.Models;

import java.time.LocalTime;
import java.util.Objects;

public class AvailabilityDates {
    public String availabilityID;
    public Days day;
    public String accountID;
    public LocalTime startTime;
    public LocalTime endTime;

    /**
     * @param availabilityID
     * @param day
     * @param accountID
     * @param startTime
     * @param endTime
     */
    public AvailabilityDates(String availabilityID, Days day, String accountID, LocalTime startTime, LocalTime endTime) {
        this.availabilityID = availabilityID;
        this.day = day;
        this.accountID = accountID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityDates that = (AvailabilityDates) o;
        return availabilityID.equals(that.availabilityID) &&
            day == that.day &&
            accountID.equals(that.accountID) &&
            startTime.equals(that.startTime) &&
            endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availabilityID, day, accountID, startTime, endTime);
    }
}
