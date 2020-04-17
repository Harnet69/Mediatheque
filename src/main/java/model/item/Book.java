package model.item;

import model.person.Author;

public class Book extends MediaItem implements Readable {
    int numOfString;

    public Book(String name, Author author, int release, int numOfString) {
        super(name, author, release);
    }

    public int getNumOfString() {
        return numOfString;
    }
}
