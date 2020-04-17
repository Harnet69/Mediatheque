package model.item;

import model.person.Author;

import java.util.Date;

public abstract class MediaItem {
    private int id;
    private Author author;
    private double length;
    private Date release;

    public MediaItem(Author author, double length, Date release) {
        this.author = author;
        this.length = length;
        this.release = release;
    }

    public abstract boolean add();
    public abstract boolean remove(int id);
}
