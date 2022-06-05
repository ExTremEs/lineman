package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = getPersonList();

        //Compare by first name and then last name
        Comparator<Person> compareByName = Comparator
                .comparing(Person::getFirstname)
                .thenComparing(Person::getLastname);

        List<Person> sortedEmployees = personList.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());

        sortedEmployees.forEach(person -> {
            System.out.println(person);
        });
    }

    private static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(21, "Lokesh", "Gupta", "Male"));
        personList.add(new Person(11, "Alex", "Gussin", "Male"));
        personList.add(new Person(41, "Brian", "Sux", "Male"));
        personList.add(new Person(51, "Neon", "Piper", "Male"));
        personList.add(new Person(31, "David", "Beckham", "Male"));
        personList.add(new Person(71, "Alex", "Beckham", "Male"));
        personList.add(new Person(61, "Brian", "Suxena", "Male"));
        return personList;
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Person {

    private Integer age;
    private String firstname;
    private String lastname;
    private String gender;
}