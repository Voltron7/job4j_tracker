package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void toGo() {

    }

    @Override
    public void passengers(int count) {
        System.out.println(count);
    }

    @Override
    public int refuel(int quantity) {
        int cost = 5;
        int price = cost * quantity;
        return price;
    }
}
