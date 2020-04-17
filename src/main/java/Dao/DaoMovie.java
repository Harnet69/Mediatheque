package Dao;

import model.item.MediaItem;
import model.item.Movie;

import java.util.ArrayList;
import java.util.List;

public class DaoMovie implements Dao<Movie> {
    private List<Movie> movies = new ArrayList<>();


    @Override
    public List<Movie> getAllItems() {
        return movies;
    }

    @Override
    public void addItem(Movie item) {
        movies.add(item);
    }
}
