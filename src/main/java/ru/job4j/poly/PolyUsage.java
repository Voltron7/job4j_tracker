package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle plane1 = new Plane();
        Vehicle train = new Train();
        Vehicle train1 = new Train();
        Vehicle trolleybus = new Trolleybus();
        Vehicle trolleybus1 = new Trolleybus();

        Vehicle[] vehicles = new Vehicle[]{plane, plane1, train,
                train1, trolleybus, trolleybus1};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
