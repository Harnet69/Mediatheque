package model.category;

public enum CategoryKind {
    BOOK ("book"),
    MOVIE ("movie"),
    PODCAST ("podcast");

    private String kind;

    CategoryKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return kind;
    }
}
