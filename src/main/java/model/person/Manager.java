package model.person;

import model.Mediatheque;
import model.category.Category;
import model.item.MediaItem;

public class Manager extends Person {
    private static int idCounter = 0;
    private Mediatheque library = Mediatheque.getInstance();

    public Manager(String name, String login, boolean isManager) {
        super(name, login, isManager);
        this.setId(idCounter);
        idCounter++;
    }

    // CRUD for categories
    public void addCategory(Category category){
        library.getCategories().addItem(category);
    }

    public void removeCategory(Category category){
        library.getCategories().removeItem(category);
    }

    public void removeCategory(int id){
        library.getCategories().removeItem(id);
    }

    // CRUD for authors
    public void addAuthor(Author author){
        library.getAuthors().addItem(author);
    }

    public void removeAuthor(Author author){
        library.getAuthors().removeItem(author);
    }

    public void removeAuthor(int id){
        library.getAuthors().removeItem(id);
    }

    // CRUD for items
    public void addItem(MediaItem mediaItem){
        library.getItems().addItem(mediaItem);
    }

    public void removeItem(MediaItem mediaItem){
        library.getItems().removeItem(mediaItem);
    }

    public void removeItem(int id){
        library.getItems().removeItem(id);
    }
}