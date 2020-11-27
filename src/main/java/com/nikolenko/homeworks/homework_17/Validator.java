package com.nikolenko.homeworks.homework_17;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public static boolean validate(String toCheck) {
        AtomicBoolean result = new AtomicBoolean(true);
        Deque<Integer> bracketsStack = new LinkedList<>();

        HashSet<Integer> openingBrackets = new HashSet<>();
        openingBrackets.add((int) '[');
        openingBrackets.add((int) '{');

        HashSet<Integer> clozingBrackets = new HashSet<>();
        clozingBrackets.add((int) '}');
        clozingBrackets.add((int) ']');

        Map<Integer, Integer> bracketPairs = new HashMap<>();
        bracketPairs.put((int) ']', (int) '[');
        bracketPairs.put((int) '}', (int) '{');

        int[] ch = toCheck.chars()
                .filter(c -> openingBrackets.contains(c) || clozingBrackets.contains(c))
                .peek(c -> {
                            if (openingBrackets.contains(c)) {
                                bracketsStack.push(c);
                                return;
                            }
                            if (clozingBrackets.contains(c)) {
                                if (bracketsStack.size() == 0) {
                                    result.set(false);
                                    return;
                                }
                                if (!bracketsStack.pop().equals( bracketPairs.get(c))) {
                                    result.set(false);
                                }
                            }
                        }
                )
                .toArray();
        return result.get();
    }
}
