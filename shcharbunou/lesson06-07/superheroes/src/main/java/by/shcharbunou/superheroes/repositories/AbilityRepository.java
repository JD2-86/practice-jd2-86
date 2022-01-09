package by.shcharbunou.superheroes.repositories;

import by.shcharbunou.superheroes.entities.Ability;
import by.shcharbunou.superheroes.repositories.storage.AbilityStorage;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AbilityRepository {
    private Map<Long, Ability> database;
    public AtomicLong id = new AtomicLong(8);

    public AbilityRepository() {
        database = AbilityStorage.getInstance().getDatabase();
    }

    public Map<Long, Ability> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Long, Ability> database) {
        this.database = database;
    }

    public AtomicLong getId() {
        return id;
    }

    public void setId(AtomicLong id) {
        this.id = id;
    }

    public Ability getAbilityByDesignation(String abilityDesignation) {
        for (Map.Entry<Long, Ability> abilityEntry : database.entrySet()) {
            if (abilityEntry.getValue().getAbilityDesignation().equals(abilityDesignation)) {
                return abilityEntry.getValue();
            }
        }
        return null;
    }
}
