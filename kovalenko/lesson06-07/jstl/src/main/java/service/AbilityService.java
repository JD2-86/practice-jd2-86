package service;

import model.Ability;

import java.util.List;

public interface AbilityService {

    List<Ability> getAbilities();

    Ability add(Ability ability);

    List<Ability> add(List<Ability> abilities);

    Ability getById(Long id);

    Ability getByName(String name);
}
