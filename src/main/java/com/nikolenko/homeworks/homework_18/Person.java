package com.nikolenko.homeworks.homework_18;

import lombok.*;

import java.io.Serializable;

@Value
@Builder
public class Person implements Serializable {
    String name;
    String surname;
    int age;
    int height;
    int weight;
    String mail;

    public String getDomain() {
        return mail.substring(mail.indexOf('@') + 1);
    }

    @Override
    public String toString() {
        return "Person: {" + "name:" + name + "\t" + "surname:" + surname + "\t" + "age:" + age + "\t" + "weight:" + weight + "\t" + "height:" + height + "\t" + "mail:" + mail + "\t" + "domain:" + getDomain() + "}" + "\n";
    }
}



