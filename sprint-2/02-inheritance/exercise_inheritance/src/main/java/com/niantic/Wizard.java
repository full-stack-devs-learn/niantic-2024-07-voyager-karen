package com.niantic;

public class Wizard extends Character

{

    private int mana;

    public Wizard(String name, int health, int level, int experience, int mana) {

        super(name, health, level, experience);

        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }


    public void castSpell(Character target) {

        if(mana >= 10)
        {
            super.attack(target);
            super.attack(target);
            mana-=10;
        }

    }

    public void regenerateMana(int amount) {

        if(!isDefeated())
        {
            mana += amount;
        }

    }

    @Override
    public void levelUp() {

        super.levelUp();
        if(!isDefeated()) {
            mana+=10;
        }
    }

    @Override
    public String specialAbility() {
        return "Cast Spells";
    }

}








