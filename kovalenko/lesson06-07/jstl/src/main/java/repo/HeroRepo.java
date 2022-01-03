package repo;

import model.Hero;

import java.util.List;

public interface HeroRepo {
    Hero add(Hero hero);
    List<Hero> add(List<Hero> heroes);
    List<Hero> getHeroes();
}
