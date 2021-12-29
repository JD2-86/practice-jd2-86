package repo;

import model.Hero;

import java.util.List;

public interface HeroRepo {
    Hero addAll(Hero hero);
    List<Hero> addAll(List<Hero> heroes);
    List<Hero> getHeroes();
}
