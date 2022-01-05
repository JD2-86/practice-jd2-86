public class Artist {
    private long id;
    private String name;
    private String country;

    public Artist(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Artist (String name, String country){
        this.name =name;
        this.country=country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
