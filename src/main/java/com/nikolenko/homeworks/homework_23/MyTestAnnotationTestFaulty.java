package com.nikolenko.homeworks.homework_23;
import static org.junit.jupiter.api.Assertions.*;

public class MyTestAnnotationTestFaulty {

    @MyTest
    public void erroredTest() {
        fail();
    }
}
