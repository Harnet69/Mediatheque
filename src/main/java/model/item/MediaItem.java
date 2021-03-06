package model.item;

import model.category.Category;
import model.person.Author;
import model.person.User;

public abstract class MediaItem {
    private int id;
    private String name;
    private Category category;
    private Author author;
    private int releaseYear;
    private boolean isRented = false;
    private User reservedBy = null;

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
        if(id >= 0) {
            this.id = id;
        }else{
            throw new IllegalArgumentException("Id can't be a negative number!");
        }
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

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public abstract void preview();
}
