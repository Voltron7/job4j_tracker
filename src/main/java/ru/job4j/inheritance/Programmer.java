package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String program;

    Programmer() {
        super();
    }

    public Programmer(String name, String surname, String education, int birthday, String project, String program) {
        super(name, surname, education, birthday, project);
        this.program = program;
    }
}
