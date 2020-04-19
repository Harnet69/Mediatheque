package controller;

import model.Mediatheque;
import model.category.Category;
import model.item.Book;
import model.category.CategoryKind;
import model.item.MediaItem;
import model.item.Movie;
import model.item.Podcast;
import model.person.Author;
import model.person.Manager;
import model.person.User;

public class Main {
    public static void main(String[] args) {
        Mediatheque library = Mediatheque.getInstance();

        Manager manager = new Manager("Adam", "adam", true);
        library.getManagers().addItem(manager);

        manager.addAuthor(new Author("Tolkien"));

        manager.addCategory(new Category(CategoryKind.BOOK.toString(), "Fairy story for adults"));
        manager.addCategory(new Category(CategoryKind.MOVIE.toString(), "Classic movies to family watching"));
        manager.addCategory(new Category(CategoryKind.PODCAST.toString(),"Listen your favorite books for free!"));

        manager.addItem(new Book("The Hobbit", library.getCategories().getItemById(0), library.getAuthors().getItemById(0), 1937, 328));
        manager.addItem(new Book("Lord of rings", library.getCategories().getItemById(0), library.getAuthors().getItemById(0), 1957, 1584));
        manager.addItem(new Movie("The Hobbit", library.getCategories().getItemById(1), library.getAuthors().getItemById(0), 350.16, 2017));
        manager.addItem(new Podcast("Lord of rings", library.getCategories().getItemById(2), library.getAuthors().getItemById(0), 650,2010));

        System.out.println("List of mediaItems: ");
        library.showItems(true);

        manager.removeItem(1);
        // List of items after removing
        System.out.println();
        System.out.println("After removing: ");
        library.showItems(true);

        // User preview a media items
        System.out.println();
        User user1 = new User("Ivan", "ivan", false);
        User user2 = new User("Pavel", "pavel", false);
        System.out.println(user1.getName()+ ": ");
        user1.preview(library.getItems().getAllItems().get(0));
        user1.preview(library.search(CategoryKind.MOVIE.toString()).get(0));
        user1.preview(library.search(CategoryKind.PODCAST.toString()).get(0));

        // Rent The Hobbit movie
        user1.rent(2);

        // Show
        System.out.println();
        System.out.println("List of non rented media: ");
        library.showItems(false);

        // Show
        System.out.println();
        System.out.println("Rented media item: ");
        System.out.println(user1.getRentedItems().get(0).getName());

        // Return The Hobbit movie
        user1.returnMedia(0);

        System.out.println("List of mediaItems after return: ");
        library.showItems(true);

        // Reserve Lord of Ring podcast
        user1.reserve(3);
        user2.reserve(0);

        // List of reserved items
        System.out.println();
        System.out.println("List of reserved items: ");
        for(MediaItem item : library.getItems().getAllItems()){
            if(item.getReservedBy() !=null) {
                System.out.println(item.getReservedBy().getName()+ " reserved: " + item.getCategory().getName()+ " " + item.getName());
            }
        }
    }
}
