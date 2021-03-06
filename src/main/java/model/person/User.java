package model.person;

import model.Mediatheque;
import model.item.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private static int idCounter = 0;
    private Mediatheque library = Mediatheque.getInstance();
    private List<MediaItem> rentedItems = new ArrayList<>();
    private List<MediaItem> reservedItems = new ArrayList<>();

    public User(String name, String login, boolean isManager) {
        super(name, login, isManager);
        this.setId(idCounter);
        idCounter++;
    }

    public List<MediaItem> getRentedItems() {
        return rentedItems;
    }

    public List<MediaItem> getReservedItems() {
        return reservedItems;
    }

    public void preview(MediaItem item) {
        if (item != null) {
            item.preview();
        }else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public void rent(int id) {
        if (isIdExists(id)) {
            MediaItem rentedItem = library.getItems().getItemById(id);
            rentedItems.add(rentedItem);
            rentedItem.setRented(true);
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public void returnMedia(int id) {
        if (isIdExists(id)) {
            if (isRented(id)) {
                library.getItems().getItemById(id).setRented(false);
            }
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public boolean isRented(int id) {
        if (isIdExists(id)) {
            return !library.getItems().getItemById(id).isRented();
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public void reserve(int id) {
        if (isIdExists(id)) {
            if (isRented(id)) {
                MediaItem itemForReserve = library.getItems().getItemById(id);
                reservedItems.add(itemForReserve);
                itemForReserve.setReservedBy(this);
            }
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public void reservationCancel(int id) {
        if (isIdExists(id)) {
            reservedItems.removeIf(item -> item.getId() == id);
            library.getItems().getItemById(id).setReservedBy(null);
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    public boolean isIdExists(int id) {
        return library.getItems().getAllItems().parallelStream().anyMatch(e -> e.getId() == id);
    }
}