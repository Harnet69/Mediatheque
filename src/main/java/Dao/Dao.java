package Dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAllItems();

    void addItem(T item);
}
