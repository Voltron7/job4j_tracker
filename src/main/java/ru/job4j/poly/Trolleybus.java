package ru.job4j.poly;

public class Trolleybus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Троллейбус едет по дороге");
    }
}
