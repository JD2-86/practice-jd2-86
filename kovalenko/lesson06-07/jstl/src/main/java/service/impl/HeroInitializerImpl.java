package service.impl;

import model.Gender;
import model.Hero;
import service.AbilityService;
import service.HeroInitializer;
import service.HeroService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeroInitializerImpl implements HeroInitializer {
    private static final String INITIAL_HERO_1_PSEUDONYM = "Супермен";
    private static final String INITIAL_HERO_1_REAL_NAME = "Кларк Кент";
    private static final Integer INITIAL_HERO_1_AGE = 40;
    private static final String INITIAL_HERO_1_ABILITY = "Полёт";
    private static final String INITIAL_HERO_2_PSEUDONYM = "Женщина-невидимка";
    private static final String INITIAL_HERO_2_REAL_NAME = "Сьюзен Шторм-Ричардс";
    private static final Integer INITIAL_HERO_2_AGE = 35;
    private static final String INITIAL_HERO_2_ABILITY = "Невидимость";
    private final HeroService heroService = HeroServiceImpl.getInstance();
    private final AbilityService abilityService = AbilityServiceImpl.getInstance();
    private final AtomicBoolean isInitHero = new AtomicBoolean();
    private static final HeroInitializer INSTANCE = new HeroInitializerImpl();

    @Override
    public int init() {
        List<Hero> heroes = new ArrayList<>();
        if (isInitHero.compareAndSet(false, true)) {
            heroes.add(new Hero(INITIAL_HERO_1_PSEUDONYM,
                    INITIAL_HERO_1_REAL_NAME,
                    INITIAL_HERO_1_AGE,
                    Gender.MALE,
                    abilityService.getByName(INITIAL_HERO_1_ABILITY)));
            heroes.add(new Hero(INITIAL_HERO_2_PSEUDONYM,
                    INITIAL_HERO_2_REAL_NAME,
                    INITIAL_HERO_2_AGE,
                    Gender.FEMALE,
                    abilityService.getByName(INITIAL_HERO_2_ABILITY)));
            heroService.add(heroes);
        }
        return heroes.size();
    }

    private HeroInitializerImpl() {
    }

    public static HeroInitializer getInstance() {
        return INSTANCE;
    }
}
