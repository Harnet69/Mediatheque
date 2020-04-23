package model.person;

import model.Mediatheque;
import model.category.Category;
import model.item.Book;
import model.item.Podcast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerTest {
    private Mediatheque lib;
    private Manager manager;
    private Category bookCat;
    private Category movieCat2;
    private Category podcastCat3;
    private Author Tolkien;
    private Author Pratchet;
    private Book book;
    private Podcast podcast;


    @BeforeEach
    void setUp() {
        lib = Mediatheque.getInstance();
        manager = new Manager("Adam", "adam", true);
        bookCat = new Category("book", "Something to read");
        movieCat2 = new Category("movie", "Something to watch");
        podcastCat3 = new Category("podcast", "Something to listen");
        Tolkien = new Author("Tolkien");
        Pratchet = new Author("Pratchet");
        book = new Book("The Hobbit", bookCat, Tolkien, 1937, 358);
        podcast = new Podcast("Lord of rings", podcastCat3, Tolkien, 356, 205);
        manager.addCategory(bookCat);
        manager.addAuthor(Tolkien);
        manager.addItem(book);
    }

    @Test
    @Order(1)
    void addCategory() {
        int sizeBefore = lib.getCategories().getAllItems().size();
        manager.addCategory(movieCat2);
        assertEquals(sizeBefore + 1, lib.getCategories().getAllItems().size());
        assertEquals("movie", lib.getCategories().getItemById(1).getName());
    }

    @Test
    @Order(2)
    void addCategoryException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addCategory(null);
        });

        String expectedMessage = "There isn't such category in categories";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(3)
    void removeCategory() {
        int sizeBefore = lib.getCategories().getAllItems().size();
        manager.removeCategory(0);
        assertEquals(lib.getCategories().getAllItems().size(), sizeBefore -1);
    }

    @Test
    @Order(4)
    void removeCategoryException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.removeCategory(-1);
        });

        String expectedMessage = "There isn't category with such id in categories";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(5)
    void addAuthor() {
        int sizeBefore = lib.getAuthors().getAllItems().size();
        manager.addAuthor(Pratchet);
        assertEquals(sizeBefore +1, lib.getAuthors().getAllItems().size());
        assertEquals("Tolkien", lib.getAuthors().getItemById(3).getName());
    }

    @Test
    @Order(6)
    void addAuthorException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addAuthor(null);
        });

        String expectedMessage = "There isn't such author in authors";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(7)
    void removeAuthor() {
        int sizeBefore = lib.getAuthors().getAllItems().size();
        manager.removeAuthor(0);
        assertEquals(sizeBefore -1, lib.getAuthors().getAllItems().size());
    }

    @Test
    @Order(8)
    void removeAuthorException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.removeAuthor(-1);
        });

        String expectedMessage = "There isn't author with such id in authors";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(9)
    void addItem() {
        int sizeBefore = lib.getItems().getAllItems().size();
        manager.addItem(podcast);
        assertEquals(sizeBefore +1, lib.getItems().getAllItems().size());
    }

    @Test
    @Order(10)
    void addItemException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem(null);
        });

        String expectedMessage = "There isn't such media item in items";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(11)
    void removeItem() {
        int sizeBefore = lib.getItems().getAllItems().size();
        manager.removeItem(0);
        assertEquals(sizeBefore - 1, lib.getItems().getAllItems().size());
    }

    @Test
    @Order(12)
    void removeItemException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.removeItem(-1);
        });

        String expectedMessage = "There isn't author with such id in authors";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @Order(13)
    @ValueSource(ints = {2})
    void isIdExists(int id) {
       assertTrue(manager.isIdExists(id));
    }
}