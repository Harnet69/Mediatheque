package Dao;

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
        if (isIdExists(id)) {
            List<Manager> manager = managers.stream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList());
            return manager.get(0);
        }else {
            throw new IllegalArgumentException("There isn't such id in managers");
        }
    }

    @Override
    public void addItem(Manager item) {
        if(item != null) {
            item.setId(idCounter);
            managers.add(item);
            idCounter++;
        }else {
            throw new IllegalArgumentException("There isn't such item in managers");
        }
    }

    @Override
    public void removeItem(int id) {
        if (isIdExists(id)) {
            managers.removeIf(manager -> manager.getId() == id);
        } else {
            throw new IllegalArgumentException("There isn't such id in managers");
        }
    }

    @Override
    public boolean isIdExists(int id) {
        return managers.parallelStream().anyMatch(e -> e.getId() == id);
    }
}
