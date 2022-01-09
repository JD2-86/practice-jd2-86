package by.shcharbunou.superheroes.repositories.storage;

import by.shcharbunou.superheroes.entities.Ability;
import by.shcharbunou.superheroes.entities.Gender;
import by.shcharbunou.superheroes.entities.Hero;

import java.util.HashMap;
import java.util.Map;

public class HeroStorage {
    private Map<Long, Hero> database;
    private static HeroStorage instance = null;

    private HeroStorage() {
        this.database = new HashMap<>();
        Hero superMan = new Hero("Супермэн", "Кларк Кент", 40,
                Gender.MALE, Ability.FLIGHT);
        Hero invisibleWoman = new Hero("Женщина-невидимка", "Сьюзан «Сью» Шторм-Ричардс", 38,
                Gender.FEMALE, Ability.INVISIBILITY);
        database.put(1L, superMan);
        database.put(2L, invisibleWoman);
    }

    public static HeroStorage getInstance() {
        HeroStorage localInstance = instance;
        if (localInstance == null) {
            synchronized (HeroStorage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new HeroStorage();
                }
            }
        }
        return localInstance;
    }

    public Map<Long, Hero> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Long, Hero> database) {
        this.database = database;
    }

    public static void setInstance(HeroStorage instance) {
        HeroStorage.instance = instance;
    }
}
