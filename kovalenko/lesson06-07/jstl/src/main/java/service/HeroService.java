package service;

import model.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> getHeroes();

    Hero add(Hero hero);

    List<Hero> add(List<Hero> heroes);

    Hero getById(Long id);
}
