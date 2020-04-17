package model.person;

public class Author {
    private int id;
    private static int idCounter = 0;
    private String name;

    public Author(String name) {
        this.id = idCounter;
        this.name = name;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
