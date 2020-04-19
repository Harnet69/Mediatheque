package Dao;

import model.person.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoUserInMem implements Dao<User> {
    private static int idCounter = 0;
    List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllItems() {
        return users;
    }

    @Override
    public User getItemById(int id) {
        if (isIdExists(id)) {
            List<User> user = users.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return user.get(0);
        } else {
            throw new IllegalArgumentException("There isn't such id in users");
        }
    }

    @Override
    public void addItem(User item) {
        if (item != null) {
            item.setId(idCounter);
            idCounter++;
            users.add(item);
        } else {
            throw new IllegalArgumentException("There isn't such item in users");
        }
    }

    @Override
    public void removeItem(User item) {
        if (item != null) {
            users.remove(item);
        }else {
            throw new IllegalArgumentException("There isn't such item in users");
        }
    }

    @Override
    public void removeItem(int id) {
        if (isIdExists(id)) {
            users.removeIf(user -> user.getId() == id);
        } else {
            throw new IllegalArgumentException("There isn't such id in users");
        }
    }

    @Override
    public boolean isIdExists(int id) {
        return users.parallelStream().anyMatch(e -> e.getId() == id);
    }
}
