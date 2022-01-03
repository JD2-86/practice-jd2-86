package repo.impl;

import model.Hero;
import repo.HeroRepo;
import repo.IdProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class HeroRepoImpl implements HeroRepo {
    private final List<Hero> heroes = new ArrayList<>();
    private final IdProvider idProvider = IdProviderImpl.getInstance();
    private static final HeroRepo INSTANCE = new HeroRepoImpl();

    @Override
    public Hero add(Hero hero) {
        hero.setId(idProvider.addId());
        heroes.add(hero);
        return hero;
    }

    @Override
    public List<Hero> add(List<Hero> heroes) {
        heroes.forEach(hero -> hero.setId(idProvider.addId()));
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
