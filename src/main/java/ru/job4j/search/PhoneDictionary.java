package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findName = n -> n.getName().contains(key);
        Predicate<Person> findSurname = s -> s.getSurname().contains(key);
        Predicate<Person> findPhone = p -> p.getName().contains(key);
        Predicate<Person> findAddress = a -> a.getName().contains(key);
        var combine = findName.or(findSurname).or(findPhone).or(findAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
