package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("voltron7@gmail.com", "Valeri Shpakowski");
        map.put("petr@gmail.com", "Petr Arsentev");
        map.put("stas@gmail.com", "Stas Korobeinikov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key  + " - " + value);
        }
    }
}
