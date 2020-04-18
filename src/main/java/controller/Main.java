package controller;

import model.Mediatheque;
import model.category.Category;
import model.item.Book;
import model.category.CategoryKind;
import model.item.Movie;
import model.item.Podcast;
import model.person.Author;
import model.person.Manager;
import model.person.User;

public class Main {
    public static void main(String[] args) {
        Mediatheque.getInstance();

        Manager manager = new Manager("Adam", "adam", true);

        Author Tolkien = new Author("Tolkien");

        Category book = new Category(CategoryKind.BOOK.toString(), "Fairy story for adults");
        Category movie = new Category(CategoryKind.MOVIE.toString(), "Classic movies to family watching");
        Category podcast = new Category(CategoryKind.PODCAST.toString(),"Listen your favorite books for free!");

        manager.addItem(new Book("The Hobbit", book, Tolkien, 1937, 328));
        manager.addItem(new Book("Lord of rings", book, Tolkien, 1957, 1584));
        manager.addItem(new Movie("The Hobbit", movie, Tolkien, 350.16, 2017));
        manager.addItem(new Podcast("Lord of rings", podcast, Tolkien, 650,2010));

        System.out.println("List of mediaItems: ");
        Mediatheque.getInstance().showItems();

        manager.removeItem(0);
        // List of items after removing
        System.out.println();
        System.out.println("After removing: ");
        Mediatheque.getInstance().showItems();

        // User preview a media items
        System.out.println();
        User user1 = new User("Ivan", "ivan", false);
        System.out.println(user1.getName()+ ": ");
        user1.preview(Mediatheque.getInstance().getItems().getAllItems().get(0));
        user1.preview(Mediatheque.getInstance().search(CategoryKind.MOVIE.toString()).get(0));
        user1.preview(Mediatheque.getInstance().search(CategoryKind.PODCAST.toString()).get(0));
    }
}
