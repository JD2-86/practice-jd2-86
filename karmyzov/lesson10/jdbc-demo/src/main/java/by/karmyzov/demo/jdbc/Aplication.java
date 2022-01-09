package by.karmyzov.demo.jdbc;


public class Aplication {
    private static final ArtistDao artistDao = ArtistDaoJdbc.getInstance();
    public static void main(String[] args) {

        Artist newArtist = new Artist("Ony", "USA");
        Artist savedArtist = artistDao.save(newArtist);
        Artist artistFromDb = artistDao.findByName(newArtist.getName());
        System.out.println(newArtist);
        System.out.println(savedArtist);
        System.out.println(artistFromDb);
    }


}