package model.item;

import model.person.Author;

import java.util.Date;

public class Movie extends MediaItem implements Watchable {
    private double length;

    public Movie(String name, Author author, double length, int release) {
        super(name, author, release);
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
