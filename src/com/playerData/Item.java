package com.playerData;

public abstract class Item {
    String itemName;

    /**
     *
     * @param item - the item name that will be inherited to subclass or child class
     */
    public  Item(String item) {
        this.itemName = item;
    }

    /**
     *
     * @return - this is will be return the value of implementation on the subclass
     */
    abstract  int use();
}
