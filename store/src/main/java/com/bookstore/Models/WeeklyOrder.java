package com.bookstore.Models;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class WeeklyOrder {

    public List<Order> orders;
    public Date sendDate;

    public WeeklyOrder() {
    }


    /**
     * @param orders
     * @param sendDate
     */
    public WeeklyOrder(List<Order> orders, Date sendDate) {
        this.orders = orders;
        this.sendDate = sendDate;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orders == null) ? 0 : orders.hashCode());
        result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeeklyOrder other = (WeeklyOrder) obj;
        if (orders == null) {
            if (other.orders != null)
                return false;
        } else if (!orders.equals(other.orders))
            return false;
        if (sendDate == null) {
            if (other.sendDate != null)
                return false;
        } else if (!sendDate.equals(other.sendDate))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "WeeklyOrder [orders=" + orders + ", sendDate=" + sendDate + "]";
    }


}
