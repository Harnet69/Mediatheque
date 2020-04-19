package model.person;

public class Author {
    private int id;
    private static int idCounter = 0;
    private String name;

    public Author(String name) {
        this.id = idCounter;
        if(name.length() != 0){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name can't be empty!");
        }
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
