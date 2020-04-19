package model;

import Dao.*;
import model.item.MediaItem;

import java.util.List;
import java.util.stream.Collectors;

public class Mediatheque {
    private static Mediatheque instance = null;
//    private DaoManagerInMem managers = new DaoManagerInMem();
//    private DaoUserInMem users = new DaoUserInMem();
    private DaoAuthorInMem authors = new DaoAuthorInMem();
    private DaoCategoryInMem categories = new DaoCategoryInMem();
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

//    public DaoManagerInMem getManagers() {
//        return managers;
//    }
//
//    public DaoUserInMem getUsers() {
//        return users;
//    }

    public DaoAuthorInMem getAuthors() {
        return authors;
    }

    public DaoCategoryInMem getCategories() {
        return categories;
    }

    public void showItems(boolean showRented){
        for(MediaItem item : items.getAllItems()){
            if(showRented) {
                System.out.println(item.getId() + " : " + item.getName() + " " + item.getCategory().getName() +
                        " " + item.getReleaseYear() + " " + item.getAuthor().getName());
            }else{
                if(!item.isRented()){
                    System.out.println(item.getId() + " : " + item.getName() + " " + item.getCategory().getName() +
                            " " + item.getReleaseYear() + " " + item.getAuthor().getName());
                }
            }
        }
    }

    public void showReservedItems(){
        for(MediaItem item : items.getAllItems()){
            if(item.getReservedBy() !=null) {
                System.out.println(item.getReservedBy().getName()+ " reserved: " + item.getCategory().getName()+ " " + item.getName());
            }
        }
    }

    public List<MediaItem> search(String category){
        return items.getAllItems().stream()
                .filter(x -> x.getCategory().getName().equals(category))
                .collect(Collectors.toList());
    }


}
