package model;

public class Hero {
    private Long id;
    private String name;
    private String identity;
    private int age;
    private Gender gender;
    private Ability ability;

    public Hero(String name, String identity, int age, Gender gender, Ability ability) {
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.gender = gender;
        this.ability = ability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
