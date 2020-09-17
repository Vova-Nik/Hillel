package com.nikolenko.homeworks.homework_04;

/**
 * • Write a class StringUtils which has one static method
 * randomString. This method takes two params: String type
 * and int length.
 * • Method would return new string of given length and
 * containing random symbols of given type.
 * • Types: alpha (only letters), numeric
 */

public class StringUtils {
    public static String randomString(int len, String type) {
        StringBuilder sb = new StringBuilder();
        if(len <=0){
            type = "ilegal length";
        }
        switch (type) {
            case "alpha":
                for (int i = 0; i < len; i++) {
                    sb.append(getAlpha());
                }
                break;
            case "numeric":
                for (int i = 0; i < len; i++) {
                    sb.append(getNumeric());
                }
                break;
            case "alphanumeric":
                for (int i = 0; i < len; i++) {
                    sb.append(getAlphanumeric());
                }
                break;
            case "ilegal length":
                sb.append("Length = ").append(len).append(" - is not a valid type");
                break;

            default:
                sb.append("\"").append(type).append("\"").append(" - is not valid");
                break;
        }
        return sb.toString();
    }

    private static int getRand(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static char getAlpha() {
        char[] cha = alpha.toCharArray();
        return cha[getRand(0, cha.length)];
    }

    private static char getNumeric() {
        char[] cha = numeric.toCharArray();
        return cha[getRand(0, cha.length)];
    }

    private static char getAlphanumeric() {
        char[] cha = alphanumeric.toCharArray();
        return cha[getRand(0, cha.length)];
    }

    private static String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static String numeric = "1234567890";
    private static String alphanumeric = "abcdefghijklmnopqrstuvwxyz1234567890";
}
