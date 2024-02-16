package com.playerData;

public class Armor extends Item{
    int armorDef;

    /**
     *
     * @param itemName - this is implementation of abstraction class Item and can be use public
     * @param armorDef - this is value of defence power of defence item like armor, helmet, and etc.
     */
    public  Armor(String itemName, int armorDef) {
        super(itemName);
        this.armorDef = armorDef;
    }

    @Override
    int use() {
        return  armorDef;
    }

    void showDetails() {
        System.out.println("Armor name : " + this.itemName);
        System.out.println("Armor defence : " + this.armorDef);
    }
}
