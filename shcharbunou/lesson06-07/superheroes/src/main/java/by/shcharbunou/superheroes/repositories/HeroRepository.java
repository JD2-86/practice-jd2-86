package by.shcharbunou.superheroes.repositories;

import by.shcharbunou.superheroes.entities.Hero;
import by.shcharbunou.superheroes.repositories.specifications.Specification;
import by.shcharbunou.superheroes.repositories.storage.HeroStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class HeroRepository implements Repository<Hero> {
    private Map<Long, Hero> database;
    public AtomicLong id = new AtomicLong(2);

    public HeroRepository() {
        database = HeroStorage.getInstance().getDatabase();
    }

    @Override
    public void add(Hero hero) {
        database.put(id.incrementAndGet(), hero);
    }

    @Override
    public void add(Long id, Hero hero) {
        database.put(id, hero);
    }

    @Override
    public Hero get(Long id) {
        return database.get(id);
    }

    @Override
    public boolean find(Long id) {
        return database.containsKey(id);
    }

    @Override
    public Map<Long, Hero> getAll() {
        return database;
    }

    @Override
    public Map<Long, Hero> findBySpecification(Specification specification) {
        Map<Long, Hero> temporaryDatabase = new HashMap<>();
        for (Map.Entry<Long, Hero> heroEntry : database.entrySet()) {
            if (specification.isExist(heroEntry.getValue())) {
                temporaryDatabase.put(heroEntry.getKey(), heroEntry.getValue());
            }
        }
        return temporaryDatabase;
    }

    @Override
    public void update(Hero oldHero, Hero newHero) {
        for (Map.Entry<Long, Hero> heroEntry : database.entrySet()) {
            if (heroEntry.getValue() == oldHero) {
                long temporaryId = heroEntry.getKey();
                database.replace(temporaryId, oldHero, newHero);
            }
        }
    }

    @Override
    public void remove(long id) {
        database.remove(id);
    }

    public Map<Long, Hero> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Long, Hero> database) {
        this.database = database;
    }

    public AtomicLong getId() {
        return id;
    }
}
