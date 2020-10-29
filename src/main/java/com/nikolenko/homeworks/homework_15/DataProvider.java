package com.nikolenko.homeworks.homework_15;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private List<String> fileLines;
    DataProvider() {
        fileLines = new ArrayList<>();
    }

    void addFile(String fileName) {
        Path path = FileSystems.getDefault().getPath(fileName);
        try {
            fileLines = Files.readAllLines(path);

        } catch (IOException e) {
            System.out.println("DataProvider error. " + e);
        }
    }

    void addString(String person) {
        fileLines.add(person);
    }

    public List<Person> provide() {
        List<Person> personList = new ArrayList<>();
        for (String rawPerson : fileLines) {
            try {
                personList.add(DataMapper.mapString(rawPerson));
            } catch (PersonFailException e) {
                System.out.println(e.toString());
            }
        }
        return personList;
    }

    public int getSize(){
        return fileLines.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String person : fileLines) {
            result.append(person).append('\n');
        }
        result.append("\n");
        return new String(result);
    }

}




