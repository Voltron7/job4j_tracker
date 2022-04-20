package ru.job4j.poly;

public interface Transport {
    void toGo();

    void passengers(int count);

    int refuel(int quantity);
}
