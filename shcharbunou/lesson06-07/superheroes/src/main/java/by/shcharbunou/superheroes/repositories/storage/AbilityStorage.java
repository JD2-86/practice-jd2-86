package by.shcharbunou.superheroes.repositories.storage;

import by.shcharbunou.superheroes.entities.Ability;

import java.util.HashMap;
import java.util.Map;

public class AbilityStorage {
    private Map<Long, Ability> database;
    private static AbilityStorage instance = null;

    private AbilityStorage() {
        this.database = new HashMap<>();
        database.put(1L, Ability.WEALTH);
        database.put(2L, Ability.INVISIBILITY);
        database.put(3L, Ability.FLIGHT);
        database.put(4L, Ability.REGENERATION);
        database.put(5L, Ability.POWER);
        database.put(6L, Ability.SPEED);
        database.put(7L, Ability.TELEPATHY);
        database.put(8L, Ability.ELEMENT_CONTROL);
    }

    public static AbilityStorage getInstance() {
        AbilityStorage localInstance = instance;
        if (localInstance == null) {
            synchronized (AbilityStorage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AbilityStorage();
                }
            }
        }
        return localInstance;
    }

    public Map<Long, Ability> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Long, Ability> database) {
        this.database = database;
    }

    public static void setInstance(AbilityStorage instance) {
        AbilityStorage.instance = instance;
    }
}
