package com.playerData;

import java.util.Random;

public class Player {
    private final String  name;
    public float health;
    private float def;
    public Weapon weapon;
    public Armor armor;

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
        if (this.weapon == null) {
            System.out.println(this.name + " can't attack because isn't equip any weapon");
            return;
        }

        if(this.health != 0) {
            int damage = rand.nextInt(weapon.weaponDamage + 1);
            opponent.health -= damage;

            System.out.println(this.name + " Attacking " + opponent.name + " With " + damage + "ATK");
            System.out.println(opponent.name + "'s health : " + opponent.health);
        }

    }

    public void defend() {
        if (this.armor != null) {
            int addDef = armor.use();
            def += addDef;
            System.out.println(this.name + " chooses to defend and gains additional defense");
        }
        System.out.println(this.name + "'s health : " + this.health);
    }

    public void healing() {

        int healthVal = rand.nextInt(20) + 1;
        this.health += healthVal;

        System.out.println(this.name + " Healing...");
        System.out.println(this.name + " Gains health : " + healthVal);
        System.out.println(this.name + "'s health : " + health);
    }
}
