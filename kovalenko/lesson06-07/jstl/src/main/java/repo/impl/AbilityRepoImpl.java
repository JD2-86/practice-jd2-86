package repo.impl;

import model.Ability;
import repo.AbilityRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AbilityRepoImpl implements AbilityRepo {
    private final List<Ability> abilities = new ArrayList<>();
    private final AtomicLong idProvider = new AtomicLong();
    private static final AbilityRepo INSTANCE = new AbilityRepoImpl();

    @Override
    public Ability add(Ability ability) {
        Long id = idProvider.incrementAndGet();
        ability.setId(id);
        abilities.add(ability);
        return ability;
    }

    @Override
    public List<Ability> addAll(List<Ability> abilities) {
        abilities.forEach(ability -> ability.setId(idProvider.incrementAndGet()));
        this.abilities.addAll(abilities);
        return abilities;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    private AbilityRepoImpl() {
    }

    public static AbilityRepo getInstance() {
        return INSTANCE;
    }
}
