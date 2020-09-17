package com.nikolenko.homeworks.homework_04;

/**
 * Generator of different values and sequences for studding purposes
 * <p>
 * int giveInt() - returns random positiv int number
 * public int giveInt(int min, int max) - returns random  int number between min and max
 * public int[] giveIntArray() - returns random int array of int length 8
 * public int[] giveIntArray(int size)
 * public int[] giveIntArray(int size, int min, int max) - returns random int array of int length = size, values restricted to min-max
 * public String giveString() - returns random string
 * public String[] giveStringArray(int len) - returns random String array  length = len
 * public String loremPlain(int len) - Forms simply lorem type string. Lovercased, without punctuation of length = len words
 * public String lorem(int len) - Forms complex string including punctuations, capital letters ets, like real text
 */

public class InputGenerator {
    static boolean hastaInserted = false;

    /*returns random positiv int number*/
    public int giveInt() {
        Double numd = (Math.random() * Integer.MAX_VALUE);
        return numd.intValue();
    }

    /*returns random  int number between min and max*/
    public int giveInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int giveStrong() {
        int[] inpData = {1, 2, 145, 145, 40585, 40585, 40585};
        return inpData[giveInt(0, (inpData.length - 1))];
    }

    /*returns random int array of int length 8*/
    public int[] giveIntArray() {
        int[] intArray = new int[8];
        for (int i = 0; i < 8; i++) {
            Double dd = (Math.random() * 10);
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    /*returns random int array of int length = size*/
    public int[] giveIntArray(int size) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            Double dd = (Math.random() * 100);
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    /*returns random int array of int length = size, values restricted to min-max */
    public int[] giveIntArray(int size, int min, int max) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            Double dd = min + (Math.random() * ((max - min) + 1));
            intArray[i] = dd.intValue();
        }
        return intArray;
    }

    /*returns random string */
    public String giveString() {
        String[] first = {"New", "Old", "Young", "Grey", "First", "Red", "Crazy", "Smart", "Nice", "lazy"};
        String[] second = {"man", "woman", "fox", "dog", "rabbit", "fellow", "body", "baby", "cat", "cow", "girl", "bunny", "animal", "horse"};
        String[] third = {"runs", "goes", "wants", "is going", "is jumping", "aims", "wants"};
        String[] fourth = {"city", "river", "casino", "city main street", "west", "east", "to our town", "to village", "cafe", "sunny beach", "park", "grocery", "music shop", "Sherwood forest", "white house", "bare mountain"};
        int firstLength = first.length;
        int secondLength = second.length;
        int thirdLength = third.length;
        int fourthLength = fourth.length;
        int firstPhraseNum = (int) (Math.random() * (firstLength));
        int secondPhraseNum = (int) (Math.random() * (secondLength));
        int thirdPhraseNum = (int) (Math.random() * (thirdLength));
        int fourthPhraseNum = (int) (Math.random() * (fourthLength));
        if (!hastaInserted) {
            int rnd = (int) (Math.random() * 50);
            if (rnd == 23 || rnd == 45) {
                hastaInserted = true;
                return "Hasta la vista, baby";
            }
        }
        return first[firstPhraseNum] + " " + second[secondPhraseNum] + " " + third[thirdPhraseNum] + " " + fourth[fourthPhraseNum];
    }

    /*returns random String array  length = len*/
    public String[] giveStringArray(int len) {
        String[] result = new String[len];
        hastaInserted = false;
        for (int i = 0; i < len; i++) {
            result[i] = giveString();
        }
        return result;
    }

    /*Forms simply lorem type string. Lovercased, without punctuation of length = len words*/
    public String loremPlain(int len) {
        String[] words = base.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            Double indexd = (Math.random() * words.length);
            int index = indexd.intValue();
            result.append(words[index]).append(" ");
        }
        return result.toString();
    }

    /*Forms complex string including punctuations, capital letters ets, like real text*/
    //Not finished yet
    public String lorem(int len) {
        String[] words = base.split("\\s+");
        String[] resultArr = new String[len];

        for (int i = 0; i < len; i++) {
            Double indexd = (Math.random() * words.length);
            int index = indexd.intValue();
            resultArr[i] = words[index];
        }
        resultArr[0] = firstUpperCase(resultArr[0]);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(resultArr[i]).append(" ");
        }
        return result.toString();
    }

    private String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private String base =
            "lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua" +
                    " sapien pellentesque habitant morbi tristique senectus et netus phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis" +
                    " nunc scelerisque viverra mauris in aliquam cursus mattis molestie a iaculis" +
                    " sed odio morbi quis commodo odio aenean sed adipiscing diam suspendisse in est ante in" +
                    " sed vulputate mi sit amet mauris commodo quis sodales neque sodales ut etiam sit amet nisl" +
                    " nisl tincidunt eget nullam non nisi dictum sit amet justo donec enim diam vulputate ut pharetra" +
                    " morbi tristique senectus et netus et sit amet est placerat in egestas erat imperdiet sed euismod" +
                    " nunc mattis enim ut tellus elementum sagittis vitae et suspendisse interdum consectetur libero id" +
                    " cursus euismod quis viverra nibh cras pulvinar mattis nunc sed" +
                    " ante in nibh mauris cursus mattis molestie a iaculis in metus vulputate eu scelerisque" +
                    " adipiscing elit duis tristique sollicitudin nibh sit malesuada pellentesque elit eget gravida cum sociis" +
                    " posuere lorem ipsum dolor sit amet consectetur risus quis varius quam quisque id diam vel quam elementum" +
                    " mattis enim ut tellus elementum sagittis vitae et curabitur vitae nunc sed velit dignissim sodales ut" +
                    " morbi tincidunt augue interdum velit turpis massa tincidunt dui ut ornare lectus sit" +
                    " donec massa sapien faucibus et molestie ac in massa tempor nec feugiat nisl pretium" +
                    " eget sit amet tellus cras Gravida quis blandit turpis cursus in hac" +
                    " dui sapien eget mi proin sed libero enim sed faucibus" +
                    " turpis massa sed elementum tempus egestas sed rhoncus aenean vel elit scelerisque mauris pellentesque" +
                    " cum sociis natoque penatibus et magnis dis parturient a cras semper auctor neque vitae" +
                    " aliquam ultrices sagittis orci a scelerisque purus semper eget duis at erat pellentesque adipiscing commodo elit" +
                    " in mollis nunc sed id et magnis dis parturient montes nascetur ridiculus mus mauris vitae tellus mauris a diam maecenas sed enim ut sem" +
                    " et netus et malesuada fames ac turpis egestas sed maecenas pharetra convallis posuere morbi leo urna molestie" +
                    " elit eget gravida cum sociis natoque penatibus et magnis dis forlop amendo cilla";

    public String validationCode(int num) {
        String[] alpha = {
                "AX6BYU56UX6CV6BNT7NM287430",
                "AX6BYU56UX6CV6BNT7NM111111",
                "AX6BYU56UX6CV6BNT7NM34",
                "12",
                "aliquam ultrices sagittis",
                "",
                "AX6ByU56UX6CV6BNT7NM287430",
                "AX6BYU56UX6CV6BNT0NM257400"
        };
        if(num>alpha.length-1)
            return"";
        return alpha[num];
        //return "AX6BYU56UX6CV6BNT7NM287430";
    }

}
