package com.nikolenko.homeworks.homework_15;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final int height;
    private final int weight;
    private final String mail;


    Person(String name, String surname, int age, int height, int weight, String mail)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.mail = mail;
    }

    public String getDomain(){
        return mail.substring(mail.indexOf('@') + 1);
    }

    @Override
    public String toString() {
        return "Person: {" + "name:" + name + "\t" + "surname:" + surname + "\t" + "age:" + age + "\t" + "weight:" + weight + "\t" + "height:" + height + "\t" + "mail:" + mail + "\t" + "domain:" + getDomain() + "}" + "\n";
    }
}



