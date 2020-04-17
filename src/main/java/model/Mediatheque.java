package model;

import Dao.DaoBook;
import Dao.DaoMovie;
import Dao.DaoPodcast;
import model.item.ItemKind;
import model.item.MediaItem;

import java.util.List;

public class Mediatheque {
    private static Mediatheque instance = null;
    private DaoBook books = new DaoBook();
    private DaoMovie movies = new DaoMovie();
    private DaoPodcast podcasts = new DaoPodcast();

    private Mediatheque() {
    }

    public static Mediatheque getInstance() {
        if(instance == null){
            instance = new Mediatheque();
        }
        return instance;
    }

    public DaoBook getBooks() {
        return books;
    }

    public DaoMovie getMovies() {
        return movies;
    }

    public DaoPodcast getPodcasts() {
        return podcasts;
    }

    // search by kind
    public List<? extends MediaItem> search(ItemKind itemKind){
        switch (itemKind){
            case BOOK: return books.getAllItems();
            case MOVIE: return movies.getAllItems();
            case PODCAST: return podcasts.getAllItems();
        }
        return null;
    }

//    // search by kind
//    public MediaItem search(ItemKind itemKind){
//        return null;
//    }
}
