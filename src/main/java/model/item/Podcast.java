package model.item;

import model.person.Author;

import java.util.Date;

public class Podcast extends MediaItem implements Listenable {
    private double length;

    public Podcast(String name, Author author, double length, int release) {
        super(name, author, release);
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
