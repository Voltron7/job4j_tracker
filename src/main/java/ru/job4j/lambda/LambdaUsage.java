package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            int rsl = Integer.compare(right.length(), left.length());
            System.out.println("Результат сравнения - " + left.length() + " : " + right.length()
            + " = " + rsl);
            return rsl;
        };
        strings.sort(comparator);
    }
}
