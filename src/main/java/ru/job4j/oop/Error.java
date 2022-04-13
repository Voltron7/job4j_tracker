package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
     this.active = active;
     this.status = status;
     this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error1 = new Error(true, 1, "Ошибка");
        error1.printInfo();
        Error error2 = new Error(false, 2, "Ошибка 2");
        error2.printInfo();
    }
}