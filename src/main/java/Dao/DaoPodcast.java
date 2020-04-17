package Dao;

import model.item.ItemKind;
import model.item.Podcast;

import java.util.ArrayList;
import java.util.List;

public class DaoPodcast implements Dao<Podcast> {
    private List<Podcast> podcasts = new ArrayList<>();


    @Override
    public List<Podcast> getAllItems() {
        return podcasts;
    }

    @Override
    public void addItem(Podcast item) {
        podcasts.add(item);
    }
}