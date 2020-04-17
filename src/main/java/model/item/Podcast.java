package model.item;

import model.category.Category;
import model.person.Author;

public class Podcast extends MediaItem implements Listenable {
    private double length;

    public Podcast(String name, Category category, Author author, double length, int release) {
        super(name, category, author, release);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void listen() {
        System.out.println("Listen to podcast");
    }
}
