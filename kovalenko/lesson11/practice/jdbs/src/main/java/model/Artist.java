package model;

import java.util.Objects;

public class Artist {
    private String name;
    private String country;

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) && Objects.equals(country, artist.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
