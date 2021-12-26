package by.zhigalko.entity;

import java.io.Serializable;
import java.util.Objects;

public class SuperHero implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String true_name;
    private Gender gender;
    private int age;
    private Ability ability;

    public SuperHero(String nickname, String true_name, Gender gender, int age, Ability ability) {
        this.nickname = nickname;
        this.true_name = true_name;
        this.gender = gender;
        this.age = age;
        this.ability = ability;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return age == superHero.age && Objects.equals(nickname, superHero.nickname)
                && Objects.equals(true_name, superHero.true_name)
                && gender == superHero.gender && ability == superHero.ability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, true_name, gender, age, ability);
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "nickname='" + nickname + '\'' +
                ", true_name='" + true_name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", ability=" + ability +
                '}';
    }
}
