package com.nikolenko.homeworks.homework_03;

/**
 * <b>Java Primitive type informer</b>
 * *By Nikolenko Volodymyr
 * to see info - call 'info(<T>) method with any type of arg
 */

public class PrimitivInfo {

    public String info(int toInfo) {
        while (toInfo < (toInfo + 0xff)) {
            toInfo += 0xff;
        }
        while (toInfo < (toInfo + 1)) {
            toInfo++;
        }
        return "Type - 'int'\n Max value is " + toInfo + "\n" + " Min value is " + (toInfo + 1) + "\n";
    }

    public String info(byte toInfo) {
        while (toInfo < (byte) (toInfo + 1)) {
            toInfo++;
        }
        return "Type - 'byte'\n Max value is " + toInfo + "\n" + " Min value is " + (toInfo + 1) + "\n";
    }

    public String info(short toInfo) {
        while (toInfo < (short) (toInfo + 1)) {
            toInfo++;
        }
        return "Type - 'short'\n Max value is " + toInfo + "\n" + " Min value is " + (toInfo + 1) + "\n";
    }

    public String info(long toInfo) {

        return "Type - 'long'\n Max value is " + Long.MAX_VALUE + "\n" + " Min value is " + Long.MIN_VALUE + "\n";
    }

    public String info(float toInfo) {
        return "Type - 'float'\n Max value is " + Float.MAX_VALUE + "\n" + " Min value is " + Float.MIN_VALUE + "\n";
    }

    public String info(double toInfo) {
        return "Type - 'double'\n Max value is " + Double.MAX_VALUE + "\n" + " Min value is " + Double.MIN_VALUE + "\n";
    }

    public String info(char toInfo) {
        StringBuilder chars = new StringBuilder("" + (char) 0);
        for (int i = 1; i <= 0xffff; i++) {
            chars.append((char) i);
            if (i % 80 == 0) {
                chars.append("\n");
            }
        }
        return "Type - 'character'\n" + chars + "\n";
    }
}
