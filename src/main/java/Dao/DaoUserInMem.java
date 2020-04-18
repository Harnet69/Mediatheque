package Dao;

import model.person.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoUserInMem implements Dao<User> {
    List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllItems() {
        return users;
    }

    @Override
    public List<User> getItemById(int id) {
        return users.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public void addItem(User item) {
        users.add(item);
    }

    @Override
    public void removeItem(User item) {
        users.remove(item);
        }

    @Override
    public void removeItem(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
