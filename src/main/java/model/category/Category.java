package model.category;

public class Category {
    private int id;
    private static int idCounter = 0;
    private String name;
    private String describing;

    public Category(String name, String describing) {
        this.name = name;
        this.describing = describing;
        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescribing() {
        return describing;
    }
}
