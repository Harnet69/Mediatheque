package model;

import Dao.DaoAuthorInMem;
import Dao.DaoCategoryInMem;
import Dao.DaoMediaItemInMem;
import model.category.Category;
import model.category.CategoryKind;
import model.item.Book;
import model.person.Author;
import model.person.Manager;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediathequeTest {
    private Mediatheque library = Mediatheque.getInstance();
    private DaoMediaItemInMem items = new DaoMediaItemInMem();
    private DaoAuthorInMem authors = new DaoAuthorInMem();
    private DaoCategoryInMem categories = new DaoCategoryInMem();
    private Manager manager = new Manager("Adam", "adam", true);

    @Before
    public void setUp() {
        manager.addItem(new Book("The Hobbit", new Category(CategoryKind.BOOK.toString(), "Item for reading"),
                new Author("Tolkien"), 1937, 358));
    }

    @Test
    void getInstance() {
        assertEquals(library, Mediatheque.getInstance());
    }

    @Test
    void getItems() {
        assertEquals(library.getItems().getAllItems(), items.getAllItems());
    }

    @Test
    void getAuthors() {
        assertEquals(library.getAuthors().getAllItems(), authors.getAllItems());
    }

    @Test
    void getCategories() {
        assertEquals(library.getCategories().getAllItems(), categories.getAllItems());
    }

    @Test
    void showItems() {
    }

    @Test
    void showReservedItems() {

    }

    @Test
    void search() {
    }

}