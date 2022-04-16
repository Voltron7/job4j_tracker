package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String project;

    public Engineer(String name, String surname, String education, int birthday, String project) {
        super(name, surname, education, birthday);
        this.project = project;
    }
}
