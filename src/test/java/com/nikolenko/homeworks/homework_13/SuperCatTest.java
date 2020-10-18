package com.nikolenko.homeworks.homework_13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SuperCatTest {

    static SuperCat superCat;
    static SuperMouse[] superMouses;

    @BeforeAll
    static void init() {
        superCat = new SuperCat();
        superMouses = new SuperMouse[6];
        superMouses[0] = new SuperMouse("Ed", 200);
        superMouses[1] = new SuperMouse("Jerry", 460);
        superMouses[2] = new SuperMouse("Jerry", 560);
        superMouses[3] = new SuperMouse("Al", 250);
        superMouses[4] = new SuperMouse("Nik", 300);
        superMouses[5] = new SuperMouse("Bill", 360);
    }

    @Test
    void eat() {
        for (int i = 0; i < 5; i++) {
            assertTrue(superCat.eat(superMouses[i]));
        }
        assertFalse(superCat.eat(superMouses[5]));
        System.out.println(superCat);
    }

    @Test
    void unEat() {
        for (int i = 0; i < 5; i++) {
            assertTrue(superCat.eat(superMouses[i]));
        }
        SuperMouse sm = superCat.unEat();
        assertEquals(new SuperMouse("Ed", 200), sm);
        sm = superCat.unEat();
        assertEquals(new SuperMouse("Al", 250), sm);
        sm = superCat.unEat();
        assertEquals( new SuperMouse("Nik", 300), sm);
        sm = superCat.unEat();
        assertEquals(new SuperMouse("Jerry", 460), sm);
        sm = superCat.unEat();
        assertEquals( new SuperMouse("Jerry", 560), sm);
    }

    @Test
    void drain() {
        for (int i = 0; i < 6; i++) {
            superCat.eat(superMouses[i]);
        }
        HashSet<SuperMouse> sm = superCat.drain();
        System.out.println(sm);
        assertTrue(sm.contains(new SuperMouse("Jerry", 460)));
        assertFalse(sm.contains(new SuperMouse("Jerry", 455)));
        assertFalse(sm.contains(new SuperMouse("Jer", 460)));
    }
}