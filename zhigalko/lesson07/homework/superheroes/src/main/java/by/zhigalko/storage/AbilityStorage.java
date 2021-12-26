package by.zhigalko.storage;

import by.zhigalko.entity.Ability;

import java.util.HashMap;
import java.util.Map;

public class AbilityStorage extends Storage{
    private static volatile AbilityStorage instance = null;
    private final Map<Long, Ability> ability_db;

    private AbilityStorage() {
        ability_db = new HashMap<>();
        ability_db.put(id.incrementAndGet(),Ability.WEALTH);
        ability_db.put(id.incrementAndGet(),Ability.INVISIBILITY);
        ability_db.put(id.incrementAndGet(),Ability.FLIGHT);
        ability_db.put(id.incrementAndGet(),Ability.REGENERATION);
        ability_db.put(id.incrementAndGet(),Ability.SUPER_POWER);
        ability_db.put(id.incrementAndGet(),Ability.SUPER_SPEED);
        ability_db.put(id.incrementAndGet(),Ability.TELEPATHY);
        ability_db.put(id.incrementAndGet(),Ability.ELEMENT_CONTROL);
    }

    public static AbilityStorage getInstance() {
        if (instance == null) {
            synchronized (AbilityStorage.class) {
                if (instance == null) {
                    instance = new AbilityStorage();
                }
            }
        }
        return instance;
    }

    public Map<Long, Ability> getAbility_db() {
        return ability_db;
    }

    public Ability getAbilityByName(String nameOfAbility) {
        for (Map.Entry<Long, Ability> entry : ability_db.entrySet()) {
            if(entry.getValue().getNameOfAbility().equals(nameOfAbility)){
                return entry.getValue();
            }
        }
        return null;
    }
}
