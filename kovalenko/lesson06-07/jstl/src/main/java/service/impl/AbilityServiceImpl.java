package service.impl;

import exception.AbilityNotFoundException;
import model.Ability;
import repo.AbilityRepo;
import repo.impl.AbilityRepoImpl;
import service.AbilityService;

import java.util.List;

public class AbilityServiceImpl implements AbilityService {
    private final AbilityRepo abilityRepo = AbilityRepoImpl.getInstance();
    private static final AbilityService INSTANCE = new AbilityServiceImpl();

    @Override
    public List<Ability> getAbilities() {
        return abilityRepo.getAbilities();
    }

    @Override
    public Ability add(Ability ability) {
        return abilityRepo.add(ability);
    }

    @Override
    public List<Ability> add(List<Ability> abilities) {
        return abilityRepo.addAll(abilities);
    }

    @Override
    public Ability getById(Long id) {
        return abilityRepo.getAbilities().stream()
                .filter(ability -> ability.getId().equals(id))
                .findFirst()
                .orElseThrow(AbilityNotFoundException::new);
    }

    @Override
    public Ability getByName(String name) {
        return abilityRepo.getAbilities().stream()
                .filter(ability -> ability.getName().equals(name))
                .findFirst()
                .orElseThrow(AbilityNotFoundException::new);
    }

    private AbilityServiceImpl() {
    }

    public static AbilityService getInstance() {
        return INSTANCE;
    }
}
