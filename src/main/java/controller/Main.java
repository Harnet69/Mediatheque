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

        // create manager
        Manager manager = new Manager("Adam", "adam", true);
//        Manager manager1 = new Manager("", "Jango", true);

        // Add author
        try {
            manager.addAuthor(new Author("Tolkien"));
        } catch (IllegalArgumentException e) {
            System.out.println("Author name can't be empty!");
        }

        // try to create Author without name
        System.out.println("Try to add author with empty name: ");
        try {
            manager.addAuthor(new Author(""));
        } catch (IllegalArgumentException e) {
            System.out.println("Author name can't be empty!");
        }

        // Try to get author with unexciting id
        System.out.println();
        System.out.println("Try to get author with unexciting id: ");
        try {
            System.out.println("&&&" + library.getAuthors().getItemById(5));
        } catch (IllegalArgumentException e) {
            System.out.println("There isn't such id in authors");
        }


        manager.addCategory(new Category(CategoryKind.BOOK.toString(), "Fairy story for adults"));
        manager.addCategory(new Category(CategoryKind.MOVIE.toString(), "Classic movies to family watching"));
        manager.addCategory(new Category(CategoryKind.PODCAST.toString(), "Listen your favorite books for free!"));

        manager.addItem(new Book("The Hobbit", library.getCategories().getItemById(0), library.getAuthors().getItemById(0), 1937, 328));
        manager.addItem(new Book("Lord of rings", library.getCategories().getItemById(0), library.getAuthors().getItemById(0), 1957, 1584));
        manager.addItem(new Movie("The Hobbit", library.getCategories().getItemById(1), library.getAuthors().getItemById(0), 350.16, 2017));
        manager.addItem(new Podcast("Lord of rings", library.getCategories().getItemById(2), library.getAuthors().getItemById(0), 650, 2010));

        System.out.println();
        System.out.println("List of mediaItems: ");
        library.showItems(true);

        // Remove item by manager
        System.out.println();
        System.out.println("Remove \"Lord of rings\" book by manager: ");
        try {
            manager.removeItem(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Removing item was failed! Such id don't exist");
        }

        // List of items after removing
        System.out.println();
        System.out.println("After removing: ");
        library.showItems(true);

        // User preview a media items
        System.out.println();
        User user1 = new User("Ivan", "ivan", false);
        User user2 = new User("Pavel", "pavel", false);

        // test an exception
        try {
            User user3 = new User("", "", false);
        } catch (IllegalArgumentException e) {
            System.out.println("Name or login field is empty! User haven't created");
        }

        System.out.println(user1.getName() + ": ");
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
        System.out.println();
        System.out.println("Return media item: ");
        try {
            user1.returnMedia(2);
//            user1.returnMedia(5); // test exception
        } catch (IllegalArgumentException e) {
            System.out.println("Return failed! There is not such id.");
            ;
        }

        System.out.println();
        System.out.println("List of mediaItems after return: ");
        library.showItems(true);

        // Reserve Lord of Ring podcast
        user1.reserve(3);
        user2.reserve(0);

        // List of reserved items
        System.out.println();
        System.out.println("List of reserved items: ");
        library.showReservedItems();

        // Cancellation of a reservation
        user1.reservationCancel(3);

        // List of reserved items after a cancellation
        System.out.println();
        System.out.println("List of reserved items after a cancellation: ");
        library.showReservedItems();

        // Manager tries to remove nonexistent item
        try {
            manager.removeItem(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Cant remove");
        }
        System.out.println(library.getAuthors().getItemById(0).getId());
        System.out.println(library.getCategories().getItemById(0).getId());
        System.out.println(library.getItems().getItemById(0).getId());
    }
}
