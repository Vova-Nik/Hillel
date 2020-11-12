package com.nikolenko.homeworks.homework_18;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DatDataProvider extends DataProvider {

    DatDataProvider() {
        personList = new ArrayList<>();
    }

    public boolean readFile(String fileName) {
        Path path = FileSystems.getDefault().getPath(fileName);
        Object object;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
//            personList = (ArrayList<Person>) objectInputStream.readObject();
            object =  objectInputStream.readObject();

        } catch (ClassNotFoundException e) {
            System.out.println("serializeTest ObjectInputStream ClassNotFoundException");
            return false;
        } catch (IOException e) {
            System.out.println("DataProvider error. " + e);
            return false;
        }
        if(!object.getClass().toString().contains("ArrayList")){
            return false;
        }
        personList = (ArrayList<Person>)object;
        return true;
    }

    public boolean readFile() {
        return readFile("covid.dat");
    }

}