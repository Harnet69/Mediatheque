package controller;

import model.Mediatheque;
import model.item.Book;
import model.item.ItemKind;
import model.item.MediaItem;
import model.person.Author;

public class Main {
    public static void main(String[] args) {
        Mediatheque.getInstance();
        Book TheHobbit = new Book("The Hobbit", new Author(), 1937, 328);
        Mediatheque.getInstance().getBooks().addItem(TheHobbit);
        System.out.println(Mediatheque.getInstance().search(ItemKind.BOOK).get(0));
    }
}
