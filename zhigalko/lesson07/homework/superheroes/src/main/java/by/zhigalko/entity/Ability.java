package by.zhigalko.entity;

public enum Ability {
    WEALTH("Богатство"),
    INVISIBILITY("Невидимость"),
    FLIGHT("Полет"),
    REGENERATION("Регенерация"),
    SUPER_POWER("Суперсила"),
    SUPER_SPEED("Суперскорость"),
    TELEPATHY("Телепатия"),
    ELEMENT_CONTROL("Управление стихией");

    private String nameOfAbility;

    Ability(String nameOfAbility) {
        this.nameOfAbility = nameOfAbility;
    }

    public String getNameOfAbility() {
        return nameOfAbility;
    }

    public void setNameOfAbility(String nameOfAbility) {
        this.nameOfAbility = nameOfAbility;
    }
}
