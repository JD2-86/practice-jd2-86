package by.shcharbunou.superheroes.entities;

import java.util.Objects;

public class Hero {
    private String nickname;
    private String realName;
    private int age;
    private Gender gender;
    private Ability ability;

    public Hero(String nickname, String realName, int age, Gender gender, Ability ability) {
        this.nickname = nickname;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.ability = ability;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age && Objects.equals(nickname, hero.nickname)
                && Objects.equals(realName, hero.realName)
                && gender == hero.gender && ability == hero.ability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, realName, age, gender, ability);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", ability=" + ability +
                '}';
    }
}
