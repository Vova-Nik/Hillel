package com.nikolenko.homeworks.homework_11;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements AutoCloseable {
    private final SimpleDateFormat dateFormat;
    private final BufferedWriter bufferedWriter;
    private final Writer writer;

    Logger(Writer writer) {
        this.writer = writer;
        dateFormat = new SimpleDateFormat("yyy-MM-dd' 'HH:mm:ss ");
        bufferedWriter = new BufferedWriter(writer);
    }

    void log(String messege) throws IOException {
        bufferedWriter.append(dateFormat.format(new Date())).append("INFO: ").append(messege).append("\n");
    }

    @Override
    public void close() throws IOException {
        if (writer.getClass().toString().contains("PrintWriter")) {  //without this blok tests logging to console would not passed        bufferedWriter.close();
            bufferedWriter.close();
            return;
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
