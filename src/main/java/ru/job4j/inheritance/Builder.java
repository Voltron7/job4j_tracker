package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String building;

    public Builder()  {
        super();
    }

    public Builder(String name, String surname, String education, int birthday, String project, String building) {
        super(name, surname, education, birthday, project);
        this.building = building;
    }
}
