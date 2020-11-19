package com.nikolenko.homeworks.homework_12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    static Cat cat;
    static Mouse[] mouses;

    @BeforeAll
    static void init() {
        cat = new Cat();
        mouses = new Mouse[6];
        mouses[0] = new Mouse("Ed", 200);
        mouses[1] = new Mouse("Jerry", 460);
        mouses[2] = new Mouse("Jerry", 560);
        mouses[3] = new Mouse("Al", 250);
        mouses[4] = new Mouse("Nik", 300);
        mouses[5] = new Mouse("Bill", 360);
    }

    @Test
    void eat() {
        for (int i = 0; i < 5; i++) {
            assertTrue(cat.eat(mouses[i]));
        }
        assertFalse(cat.eat(mouses[5]));
        System.out.println(cat);
    }

    @Test
    void unEat() {
        for (int i = 0; i < 5; i++) {
            cat.eat(mouses[i]);
        }
        System.out.println(cat);
        cat.unEat();
        Mouse first = cat.getStomach().peek();
        assertEquals(first, mouses[1]);
        System.out.println(cat);
        for (int i = 0; i < 10; i++) {
            cat.unEat();
        }
        System.out.println(cat);
    }

    @Test
    void drain() {
        for (int i = 0; i < 5; i++) {
            cat.eat(mouses[i]);
        }
        List<Mouse> mouseList = cat.drain();
        System.out.println(mouseList);
        assertTrue(mouseList.contains(new Mouse("Jerry", 460)));
        for (int i = 0; i < 5; i++) {
            cat.eat(mouses[i]);
        }
        cat.unEat();
        cat.unEat();
        mouseList = cat.drain();
        System.out.println(mouseList);
        assertFalse(mouseList.contains(new Mouse("Jerry", 460)));
    }

    @Test
    void drainStream() {
        long counter;
        for (int i = 0; i < 5; i++) {
            cat.eat(mouses[i]);
        }
        List<Mouse> mouseList = cat.drain();
         counter = mouseList.stream()
                .filter(mouse -> mouse.equals(new Mouse("Jerry", 460)))
                .count();
        assertEquals(1, counter);
        for (int i = 0; i < 5; i++) {
            cat.eat(mouses[i]);
        }
        cat.unEat();
        cat.unEat();
        mouseList = cat.drain();
         counter = mouseList.stream()
                .filter(mouse -> mouse.equals(new Mouse("Jerry", 460)))
                .count();
        assertEquals(0, counter);
    }
}