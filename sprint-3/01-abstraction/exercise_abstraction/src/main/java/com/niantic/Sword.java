package com.niantic;

public class Sword extends Weapon {
    private int daggerCount;


    public Sword(String name, int damage, int daggerCount) {
        super(name, damage);
        this.daggerCount = daggerCount;
    }

    @Override
    public int attack() {

        if (percentCharged < 100) {
            percentCharged += 10;
            if (percentCharged > 100) {
                percentCharged = 100;
            }
        }
        return getDamage();
    }

    @Override
    public int powerAttack() {
        if (percentCharged < 50) {

            return attack();
        } else if (percentCharged >= 50 && percentCharged < 100) {

            percentCharged -= 50;
            return getDamage() * 2;
        } else if (percentCharged == 100) {

            percentCharged = 0;
            return getDamage() * 4;
        }
        return getDamage();
    }

    @Override
    public int getRange() {
        return 1;
    }

    public int getDaggerCount() {
        return daggerCount;
    }
}

