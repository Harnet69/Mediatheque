package model.person;

import model.Mediatheque;
import model.item.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private static int idCounter = 0;
    private List<MediaItem> rentedItems = new ArrayList<>();

    public User(String name, String login, boolean isManager) {
        super(name, login, isManager);
        this.setId(idCounter);
        idCounter++;
    }

    public List<MediaItem> getRentedItems() {
        return rentedItems;
    }

    public void preview(MediaItem item){
        item.preview();
    }

    public void rent(int id){
        MediaItem rentedItem = Mediatheque.getInstance().getItems().getItemById(id);
        rentedItems.add(rentedItem);
        rentedItem.setRented(true);
    }

    public void returnMedia(int id){
        for(MediaItem item : rentedItems){
            if(item.getId() == id){
                rentedItems.remove(item);
                Mediatheque.getInstance().getItems().getItemById(id).setRented(false);
            }
        }
    }
}
