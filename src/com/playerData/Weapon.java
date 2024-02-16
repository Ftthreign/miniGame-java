package com.playerData;

import java.util.Random;

public class Weapon extends Item {
    int weaponDamage;

    /**
     *
     * @param itemName - this is implementation of abstraction class Item and can be use public
     * @param weaponDamage - this is value of weapon damage
     */
    public Weapon(String itemName, int weaponDamage) {
        super(itemName);
        this.weaponDamage = weaponDamage;
    }

    @Override
    int use() {
        Random rand = new Random();
        return rand.nextInt(weaponDamage) + 1;
    }

    void showDetails() {
        System.out.println("Weapon name : " + this.itemName);
        System.out.println("Weapon damage : " + this.weaponDamage);
    }
}
