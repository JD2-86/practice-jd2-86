package by.shcharbunou.superheroes.entities;

public enum Ability {
    INVISIBILITY("Невидимость"),
    WEALTH("Богатство"),
    REGENERATION("Регенерация"),
    POWER("Суперсила"),
    SPEED("Суперскорость"),
    FLIGHT("Полёт"),
    TELEPATHY("Телепатия"),
    ELEMENT_CONTROL("Управление стихией");

    private String abilityDesignation;

    Ability(String abilityDesignation) {
        this.abilityDesignation = abilityDesignation;
    }

    public String getAbilityDesignation() {
        return abilityDesignation;
    }

    public void setAbilityDesignation(String abilityDesignation) {
        this.abilityDesignation = abilityDesignation;
    }
}
