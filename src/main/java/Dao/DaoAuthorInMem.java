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
        List<Author> author = authors.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());
        return author.get(0);
    }

    @Override
    public void addItem(Author item) {
        authors.add(item);
    }

    @Override
    public void removeItem(Author item) {
        authors.remove(item);
    }

    @Override
    public void removeItem(int id) {
        authors.removeIf(author -> author.getId() == id);
    }
}
