package com.nikolenko.homeworks.homework_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProvider {

    private final List<String> list;
    DataProvider() {
        list = new ArrayList<>();
    }

    void addFile(String path) {
        String record;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (true) {
                record = br.readLine();
                if (record == null) {
                    break;
                }
                list.add(record);
            }
        } catch (IOException e) {
            System.out.println("DataProvider error. " + e);
        }
    }

    void addString(String person) {
        list.add(person);
    }

    public Set<Person> provide() {
        Set<Person> set = new HashSet<>();
        for (String rawPerson : list) {
            try {
                set.add(DataMapper.mapString(rawPerson));
            } catch (PersonFailException e) {
                System.out.println(e.toString());
            }
        }
        return set;
    }

    public int getSize(){
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String person : list) {
            result.append(person).append('\n');
        }
        result.append("\n");
        return new String(result);
    }

}




