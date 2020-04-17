package controller;

import model.Mediatheque;
import model.category.Category;
import model.item.Book;
import model.category.CategoryKind;
import model.person.Author;

public class Main {
    public static void main(String[] args) {
        Mediatheque.getInstance();
        Category book = new Category(CategoryKind.BOOK.toString(), "Fairy story for adults");
        Author Tolkien = new Author();

        Book TheHobbit = new Book("The Hobbit", book, Tolkien, 1937, 328);
        Book LorgOfRings = new Book("Lord of rings", book, Tolkien, 1957, 1584);

        Mediatheque.getInstance().addItem(TheHobbit);
        Mediatheque.getInstance().addItem(LorgOfRings);

        System.out.println(Mediatheque.getInstance().search(CategoryKind.BOOK.toString()));
    }
}
