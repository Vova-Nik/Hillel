package com.nikolenko.homeworks.homework_18;

public class DataProviderFactory {
    private static DataProviderFactory instance = null;

    private DataProviderFactory() {
    }

    public static DataProviderFactory getInstance() {
        if (instance == null) {
            instance = new DataProviderFactory();
        }
        return instance;
    }

    public DataProvider create(String path) throws DataProviderFactoryException {
        if (path.length() < 5) {
            throw (new DataProviderFactoryException("Bad file name"));
        }
        String fileExtension = path.substring(path.length() - 4);
        DataProvider result;
        switch (fileExtension) {
            case ".csv":
                result = new CSVDataProvider();
                result.readFile(path);
                break;
            case ".dat":
                result = new DatDataProvider();
                result.readFile(path);
                break;
            default:
                throw (new DataProviderFactoryException("Bad file type"));
        }
        return result;
    }
}

class DataProviderFactoryException extends Exception {
    String message;

    DataProviderFactoryException(String str) {
        message = str;
    }

    public String toString() {
        return ("DataProviderFactoryException Occurred: " + message);
    }
}
