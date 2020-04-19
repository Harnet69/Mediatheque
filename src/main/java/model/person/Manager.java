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
        if(category != null) {
            library.getCategories().addItem(category);
        } else {
            throw new IllegalArgumentException("There isn't such category in categories");
        }
    }

    public void removeCategory(Category category){
        if(category != null) {
            library.getCategories().removeItem(category);
        } else {
            throw new IllegalArgumentException("There isn't such category in categories");
        }
    }

    public void removeCategory(int id){
        if(isIdExists(id)) {
            library.getCategories().removeItem(id);
        } else {
            throw new IllegalArgumentException("There isn't category with such id in categories");
        }
    }

    // CRUD for authors
    public void addAuthor(Author author){
        if(author != null) {
            library.getAuthors().addItem(author);
        }else {
            throw new IllegalArgumentException("There isn't such author in authors");
        }
    }

    public void removeAuthor(Author author){
        if(author != null) {
            library.getAuthors().removeItem(author);
        }else {
            throw new IllegalArgumentException("There isn't such author in authors");
        }
    }

    public void removeAuthor(int id){
        if(isIdExists(id)) {
            library.getAuthors().removeItem(id);
        }else {
            throw new IllegalArgumentException("There isn't author with such id in authors");
        }
    }

    // CRUD for items
    public void addItem(MediaItem mediaItem){
        if(mediaItem != null) {
            library.getItems().addItem(mediaItem);
        }else {
            throw new IllegalArgumentException("There isn't such media item in items");
        }
    }

    public void removeItem(MediaItem mediaItem){
        if(mediaItem != null) {
            library.getItems().removeItem(mediaItem);
        }else {
            throw new IllegalArgumentException("There isn't such media item in items");
        }
    }

    public void removeItem(int id){
        if(isIdExists(id)) {
            library.getItems().removeItem(id);
        }else {
                throw new IllegalArgumentException("There isn't author with such id in authors");
            }
    }

    public boolean isIdExists(int id) {
        return library.getItems().getAllItems().parallelStream().anyMatch(e -> e.getId() == id);
    }
}