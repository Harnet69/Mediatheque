package model;

import Dao.DaoMediaItem;
import model.item.MediaItem;

import java.util.List;
import java.util.stream.Collectors;

public class Mediatheque {
    private static Mediatheque instance = null;
    private int idCounter = 0;
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
        mediaItem.setId(idCounter);
        items.addItem(mediaItem);
        idCounter++;
    }

    public List<MediaItem> search(String category){
        return items.getAllItems().stream()
                .filter(x -> x.getCategory().getName().equals(category))
                .collect(Collectors.toList());
    }
}
