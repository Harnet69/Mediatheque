package Dao;

import model.person.Author;
import model.person.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoManagerInMem implements Dao<Manager> {
    private List<Manager> managers = new ArrayList<>();
    private static int idCounter = 0;

    @Override
    public List<Manager> getAllItems() {
        return managers;
    }

    @Override
    public Manager getItemById(int id) {
        List<Manager> manager = managers.stream()
                .filter(x -> x.getId() == id)
                .collect(Collectors.toList());
        return manager.get(0);
    }

    @Override
    public void addItem(Manager item) {
        item.setId(idCounter);
        managers.add(item);
        idCounter++;
    }

    @Override
    public void removeItem(Manager item) {
        managers.remove(item);
    }

    @Override
    public void removeItem(int id) {
        managers.removeIf(manager -> manager.getId() == id);
    }
}
