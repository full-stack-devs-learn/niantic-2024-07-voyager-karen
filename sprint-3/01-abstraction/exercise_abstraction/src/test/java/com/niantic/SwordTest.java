package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    private Sword sword;

    @BeforeEach
    void setUp() {
        sword = new Sword("Blade Cloak", 10, 3);
    }

    @Test
    void testAttack() {
        assertEquals(10, sword.attack());
        assertEquals(10, sword.getPercentCharged());
    }

    @Test
    void testPowerAttackWithLowCharge() {
        assertEquals(10, sword.attack());
        assertEquals(10, sword.getPercentCharged());
        assertEquals(10, sword.powerAttack());
    }

    @Test
    void testPowerAttackWithMidCharge() {

        sword.attack();
        sword.attack();
        sword.attack();
        sword.attack();
        sword.attack();
        assertEquals(50, sword.getPercentCharged());

        assertEquals(20, sword.powerAttack());
        assertEquals(0, sword.getPercentCharged());
    }

    @Test
    void testPowerAttackWithFullCharge() {

        for (int i = 0; i < 10; i++) {
            sword.attack();
        }
        assertEquals(100, sword.getPercentCharged());

        assertEquals(40, sword.powerAttack());
        assertEquals(0, sword.getPercentCharged());
    }

    @Test
    void testGetRange() {
        assertEquals(1, sword.getRange());
    }
}

