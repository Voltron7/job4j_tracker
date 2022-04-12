package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String eng = dummyDic.engToRus("Неизвестное слово " + "+ eng");
        System.out.println(eng);
    }
}
