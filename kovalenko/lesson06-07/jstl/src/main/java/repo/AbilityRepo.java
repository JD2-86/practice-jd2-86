package repo;

import model.Ability;

import java.util.List;

public interface AbilityRepo {

    Ability add(Ability ability);

    List<Ability> addAll(List<Ability> abilities);

    List<Ability> getAbilities();
}
