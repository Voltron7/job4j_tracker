package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI extends Item {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item = new Item();
        System.out.println(formatter.format(item.getCreated()));

    }
}
