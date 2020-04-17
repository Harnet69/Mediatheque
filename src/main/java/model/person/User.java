package model.person;

import model.item.MediaItem;

public class User extends Person {
    private static int idCounter = 0;

    public User(String name, String login, boolean isManager) {
        super(name, login, isManager);
        this.setId(idCounter);
        idCounter++;
    }

    public void preview(MediaItem item){
        System.out.println("Preview an item");
    }
}
