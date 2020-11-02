package com.nikolenko.homeworks.homework_17;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    static UsersDownloader usersDownloader = null;

    @BeforeAll
    public static void setup(){
        usersDownloader = new UsersDownloader();
    }

    @Test
    void validateBracketsHappy() {
        String toCheck = usersDownloader.getBody();
        assertTrue(Validator.validateBrackets("[]{}"));
        assertTrue(Validator.validateBrackets("[[11]sfgdh]{{fh}jg}"));
        assertTrue(Validator.validateBrackets("[{ }]"));
        assertTrue(Validator.validateBrackets("fdhsgfdshfhdsaigure8utgiajias 3627b"));

        assertTrue(Validator.validateBrackets(toCheck));
    }

    @Test
    void validateBracketsUnHappy() {
        assertFalse(Validator.validateBrackets("}]"));
        assertFalse(Validator.validateBrackets("[{{{}"));
        assertFalse(Validator.validateBrackets("[{ {{{}]}{}} }"));

        String toCheck = usersDownloader.getBody();
        StringBuilder corrupted = new StringBuilder(toCheck);
        corrupted.insert(toCheck.length()/2,"]");
        assertFalse(Validator.validateBrackets(corrupted.toString()));
    }
}
