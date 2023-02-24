package java_cp1_javier_guerra.repositories;

import java_cp1_javier_guerra.entities.*;
import java_cp1_javier_guerra.entities.enums.MediaFormat;
import java_cp1_javier_guerra.entities.enums.MusicGenre;

import java.util.Set;

public final class ArtistRepository {

    private Artist artist;

    public ArtistRepository() {
        setArtist(exampleArtist(true));
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Genera un artista de ejemplo con o sin medios en su discografía.
     * @param data true incluye medios de ejemplo, false no lo hace.
     * @return Artist
     */
    private Artist exampleArtist(Boolean data) {
        if (data == null) data = false;

        Artist artist = new Artist(1L, "Artista");

        if (data) {
            Song song1 = new Song(1L, 1L, "Canción_1", 120, MusicGenre.BLUES);
            Song song2 = new Song(2L, 1L, "Canción_2", 260, MusicGenre.CLASSICAL);
            Song song3 = new Song(3L, 1L, "Canción_3", 132, MusicGenre.FOLK);
            Song song4 = new Song(4L, 1L, "Canción_4", 155, MusicGenre.JAZZ);
            Song song5 = new Song(5L, 1L, "Canción_5", 122, MusicGenre.ROCK);
            Song song6 = new Song(6L, 1L, "Canción_6", 190, MusicGenre.FUNK);
            Song song7 = new Song(7L, 1L, "Canción_7", 100, MusicGenre.LATIN);
            Song song8 = new Song(8L, 1L, "Canción_8", 112, MusicGenre.POP);
            Song song9 = new Song(9L, 1L, "Canción_9", 140, MusicGenre.REGGAE);

            Media analog1 = new AnalogMedia(1L, 1L, "Analógico_1", MediaFormat.LP, "33 1/3");
            analog1.addNewSongs(Set.of(song1, song2, song3, song4));

            Media analog2 = new AnalogMedia(2L, 1L, "Analógico_2", MediaFormat.CASSETTE, "Normal");
            analog2.addNewSongs(Set.of(song5, song6, song7));

            Media digital1 = new DigitalMedia(3L, 1L, "Digital_1", MediaFormat.CD, "CDA");
            digital1.addNewSongs(Set.of(song8, song9));

            artist.addNewMedias(Set.of(analog1, analog2, digital1));
        }

        return artist;
    }
}
