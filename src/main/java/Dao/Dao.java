package Dao;

import model.item.ItemKind;

import java.util.List;

public interface Dao<T> {

    public abstract List<T> search(ItemKind itemKind);
}
