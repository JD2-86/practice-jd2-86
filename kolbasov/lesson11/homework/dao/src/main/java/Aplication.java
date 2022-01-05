public class Aplication {
    private static final ArtistDao artistDao = ArtistDaoJdbc.getInstance();
    public static void main(String[] args) {

            Artist newArtist = new Artist("kola", "franch");
            Artist savedArtist = artistDao.save(newArtist);
            System.out.println(newArtist);
        }


}
