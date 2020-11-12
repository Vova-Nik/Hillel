package com.nikolenko.homeworks.homework_18;

public class DataMapper {

    public static Person mapString(String rawPerson) throws PersonFailException {
        String[] raw = rawPerson.split(",");
        if (raw.length != 6) {
            throw new PersonFailException("Can not create Person. Dada structure wrong." + rawPerson);
        }
        return new Person(
                raw[0],
                raw[1],
                Integer.parseInt(raw[2]),
                Integer.parseInt(raw[3]),
                Integer.parseInt(raw[4]),
                raw[5]
        );
    }
}

class PersonFailException extends Exception {
    String message;

    PersonFailException(String str) {
        message = str;
    }

    public String toString() {
        return ("PersonFailException Occurred: " + message);
    }
}






