package by.zhigalko.storage;

import by.zhigalko.entity.Ability;
import by.zhigalko.entity.Gender;
import by.zhigalko.entity.SuperHero;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class HeroStorage extends Storage{
    private final Map<Long, SuperHero> database;
    private static volatile HeroStorage instance = null;

    private HeroStorage() {
        database = new HashMap<>();
        SuperHero superMan = new SuperHero("Супермэн", "Кларк Кент",
                Gender.MALE, 40, Ability.FLIGHT);
        SuperHero invisibleWoman = new SuperHero("Женщина-невидимка", "Сьюзан «Сью» Шторм-Ричардс",
                Gender.FEMALE, 38, Ability.INVISIBILITY);
        database.put(id.incrementAndGet(),superMan);
        database.put(id.incrementAndGet(),invisibleWoman);
    }

    public static HeroStorage getInstance() {
        if (instance == null) {
            synchronized (HeroStorage.class) {
                if (instance == null) {
                    instance = new HeroStorage();
                }
            }
        }
        return instance;
    }

    public SuperHero getSuperHeroFromDB(Long id) {
        return database.get(id);
    }

    public boolean findSuperHeroInDB(Long id) {
        return database.containsKey(id);
    }

    public void putSuperHeroIntoDB(SuperHero superHero) {
        database.put(id.incrementAndGet(), superHero);
    }

    public void putSuperHeroIntoDB(Long id, SuperHero superHero) {
        database.put(id, superHero);
    }

    public Map<Long, SuperHero> getDatabase() {
        return database;
    }
}
