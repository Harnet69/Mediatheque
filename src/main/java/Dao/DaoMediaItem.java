package Dao;

import model.item.MediaItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoMediaItem implements Dao<MediaItem> {
    private static int idCounter = 0;
    private List<MediaItem> items = new ArrayList<>();

    @Override
    public List<MediaItem> getAllItems() {
        return items;
    }

    @Override
    public List<MediaItem> getItemById(int id) {
        return items.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public void addItem(MediaItem item) {
        item.setId(idCounter);
        items.add(item);
        idCounter++;
    }
}
