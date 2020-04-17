package model.item;

import model.person.Author;

import java.util.Date;

public abstract class MediaItem {
    private int id;
    private String name;
    private Author author;
    private int releaseYear;

    public MediaItem(String name, Author author, int release) {
        this.name = name;
        this.author = author;
        this.releaseYear = release;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getName() {
        return name;
    }
}
