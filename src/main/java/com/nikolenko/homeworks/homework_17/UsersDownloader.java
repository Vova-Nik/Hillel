package com.nikolenko.homeworks.homework_17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UsersDownloader {
    private final String HOST = "jsonplaceholder.typicode.com";
    private final String REQUEST =  "GET /users HTTP/1.1\n" + "Host: jsonplaceholder.typicode.com\n" + "\n" + "\n";
    private final StringBuilder response = new StringBuilder();
//    int dataSize;

    UsersDownloader() {
        try {
            Socket socket = new Socket(HOST, 80);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(REQUEST.getBytes());
            int ch;
            int readded;

            System.out.println("inputStream.available() " + inputStream.available());
            byte[] inputArray = new byte[256];


            while (true) {
                readded = inputStream.read(inputArray);
                for (int i = 0; i < readded; i++) {
                    response.append((char) inputArray[i]);
                }
                if(readded<256){
                    break;
                }
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Sockets creation error - " + e.toString());
        }
    }

    public String getBody() {
        String endOfHeader = (char) 13 + String.valueOf((char)10);
        int dbeg = response.toString().indexOf(endOfHeader + endOfHeader);
        return response.toString().substring(dbeg+4);
    }

    public String getRawData() {
        return response.toString();
    }

    public int getSise() {
        return response.length();
    }
}

