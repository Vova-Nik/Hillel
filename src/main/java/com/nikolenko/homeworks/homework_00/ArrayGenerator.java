package com.nikolenko.homeworks.homework_00;

public class ArrayGenerator {

    public int[] giveIntArray() {
        int[] intArray = new int[8];
        for (int i = 0; i < 8; i++) {
            Double dd = (Math.random() * 10);
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    public int[] giveIntArray(int size) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            Double dd = (Math.random() * 100);
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    public int[] giveIntArray(int size, int min, int max) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            Double dd = min + (Math.random() * ((max - min) + 1));
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    public String giveString() {
        boolean hastaInserted = false;
        String[] first = {"New", "Old", "Young", "Grey", "First", "Red", "Crasy", "Smart", "Nice", "lazy"};
        String[] second = {"man", "woman", "fox", "dog", "rabbit", "fellow", "body", "baby", "cat", "cow", "girl", "bunny"};
        String[] third = {"runs", "goes", "wants", "is going", "is jumping", "aims", "wants"};
        String[] fourth = {"city", "river", "casino", "city main street", "west", "east", "to our town", "to village", "cafe", "sunny beach", "park", "grocery", "music shop", "Sherwood forest", "white house", "bare mountain"};
        int firstLength = first.length;
        int secondLength = second.length;
        int thirdLength = third.length;
        int fourthLength = fourth.length;
        int firstPhraseNum = (int) (Math.random() * (firstLength + 1));
        int secondPhraseNum = (int) (Math.random() * (secondLength + 1));
        int thirdPhraseNum = (int) (Math.random() * (thirdLength + 1));
        int fourthPhraseNum = (int) (Math.random() * (fourthLength + 1));
        if(!hastaInserted) {
            int rnd = (int) (Math.random() * 50);
            if ( rnd == 23 || rnd == 45) {
                hastaInserted = true;
                return "Hasta la vista, baby";
            }
        }
        return first[firstPhraseNum] + " " + second[secondPhraseNum] + " " + third[thirdPhraseNum] + " " + fourth[fourthPhraseNum];
    }

    public String[] giveStringArray(int len) {
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = giveString();
        }
        return result;
    }
}
