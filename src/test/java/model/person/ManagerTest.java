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
    void removeCategory() {
        int sizeBefore = lib.getCategories().getAllItems().size();
        manager.removeCategory(0);
        assertEquals(lib.getCategories().getAllItems().size(), sizeBefore -1);
    }

    @Test
    @Order(3)
    void addAuthor() {
        int sizeBefore = lib.getAuthors().getAllItems().size();
        manager.addAuthor(Pratchet);
        assertEquals(sizeBefore +1, lib.getAuthors().getAllItems().size());
        assertEquals("Pratchet", lib.getAuthors().getItemById(3).getName());
    }

    @Test
    @Order(4)
    void removeAuthor() {
        int sizeBefore = lib.getAuthors().getAllItems().size();
        manager.removeAuthor(0);
        assertEquals(sizeBefore -1, lib.getAuthors().getAllItems().size());
    }

    @Test
    @Order(5)
    void addItem() {
        int sizeBefore = lib.getItems().getAllItems().size();
        manager.addItem(podcast);
        assertEquals(sizeBefore +1, lib.getItems().getAllItems().size());
    }

    @Test
    @Order(6)
    void removeItem() {
        int sizeBefore = lib.getItems().getAllItems().size();
        manager.removeItem(0);
        assertEquals(sizeBefore - 1, lib.getItems().getAllItems().size());
    }

    @ParameterizedTest
    @Order(7)
    @ValueSource(ints = {2})
    void isIdExists(int id) {
       assertTrue(manager.isIdExists(id));
    }

}