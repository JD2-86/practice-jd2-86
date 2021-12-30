package by.tolkach.heroes.dto;

import java.io.Serializable;
import java.util.Objects;

public class Hero implements Serializable {
    private String login;
    private String name;
    private String age;
    private String male;
    private String ability;

    public Hero() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(login, hero.login) && Objects.equals(name, hero.name) && Objects.equals(age, hero.age) && Objects.equals(male, hero.male) && Objects.equals(ability, hero.ability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, male, ability);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", male='" + male + '\'' +
                ", ability='" + ability + '\'' +
                '}';
    }
}
