package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String illness;

    public Surgeon() {
        super();
    }

    public Surgeon(String name, String surname, String education, int birthday, String patient, String illness) {
        super(name, surname, education, birthday, patient);
        this.illness = illness;
    }
}
