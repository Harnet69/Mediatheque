package Dao;

import model.person.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoAuthorInMem implements Dao<Author> {
    private List<Author> authors = new ArrayList<>();

    @Override
    public List<Author> getAllItems() {
        return authors;
    }

    @Override
    public Author getItemById(int id) {
        if (id >= 0 && isIdExists(id)) {
            List<Author> author = authors.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return author.get(0);
        } else {
            throw new IllegalArgumentException("There isn't such id in authors");
        }
    }

    @Override
    public void addItem(Author item) {
        if(item != null){
            authors.add(item);
        } else {
            throw new IllegalArgumentException("There isn't such item in authors");
        }
    }

    @Override
    public void removeItem(Author item) {
        if(item != null) {
            authors.remove(item);
        } else {
            throw new IllegalArgumentException("There isn't such item in authors");
        }
    }

    @Override
    public void removeItem(int id) {
        if (id >= 0 && isIdExists(id)) {
            authors.removeIf(author -> author.getId() == id);
        } else {
            throw new IllegalArgumentException("There isn't such id in authors");
        }
    }

    @Override
    public boolean isIdExists(int id) {
        return authors.parallelStream().anyMatch(e-> e.getId() == id);
    }
}
