package com.playerData;

import java.util.Random;

public class Player {
    private final String  name;
    private float health;
    private float def;
    private Weapon weapon;
    private Armor armor;

    private final static Random rand = new Random();

    /**
     *
     * @param name - for name of Hero
     * @param health - for health of Hero
     * @param def - for defence of Hero
     */
    public Player(String name, float health, float def) {
        this.name = name;
        this.health = health;
        this.def = def;
    }

    // Getter
    public float getHealth() {
        return this.health;
    }

    // Getter
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void defend() {
        if (this.armor != null) {
            int addDef = armor.use();
            def += addDef + (float) 0.5 * this.health;
            System.out.println(this.name + " chooses to defend and gains additional defense");
        }
        System.out.println(this.name + "'s health : " + def);
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

    static public void displayChoice() {
        System.out.println("Choose the action : ");
        System.out.println("1. Attack");
        System.out.println("2. Defence");
        System.out.println("3. Healing");
        System.out.println("4. See Player's details");
    }

    public void healing() {

        int healthVal = rand.nextInt(20) + 1;
        this.health += healthVal;

        System.out.println(this.name + " Healing...");
        System.out.println(this.name + " Gains health : " + healthVal);
        System.out.println(this.name + "'s health : " + health);
    }
}
