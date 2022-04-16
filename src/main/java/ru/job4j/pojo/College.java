package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Valeri");
        student.setSurname("Shpakowski");
        student.setGroup(333);
        student.setEntered(new Date());
        System.out.println(student.getName() + " " + student.getSurname() + " entered to group " + student.getGroup() + " " + student.getEntered());
    }
}
