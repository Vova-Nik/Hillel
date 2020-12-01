package com.nikolenko.homeworks.homework_23;

<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
=======
>>>>>>> hw24
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
@Slf4j
=======
>>>>>>> hw24
class TestRunnerTest {

    @Test
    void zeroArgs() {
        TestRunner.main(new String[0]);
        assertNull(TestRunner.getTestClassName());
    }

    @Test
    void oneArg() {
        TestRunner.main(new String[]{"MyTestAnnotationTestFaulty"});
        assertEquals("com.nikolenko.homeworks.homework_23.MyTestAnnotationTestFaulty", TestRunner.getTestClassName());
    }

    @Test
    void twoArgs() {
        TestRunner.main(new String[]{"MyTestAnnotationTestFaulty", "com.nikolenko.homeworks.homework_23"});
        assertEquals("com.nikolenko.homeworks.homework_23.MyTestAnnotationTestFaulty", TestRunner.getTestClassName());
    }

    @Test
    void noErrorCase() {
        TestRunner.main(new String[]{"MyTestAnnotationTest"});
        assertEquals("com.nikolenko.homeworks.homework_23.MyTestAnnotationTest", TestRunner.getTestClassName());
        assertTrue(TestRunner.getresult());
    }

    @Test
    void errorInTestsCase() {
        TestRunner.main(new String[]{"MyTestAnnotationTestFaulty"});
        assertEquals("com.nikolenko.homeworks.homework_23.MyTestAnnotationTestFaulty", TestRunner.getTestClassName());
        assertFalse(TestRunner.getresult());
    }

}