package com.playerData;

public abstract class Item {
    String itemName;

    public  Item(String item) {
        this.itemName = item;
    }

    abstract  int use();
}
