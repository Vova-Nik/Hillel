package com.nikolenko.homeworks.homework_15;

import lombok.Value;

@Value
public class Person {
    String name;
    String surname;
    int age;
    int height;
    int weight;
    String mail;
    String domain;

    Person(String name, String surname, int age, int height, int weight, String mail)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.mail = mail;
        this.domain = mail.substring(mail.indexOf('@') + 1);
    }

    @Override
    public String toString() {
        return "Person: {" + "name:" + name + "\t" + "surname:" + surname + "\t" + "age:" + age + "\t" + "weight:" + weight + "\t" + "height:" + height + "\t" + "mail:" + mail + "\t" + "domain:" + domain + "}" + "\n";
    }
}



