package com.nikolenko.homeworks.homework_17;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsersDownloaderTest {
    static UsersDownloader usersDownloader = null;

    @BeforeAll
    public static void setup(){
        usersDownloader = new UsersDownloader();
    }

    @Test
    void getRawData() {
        assertTrue(usersDownloader.getSise() > 0);
        System.out.println(usersDownloader.getSise());
        assertTrue(usersDownloader.getRawData().contains("Leanne Graham"));
    }

    @Test
    void getBody() {
        assertTrue(usersDownloader.getBody().contains("Leanne Graham"));
        assertFalse(usersDownloader.getBody().contains("Content-Type:"));
    }
}

