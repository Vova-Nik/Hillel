package com.nikolenko.homeworks.homework_18;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVDataProvider extends DataProvider {

    CSVDataProvider() {
        this.personList = new ArrayList<>();
    }

    public boolean readFile(String fileName) {
        Path path = FileSystems.getDefault().getPath(fileName);
        List<String> fileLines;
        try {
            fileLines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("DataProvider error. " + e);
            return false;
        }
        try {
            for (String s : fileLines) {
                personList.add(DataMapper.mapString(s));
            }
        } catch (PersonFailException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    public boolean readFile() {
        return readFile("covid.dat");
    }

}




