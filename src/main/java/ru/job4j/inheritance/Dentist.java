package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int cleaning;

    public Dentist(String name, String surname, String education, int birthday, String patient, int cleaning) {
        super(name, surname, education, birthday, patient);
        this.cleaning = cleaning;
    }
}
