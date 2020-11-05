package com.nikolenko.homeworks.homework_18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class DataProvider {
    List<Person> personList;

    public DataProvider() {
        personList = new ArrayList<>();
    }

    abstract boolean readFile(String fileName);

    abstract boolean readFile();

    public List<Person> provide() {
        return new ArrayList<>(personList);
    }

    public boolean saveToFile(String filePath) {
        List<Person> personList = provide();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            try {
                objectOutputStream.writeObject(personList);
            } catch (IOException e) {
                System.out.println("serializeTest ObjectOutputStream IOException");
                return false;
            }
        } catch (IOException e) {
            System.out.println("IOException in serializeTest" + e.toString());
            return false;
        }
        return true;
    }

    public boolean saveToFile() {
        return saveToFile("covid.dat");
    }

    public int getSize() {
        return personList.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person person : personList) {
            result.append(person.toString());
        }
        result.append("\n");
        return new String(result);
    }
}
