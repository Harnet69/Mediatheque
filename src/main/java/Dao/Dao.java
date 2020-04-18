package Dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAllItems();

    T getItemById(int id);

    void addItem(T item);

    void removeItem(T item);

    void removeItem(int id);
}
