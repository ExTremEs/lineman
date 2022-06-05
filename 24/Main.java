package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = getPersonList();
        List<Person> filterPersonList = filterAgeMoreThanOrEqual30(personList);

        filterPersonList.forEach(person -> {
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
        personList.add(new Person(30, "Jordon", "Beckham", "Male"));
        personList.add(new Person(71, "Alex", "Beckham", "Male"));
        personList.add(new Person(61, "Brian", "Suxena", "Male"));
        personList.add(new Person(41, "Uma", "Thurman", "Female"));
        personList.add(new Person(43, "Alicia", "Silverstone", "Female"));
        personList.add(new Person(38, "Elle", "Macpherson", "Female"));
        personList.add(new Person(51, "Vivica A.", "Fox", "Female"));
        personList.add(new Person(61, "Kimberly", "Scott", "Female"));

        return personList;
    }

    private static List<Person> filterAgeMoreThanOrEqual30(List<Person> personList) {
        return personList.stream().filter(person -> {
            return person.getAge() >= 30;
        }).collect(Collectors.toList());
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