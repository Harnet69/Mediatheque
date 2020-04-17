package model;

import Dao.DaoMediaItem;
import model.item.MediaItem;

import java.util.List;
import java.util.stream.Collectors;

public class Mediatheque {
    private static Mediatheque instance = null;
    private DaoMediaItem items = new DaoMediaItem();

    private Mediatheque() {
    }

    public static Mediatheque getInstance() {
        if(instance == null){
            instance = new Mediatheque();
        }
        return instance;
    }

    public void addItem(MediaItem mediaItem){
        items.addItem(mediaItem);
    }

    public List<MediaItem> search(String category){
        return items.getAllItems().stream()
                .filter(x -> x.getCategory().getName().equals(category))
                .collect(Collectors.toList());
    }
}
