package model.item;

public enum ItemKind {
    BOOK ("book"),
    MOVIE ("movie"),
    PODCAST ("podcast");

    private String kind;

    ItemKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return kind;
    }
}
