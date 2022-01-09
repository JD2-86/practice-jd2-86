package by.shcharbunou.superheroes.entities;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");

    private String genderDesignation;

    Gender(String genderDesignation) {
        this.genderDesignation = genderDesignation;
    }

    public String getGenderDesignation() {
        return genderDesignation;
    }

    public void setGenderDesignation(String genderDesignation) {
        this.genderDesignation = genderDesignation;
    }
}
