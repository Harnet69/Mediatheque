package Dao;

import model.category.Category;
import model.person.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoCategoryInMem implements Dao<Category> {
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllItems() {
        return categories;
    }

    @Override
    public Category getItemById(int id) {
        if(isIdExists(id)) {
            List<Category> category = categories.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return category.get(0);
        }else{
            throw new IllegalArgumentException("There isn't such id in category");
        }
    }

    @Override
    public void addItem(Category item) {
        categories.add(item);
    }

    @Override
    public void removeItem(Category item) {
        categories.remove(item);

    }

    @Override
    public void removeItem(int id) {
        categories.removeIf(category -> category.getId() == id);
    }

    @Override
    public boolean isIdExists(int id) {
        return categories.parallelStream().anyMatch(e-> e.getId() == id);
    }
}
