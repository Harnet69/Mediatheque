package model;

import Dao.DaoBook;
import Dao.DaoMovie;
import Dao.DaoPodcast;
import model.item.ItemKind;
import model.item.MediaItem;

public class Mediatheque {
    private static Mediatheque instance = null;
    private DaoBook books = new DaoBook();
    private DaoMovie movie = new DaoMovie();
    private DaoPodcast daoPodcast = new DaoPodcast();

    private Mediatheque() {
    }

    public static Mediatheque getInstance() {
        if(instance == null){
            instance = new Mediatheque();
        }
        return instance;
    }

    // search by kind
    public MediaItem search(ItemKind itemKind){
        switch (itemKind){
            case BOOK: System.out.println("Search in books");
            break;
            case MOVIE: System.out.println("Search in movies");
                break;
            case PODCAST: System.out.println("Search in podcast");
                break;
        }
        return null;
    }

//    // search by kind
//    public MediaItem search(ItemKind itemKind){
//        return null;
//    }
}
