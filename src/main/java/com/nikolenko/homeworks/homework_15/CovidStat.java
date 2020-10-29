package com.nikolenko.homeworks.homework_15;

import java.util.*;

public class CovidStat {
    private final List<Person> persons;

    CovidStat(List<Person> personsList) {
        persons = personsList;
    }

    public String getMostPopularName() {
        List<String> namesList = new ArrayList<>();
        for (Person person : persons) {
            namesList.add(person.getName());
        }
        Collections.sort(namesList);
        Map<String, Integer> namesMap = new HashMap<>();
        String name;
        int maxCountOfNames = 0;
        for (Person person : persons) {
            name = person.getName();
            if (namesMap.containsKey(name)) {
                namesMap.put(name, (namesMap.get(name) + 1));
                if (namesMap.get(name) > maxCountOfNames) {
                    maxCountOfNames = namesMap.get(name);
                }
            } else {
                namesMap.put(name, 1);
            }
        }
        String mostPopular = "";
        for (String nam : namesList) {
            if (namesMap.get(nam) == maxCountOfNames) {
                mostPopular = nam;
                break;
            }
        }
        return mostPopular;
    }

    public String getMostPopularSurname() {
        List<String> surnamesList = new ArrayList<>();
        for (Person person : persons) {
            surnamesList.add(person.getSurname());
        }
        Collections.sort(surnamesList);
        Map<String, Integer> namesMap = new HashMap<>();
        String surname;
        int maxCountOfSurnames = 0;
        for (Person person : persons) {
            surname = person.getSurname();
            if (namesMap.containsKey(surname)) {
                namesMap.put(surname, (namesMap.get(surname) + 1));
                if (namesMap.get(surname) > maxCountOfSurnames) {
                    maxCountOfSurnames = namesMap.get(surname);
                }
            } else {
                namesMap.put(surname, 1);
            }
        }
        String mostPopular = "";
        for (String sname : surnamesList) {
            if (namesMap.get(sname) == maxCountOfSurnames) {
                mostPopular = sname;
                break;
            }
        }
        return mostPopular;
    }

    public String getMostPopularDomain() {
        List<String> domainsList = new ArrayList<>();
        for (Person person : persons) {
            domainsList.add(person.getDomain());
        }
        Collections.sort(domainsList);
        Map<String, Integer> namesMap = new HashMap<>();
        String domain;
        int maxCountOfDomains = 0;
        for (Person person : persons) {
            domain = person.getDomain();
            if (namesMap.containsKey(domain)) {
                namesMap.put(domain, (namesMap.get(domain) + 1));
                if (namesMap.get(domain) > maxCountOfDomains) {
                    maxCountOfDomains = namesMap.get(domain);
                }
            } else {
                namesMap.put(domain, 1);
            }
        }
        String mostPopular = "";
        for (String dmn : domainsList) {
            if (namesMap.get(dmn) == maxCountOfDomains) {
                mostPopular = dmn;
                break;
            }
        }
        return mostPopular;
    }

    public int getAverageAge() {
        Double average = 0.0;
        for (Person person : persons) {
            average += person.getAge();
        }
        average = average / persons.size();
        average = Math.round(average * 1.0) / 1.0;
        return average.intValue();
    }

    public int getAverageHeight() {
        Double average = 0.0;
        for (Person person : persons) {
            average += person.getHeight();
        }
        average = average / persons.size();
        average = Math.round(average * 1.0) / 1.0;
        return average.intValue();
    }

    public int getAverageWeight() {
        Double average = 0.0;
        for (Person person : persons) {
            average += person.getWeight();
        }
        average = average / persons.size();
        average = Math.round(average * 1.0) / 1.0;
        return average.intValue();
    }
}
