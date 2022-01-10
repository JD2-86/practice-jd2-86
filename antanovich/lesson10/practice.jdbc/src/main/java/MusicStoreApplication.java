public class MusicStoreApplication {
    private static final ArtistDao artistDao = ArtistDaoJdbc.getInstance();

    public static void main(String[] args) {
        Artist newArtist = new Artist("Scorpions", "Germany");
        Artist addArtist = artistDao.addArtist(newArtist);
        Artist updateArtist = artistDao.updateArtist(newArtist);
        Artist artistFromDbByName =
                artistDao.findArtistByName(newArtist.getName());
        Artist artistById = artistDao.findArtistById(1);
        System.out.println(newArtist);
        System.out.println(addArtist);
        System.out.println(updateArtist);
        System.out.println(artistFromDbByName);
        System.out.println(artistById);
        artistDao.deleteArtist(artistFromDbByName);
        System.out.println(artistFromDbByName);
    }
}
