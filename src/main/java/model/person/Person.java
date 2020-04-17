package model.person;

public abstract class Person {
    private int id;
    private String name;
    private String login;
    private boolean isManager;

    public Person(String name, String login, boolean isManager) {
        this.name = name;
        this.login = login;
        this.isManager = isManager;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setId(int id) {
        this.id = id;
    }
}
