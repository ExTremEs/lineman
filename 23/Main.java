package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = getPersonList();
        List<Person> sortedPersonList = sortPersonByFirstnameAndLastname(personList);
        Map<String, List<Person>> personGroupByGender = groupPersonByGender(sortedPersonList);
        System.out.println(personGroupByGender);
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
        personList.add(new Person(41, "Uma", "Thurman", "Female"));
        personList.add(new Person(43, "Alicia", "Silverstone", "Female"));
        personList.add(new Person(38, "Elle", "Macpherson", "Female"));
        personList.add(new Person(51, "Vivica A.", "Fox", "Female"));
        personList.add(new Person(61, "Kimberly", "Scott", "Female"));

        return personList;
    }

    private static List<Person> sortPersonByFirstnameAndLastname(List<Person> personList) {

        //Compare by first name and then last name
        Comparator<Person> compareByName = Comparator
                .comparing(Person::getFirstname)
                .thenComparing(Person::getLastname);

        List<Person> sortedPersonList = personList.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());

        return sortedPersonList;
    }

    private static Map<String, List<Person>> groupPersonByGender(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getGender()));
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