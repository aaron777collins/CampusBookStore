package com.bookstore.Models;

public class Schedule{
    
    
    @Override
    public String toString() {
        return "Schedule [shift=" + shift + ", accountID=" + accountID + ", day=" + day + "]";
    }
    public Shift shift;
    public String accountID;
    public String day;
    public Schedule(Shift shift, String accountID, String day) {
        this.shift = shift;
        this.accountID = accountID;
        this.day = day;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((shift == null) ? 0 : shift.hashCode());
        result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Schedule other = (Schedule) obj;
        if (shift == null) {
            if (other.shift != null)
                return false;
        } else if (!shift.equals(other.shift))
            return false;
        if (accountID == null) {
            if (other.accountID != null)
                return false;
        } else if (!accountID.equals(other.accountID))
            return false;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        return true;
    }

        

    }
    

    /** 
     * @param shift contains shift start and end time 
     * @param employeName name of employee
     * @param day day of week
    */

