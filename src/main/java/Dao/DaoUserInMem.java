package Dao;

import model.person.Author;
import model.person.User;

import java.time.chrono.IsoChronology;
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
    public User getItemById(int id) {
        if(isIdExists(id)) {
            List<User> user = users.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return user.get(0);
        }else{
            throw new IllegalArgumentException("There isn't such id in users");
        }
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

    @Override
    public boolean isIdExists(int id) {
        return users.parallelStream().anyMatch(e-> e.getId() == id);
    }
}
