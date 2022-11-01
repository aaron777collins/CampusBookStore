package com.bookstore.Models;

public class Item {
    public String name;
    public float price;
    public String itemID;
    public ItemType itemType;
    /**
     * @param name The name of the item
     * @param price The price of the item
     * @param itemID The ID of the item
     * @param itemType The type of the item
     */
    public Item(String name, float price, String itemID, ItemType itemType) {
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.itemType = itemType;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
        result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
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
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        if (itemID == null) {
            if (other.itemID != null)
                return false;
        } else if (!itemID.equals(other.itemID))
            return false;
        if (itemType != other.itemType)
            return false;
        return true;
    }
}
