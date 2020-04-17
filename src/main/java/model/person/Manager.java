package model.person;

import model.Mediatheque;
import model.item.MediaItem;

public class Manager extends Person {
    private static int idCounter = 0;

    public Manager(String name, String login, boolean isManager) {
        super(name, login, isManager);
        this.setId(idCounter);
        idCounter++;
    }

    public void addItem(MediaItem mediaItem){
        Mediatheque.getInstance().getItems().addItem(mediaItem);
    }

    public void removeItem(MediaItem mediaItem){
        Mediatheque.getInstance().getItems().removeItem(mediaItem);
    }
}
