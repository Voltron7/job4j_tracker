package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String patient;

    public Doctor(String name, String surname, String education, int birthday, String patient) {
        super(name, surname, education, birthday);
        this.patient = patient;
    }
}
