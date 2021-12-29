package repo.impl;

import model.Hero;
import repo.HeroRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class HeroRepoImpl implements HeroRepo {
    private final List<Hero> heroes = new ArrayList<>();
    private final AtomicLong idProvider = new AtomicLong();
    private static final HeroRepo INSTANCE = new HeroRepoImpl();

    @Override
    public Hero addAll(Hero hero) {
        Long id = idProvider.incrementAndGet();
        hero.setId(id);
        heroes.add(hero);
        return hero;
    }

    @Override
    public List<Hero> addAll(List<Hero> heroes) {
        heroes.forEach(hero -> hero.setId(idProvider.incrementAndGet()));
        this.heroes.addAll(heroes);
        return heroes;
    }

    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }

    private HeroRepoImpl() {
    }

    public static HeroRepo getInstance() {
        return INSTANCE;
    }
}
