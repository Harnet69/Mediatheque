package model;

import Dao.DaoMediaItemInMem;
import model.item.MediaItem;

import java.util.List;
import java.util.stream.Collectors;

public class Mediatheque {
    private static Mediatheque instance = null;
    private DaoMediaItemInMem items = new DaoMediaItemInMem();

    private Mediatheque() {
    }

    public static Mediatheque getInstance() {
        if(instance == null){
            instance = new Mediatheque();
        }
        return instance;
    }

    public DaoMediaItemInMem getItems() {
        return items;
    }

    public void showItems(){
        for(MediaItem item : items.getAllItems()){
            System.out.println(item.getId() + " : " + item.getName() + " " + item.getCategory().getName() +
                    " " + item.getReleaseYear() + " " + item.getAuthor().getName());
        }
    }

    public List<MediaItem> search(String category){
        return items.getAllItems().stream()
                .filter(x -> x.getCategory().getName().equals(category))
                .collect(Collectors.toList());
    }
}
