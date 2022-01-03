package service.impl;

import exception.HeroNotFoundException;
import model.Hero;
import repo.HeroRepo;
import repo.impl.HeroRepoImpl;
import service.HeroService;

import java.util.List;

public class HeroServiceImpl implements HeroService {
    private final HeroRepo heroRepo = HeroRepoImpl.getInstance();
    private static final HeroService INSTANCE = new HeroServiceImpl();

    @Override
    public List<Hero> getHeroes() {
        return heroRepo.getHeroes();
    }

    @Override
    public Hero add(Hero hero) {
        return heroRepo.add(hero);
    }

    @Override
    public List<Hero> add(List<Hero> heroes) {
        return heroRepo.add(heroes);
    }

    @Override
    public Hero getById(Long id) {
        return heroRepo.getHeroes().stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .orElseThrow(HeroNotFoundException::new);
    }

    private HeroServiceImpl(){}

    public static HeroService getInstance(){
        return INSTANCE;
    }
}
