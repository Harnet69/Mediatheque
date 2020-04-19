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

    @Override
    public boolean isIdExists(int id) {
        return authors.parallelStream().anyMatch(e-> e.getId() == id);
    }
}
