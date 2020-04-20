package model.person;

import model.Mediatheque;
import model.category.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Mediatheque lib = Mediatheque.getInstance();
    Manager manager = new Manager("Adam", "adam", true);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addCategory() {
        int sizeBefore = lib.getCategories().getAllItems().size();
        manager.addCategory(new Category("books", "Smth to read"));
        assertEquals(sizeBefore + 1, lib.getCategories().getAllItems().size());
        assertEquals("books", lib.getCategories().getAllItems().get(0).getName());
    }

    @Test
    public void removeCategory() {
        Category cat = new Category("books", "Smth to read");
        manager.addCategory(new Category("books", "Smth to read"));
        int sizeBeforeRemoving = lib.getCategories().getAllItems().size();
        manager.removeCategory(cat);
        int sizeAfterRemoving = lib.getCategories().getAllItems().size();
        assertEquals(sizeAfterRemoving, lib.getCategories().getAllItems().size());
    }

    @Test
    public void testRemoveCategory() {
    }

    @Test
    public void addAuthor() {
    }

    @Test
    public void removeAuthor() {
    }

    @Test
    public void testRemoveAuthor() {
    }

    @Test
    public void addItem() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void testRemoveItem() {
    }

    @Test
    public void isIdExists() {
    }
}