package Dao;

import model.item.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class DaoMediaItem implements Dao<MediaItem> {
    private List<MediaItem> items = new ArrayList<>();

    @Override
    public List<MediaItem> getAllItems() {
        return items;
    }

    @Override
    public void addItem(MediaItem item) {
        items.add(item);
    }
}
