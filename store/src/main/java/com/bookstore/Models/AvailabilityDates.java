package com.bookstore.Models;

import java.util.Objects;

public class AvailabilityDates {
    public String availabilityID;
    public Days day;
    public String accountID;

    /**
     * @param availabilityID
     * @param day
     * @param accountID
     */
    public AvailabilityDates(String availabilityID, Days day, String accountID) {
        this.availabilityID = availabilityID;
        this.day = day;
        this.accountID = accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityDates that = (AvailabilityDates) o;
        return availabilityID.equals(that.availabilityID) &&
            day == that.day &&
            accountID.equals(that.accountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availabilityID, day, accountID);
    }
}
