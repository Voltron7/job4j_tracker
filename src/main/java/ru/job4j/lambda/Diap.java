package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diap {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        int min = Math.min(start, end);
        int max = Math.max(start, end);
        for (int i = min; i < max; i++) {
            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
