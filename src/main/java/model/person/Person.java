package model.person;

public abstract class Person {
    private int id;
    private String name;
    private String login;
    private boolean isManager;

    public Person(String name, String login, boolean isManager) {
        if (!isStringEmpty(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name field is empty!");
//            throw new RuntimeException("Name or login field is empty!");
        }
        if (!isStringEmpty(login)) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("Login field is empty!");
        }
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
        if(id >= 0) {
            this.id = id;
        }else{
            throw new IllegalArgumentException("Id can't be a negative number!");
        }
    }

    private boolean isStringEmpty(String string) {
        return string.length() == 0;
    }
}
