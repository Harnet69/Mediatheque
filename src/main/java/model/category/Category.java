package model.category;

public class Category {
    private String name;
    private String describing;

    public Category(String name, String describing) {
        this.name = name;
        this.describing = describing;
    }

    public String getName() {
        return name;
    }

    public String getDescribing() {
        return describing;
    }
}
