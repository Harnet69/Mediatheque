package model.item;

import model.category.Category;
import model.person.Author;

public class Book extends MediaItem implements Readable {
    int numOfString;

    public Book(String name, Category category, Author author, int release, int numOfString) {
        super(name, category, author, release);
        this.numOfString = numOfString;
    }

    public int getNumOfString() {
        return numOfString;
    }

    @Override
    public void read() {
        System.out.println("Read the book");
    }
}
