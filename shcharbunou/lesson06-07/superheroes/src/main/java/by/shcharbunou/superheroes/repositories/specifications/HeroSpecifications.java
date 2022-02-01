package by.shcharbunou.superheroes.repositories.specifications;

import by.shcharbunou.superheroes.entities.Hero;

import java.util.Objects;

public class HeroSpecifications {
    private static class RealNameSpec implements Specification<Hero> {
        private final String realName;

        public RealNameSpec(String realName) {
            this.realName = realName;
        }

        @Override
        public boolean isExist(Hero hero) {
            return Objects.equals(hero.getRealName(), realName);
        }
    }
}
