package com.nikolenko.homeworks.homework_21;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ThreadTurnTest {
    @Test
    void threadTurnTest() {
        ThreadTurn threadTurn = new ThreadTurn();
        String result = threadTurn.proceed();
        log.info(result);
        assertTrue(result.contains("ThreadTurnRunner_0"));
        assertTrue(result.contains("ThreadTurnRunner_1"));
        assertTrue(result.contains("ThreadTurnRunner_2"));
        assertTrue(result.contains("ThreadTurnRunner_3"));
        assertTrue(result.contains("ThreadTurnRunner_4"));
        assertTrue(result.contains("ThreadTurnRunner_5"));
        assertTrue(result.contains("ThreadTurnRunner_6"));
        assertTrue(result.contains("ThreadTurnRunner_7"));
        assertTrue(result.contains("ThreadTurnRunner_8"));
        assertTrue(result.contains("ThreadTurnRunner_9"));
    }
}