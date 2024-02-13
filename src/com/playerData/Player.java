package com.playerData;

import java.util.Random;

public class Player {
    String name;
    public float health;
    float def;
    Weapon weapon;
    Armor armor;

    static Random rand = new Random();

    public Player(String name, float health, float def) {
        this.name = name;
        this.health = health;
        this.def = def;
    }

    public void equipWeap(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public void showDetails() {
        System.out.println("Player's Name : " + this.name);
        System.out.println("Health : " + this.health);
        System.out.println("Def : " + this.def);
        armor.showDetails();
        weapon.showDetails();
    }

    public void attack(Player opponent) {
        if (weapon == null) {
            System.out.println(this.name + " can't attack because isn't equip any weapon");
            return;
        }


        int damage = rand.nextInt(weapon.weaponDamage + 1);

        opponent.health -= damage;

        System.out.println(name + " Attacking " + opponent.name + " With " + damage + "ATK");
        System.out.println(opponent.name + "'s health : " + opponent.health);
    }

    public void defend() {
        if (armor != null) {
            int addDef = armor.use();
            def += addDef;
            System.out.println(name + " chooses to defend and gains additional defense");
        }
        System.out.println(name + "'s health : " + health);
    }

    public void healing() {

        int healthVal = rand.nextInt(20) + 1;
        health += healthVal;

        System.out.println(name + " Healing...");
        System.out.println(name + " Gains health : " + healthVal);
        System.out.println(name + "'s health : " + health);
    }
}
