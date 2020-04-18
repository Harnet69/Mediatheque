package controller;

import model.Mediatheque;
import model.category.Category;
import model.item.Book;
import model.category.CategoryKind;
import model.person.Author;
import model.person.Manager;
import model.person.User;

public class Main {
    public static void main(String[] args) {
        Mediatheque.getInstance();
        Manager manager = new Manager("Adam", "adam", true);
        Category book = new Category(CategoryKind.BOOK.toString(), "Fairy story for adults");
        Author Tolkien = new Author("Tolkien");

        Book TheHobbit = new Book("The Hobbit", book, Tolkien, 1937, 328);
        Book LordOfRings = new Book("Lord of rings", book, Tolkien, 1957, 1584);

        manager.addItem(TheHobbit);
        manager.addItem(LordOfRings);

        System.out.println("List of mediaItems: ");
        Mediatheque.getInstance().showItems();

        manager.removeItem(TheHobbit);
        // after removing
        System.out.println();
        System.out.println("After removing: ");
        Mediatheque.getInstance().showItems();

        User user1 = new User("Ivan", "ivan", false);
        user1.preview(Mediatheque.getInstance().getItems().getAllItems().get(0));
    }
}
