package com.bookstore.Models;

import java.util.List;

public class Order {
    public String accountID;
    public String orderID;
    public List<Item> items;

    public Order() {

    }

    /**
     * @param accountID The account of the user
     * @param orderID The order of the user
     * @param items the items in the order
     */
    public Order(String accountID, String orderID, List<Item> items) {
        this.accountID = accountID;
        this.orderID = orderID;
        this.items = items;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
        result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
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
        Order other = (Order) obj;
        if (accountID == null) {
            if (other.accountID != null)
                return false;
        } else if (!accountID.equals(other.accountID))
            return false;
        if (orderID == null) {
            if (other.orderID != null)
                return false;
        } else if (!orderID.equals(other.orderID))
            return false;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Order [accountID=" + accountID + ", orderID=" + orderID + ", items=" + items + "]";
    }


}
