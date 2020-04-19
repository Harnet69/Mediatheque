package model.item;

import model.category.Category;
import model.person.Author;

public class Movie extends MediaItem implements Watchable {
    private double length;

    public Movie(String name, Category category, Author author, double length, int release) {
        super(name, category, author, release);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void watch() {
        System.out.println("Watch the movie");
    }

    @Override
    public void preview() {
        System.out.println("Preview a movie " + getName());
//        watch();
    }
}
