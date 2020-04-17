package Dao;

import model.item.Book;
import model.item.ItemKind;

import java.util.ArrayList;
import java.util.List;

public class DaoBook implements Dao<Book> {
    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> search(ItemKind itemKind) {
        return books;
    }
}
