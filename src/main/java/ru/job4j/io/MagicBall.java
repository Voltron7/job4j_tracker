package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Добро пожаловать. Что вы хотите узнать? ");
        String question = input.nextLine();
        System.out.println(question);
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Да!");
        } else if (answer == 1) {
            System.out.println("Нет!");
        } else {
            System.out.println("Может быть!");
        }
    }
}
