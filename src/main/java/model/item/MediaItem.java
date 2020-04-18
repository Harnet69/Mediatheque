package model.item;

import model.category.Category;
import model.person.Author;

public abstract class MediaItem {
    private int id;
    private String name;
    private Category category;
    private Author author;
    private int releaseYear;
    private boolean isRented = false;

    public MediaItem(String name, Category category, Author author, int release) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.releaseYear = release;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public abstract void preview();

}
