package com.nikolenko.homeworks.homework_17;

import java.util.*;

public class Validator {
    public static boolean validateBrackets(String toCheck) {
        char[] charsArrToCheck = toCheck.toCharArray();

        HashSet<Character> openingBrackets = new HashSet<>();
        openingBrackets.add('[');
        openingBrackets.add('{');

        HashSet<Character> clozingBrackets = new HashSet<>();
        clozingBrackets.add('}');
        clozingBrackets.add(']');

        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');

        Deque<Character> bracketsStack = new LinkedList<>();
        for (char ch : charsArrToCheck) {
            if (openingBrackets.contains(ch)) {
                bracketsStack.push(ch);
                continue;
            }
            if (clozingBrackets.contains(ch)) {
                if (bracketsStack.size() == 0) {
                    return false;
                }

                if (bracketsStack.pop() != bracketPairs.get(ch)) {
                    return false;
                }
            }
        }
        return bracketsStack.size() == 0;
    }
}
