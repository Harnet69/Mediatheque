package Dao;

import model.item.MediaItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoMediaItemInMem implements Dao<MediaItem> {
    private static int idCounter = 0;
    private List<MediaItem> items = new ArrayList<>();

    @Override
    public List<MediaItem> getAllItems() {
        return items;
    }

    @Override
    public MediaItem getItemById(int id) {
        if (isIdExists(id)) {
            List<MediaItem> item = items.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return item.get(0);
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    @Override
    public void addItem(MediaItem item) {
        if (item != null) {
            item.setId(idCounter);
            items.add(item);
            idCounter++;
        }else {
            throw new IllegalArgumentException("There isn't such item in media items");
        }
    }

    @Override
    public void removeItem(MediaItem item) {
        if (item != null) {
            items.remove(item);
        } else {
            throw new IllegalArgumentException("There isn't such item in media items");
        }
    }

    @Override
    public void removeItem(int id) {
        if (isIdExists(id)) {
            items.removeIf(item -> item.getId() == id);
        } else {
            throw new IllegalArgumentException("There isn't such id in media items");
        }
    }

    @Override
    public boolean isIdExists(int id) {
        return items.parallelStream().anyMatch(e -> e.getId() == id);
    }
}
