package com.playerData;

public class Armor extends Item{
    int armorDef;

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
