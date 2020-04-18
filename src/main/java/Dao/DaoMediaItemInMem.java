package Dao;

import model.Mediatheque;
import model.item.MediaItem;
import model.person.Author;

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
        List<MediaItem> item = items.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());
        return item.get(0);
    }

    @Override
    public void addItem(MediaItem item) {
        item.setId(idCounter);
        items.add(item);
        idCounter++;
    }

    @Override
    public void removeItem(MediaItem item) {
        items.remove(item);
    }

    @Override
    public void removeItem(int id) {
        items.removeIf(item -> item.getId() == id);
    }
}
