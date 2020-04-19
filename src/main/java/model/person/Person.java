package model.person;

public abstract class Person {
    private int id;
    private String name;
    private String login;
    private boolean isManager;

    public Person(String name, String login, boolean isManager) {
        if(!isStringEmpty(name) || !isStringEmpty(login)){
            this.name = name;
            this.login = login;
        }else{
            throw new IllegalArgumentException("Name or login field is empty!");
//            throw new RuntimeException("Name or login field is empty!");
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
        this.id = id;
    }

    private boolean isStringEmpty(String string){
        return string.length() == 0;
    }
}
