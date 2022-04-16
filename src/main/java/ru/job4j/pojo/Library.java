package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean code", 11);
        Book book1 = new Book("Effective Java", 12);
        Book book2 = new Book("Core Java", 13);
        Book book3 = new Book("Head First Java", 14);
        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Swap book and book3.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Book with name Clean code: ");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
