package service.impl;

import model.Ability;
import service.AbilityInitializer;
import service.AbilityService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AbilityInitializerImpl implements AbilityInitializer {
    private static final String INITIAL_ABILITY_1 = "Богатство";
    private static final String INITIAL_ABILITY_2 = "Невидимость";
    private static final String INITIAL_ABILITY_3 = "Полёт";
    private static final String INITIAL_ABILITY_4 = "Регенерация";
    private static final String INITIAL_ABILITY_5 = "Сверхсила";
    private static final String INITIAL_ABILITY_6 = "Сверхскорость";
    private static final String INITIAL_ABILITY_7 = "Телепатия";
    private static final String INITIAL_ABILITY_8 = "Управление стихией";
    private final AbilityService abilityService = AbilityServiceImpl.getInstance();
    private final AtomicBoolean isInitAbility = new AtomicBoolean();
    private static final AbilityInitializer INSTANCE = new AbilityInitializerImpl();

    @Override
    public int init() {
        List<Ability> abilities = new ArrayList<>();
        if (isInitAbility.compareAndSet(false, true)) {
            abilities.add(new Ability(INITIAL_ABILITY_1));
            abilities.add(new Ability(INITIAL_ABILITY_2));
            abilities.add(new Ability(INITIAL_ABILITY_3));
            abilities.add(new Ability(INITIAL_ABILITY_4));
            abilities.add(new Ability(INITIAL_ABILITY_5));
            abilities.add(new Ability(INITIAL_ABILITY_6));
            abilities.add(new Ability(INITIAL_ABILITY_7));
            abilities.add(new Ability(INITIAL_ABILITY_8));
            abilityService.add(abilities);
        }
        return abilities.size();
    }

    private AbilityInitializerImpl() {
    }

    public static AbilityInitializer getInstance() {
        return INSTANCE;
    }
}
