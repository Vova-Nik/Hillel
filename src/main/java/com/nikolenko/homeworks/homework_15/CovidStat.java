package com.nikolenko.homeworks.homework_15;

import java.util.*;

public class CovidStat {
    private final Set<Person> persons;

    CovidStat(Set<Person> personsSet) {
        persons = personsSet;
    }

    public String getMostPopularName() {
        PersonComparatorName personComparatorName = new PersonComparatorName(persons);
        TreeSet<Person> people = new TreeSet<>(personComparatorName);
        people.addAll(persons);
        return people.first().getName();
    }

    public String getMostPopularSurname() {
        PersonComparatorSurename personComparatorSurename = new PersonComparatorSurename(persons);
        TreeSet<Person> people = new TreeSet<>(personComparatorSurename);
        people.addAll(persons);
        return people.first().getSurname();
    }

    public String getMostPopularDomain() {
        PersonComparatorDomain personComparatorDomain = new PersonComparatorDomain(persons);
        TreeSet<Person> people = new TreeSet<>(personComparatorDomain);
        people.addAll(persons);
        return people.first().getDomain();
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

class PersonComparatorName implements Comparator<Person> {
    Map<String, Integer> names = new HashMap<>();
    PersonComparatorName(Set<Person> persons) {
        for (Person person : persons) {
            String name = person.getName();
            if (names.containsKey(name)) {
                names.put(name, (names.get(name) + 1));
            } else {
                names.put(name, 1);
            }
        }
    }

    public int compare(Person a, Person b) {
        String aName = a.getName();
        String bName = b.getName();
        if (names.get(aName).equals(names.get(bName))) {
            return aName.compareTo(bName);
        }
        if (names.get(aName) < names.get(bName)) {
            return 1;
        }
        return -1;
    }
}

class PersonComparatorSurename implements Comparator<Person> {
    Map<String, Integer> surnames = new HashMap<>();
    PersonComparatorSurename(Set<Person> persons) {
        for (Person person : persons) {
            String surname = person.getSurname();
            if (surnames.containsKey(surname)) {
                surnames.put(surname, (surnames.get(surname) + 1));
            } else {
                surnames.put(surname, 1);
            }
        }
    }

    public int compare(Person a, Person b) {
        String aSurname = a.getSurname();
        String bSurname = b.getSurname();
        if (surnames.get(aSurname).equals(surnames.get(bSurname))) {
            return aSurname.compareTo(bSurname);
        }
        if (surnames.get(aSurname) < surnames.get(bSurname)) {
            return 1;
        }
        return -1;
    }
}

class PersonComparatorDomain implements Comparator<Person> {
    Map<String, Integer> domains = new HashMap<>();
    PersonComparatorDomain(Set<Person> persons) {
        for (Person person : persons) {
            String domain = person.getDomain();
            if (domains.containsKey(domain)) {
                domains.put(domain, (domains.get(domain) + 1));
            } else {
                domains.put(domain, 1);
            }
        }
    }

    public int compare(Person a, Person b) {
        String aDomain = a.getDomain();
        String bDomain = b.getDomain();
        if (domains.get(aDomain).equals(domains.get(bDomain))) {
            return aDomain.compareTo(bDomain);
        }
        if (domains.get(aDomain) < domains.get(bDomain)) {
            return 1;
        }
        return -1;
    }
}