package java_cp1_javier_guerra.repositories;

import java_cp1_javier_guerra.entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ArtistRepository {

    private Artist artist;

    public ArtistRepository() {
        setArtist(exampleArtist());
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    private Artist exampleArtist() {
        Artist artist = new Artist(1L, "Artista");
        Long artistId = artist.getArtistId();

        List<Song> songs = exampleSongs(artistId);

        Media analog1 = new AnalogMedia(1L, artistId, "Analógico1", MediaFormat.LP, new HashSet<>(Set.of(songs.get(0), songs.get(1))), "33 1/3");
        analog1.addNewSongs(Set.of(songs.get(2), songs.get(3)));

        Media analog2 = new AnalogMedia(2L, artistId, "Analógico2", MediaFormat.CASSETTE, new HashSet<>(Set.of(songs.get(4), songs.get(5))), "Normal");
        analog2.addNewSong(songs.get(6));

        Media digital1 = new DigitalMedia(3L, artistId, "Digital1", MediaFormat.CD, new HashSet<>(Set.of(songs.get(7), songs.get(8))), "CDA");

        artist.addNewMedias(Set.of(analog1, analog2));
        artist.addNewMedia(digital1);

        return artist;
    }

    private List<Song> exampleSongs(Long artistId) {
        Song song1 = new Song(1L, artistId, "Canción_1", 120, MusicGenre.BLUES);
        Song song2 = new Song(2L, artistId, "Canción_2", 260, MusicGenre.CLASSICAL);
        Song song3 = new Song(3L, artistId, "Canción_3", 132, MusicGenre.FOLK);
        Song song4 = new Song(4L, artistId, "Canción_4", 155, MusicGenre.JAZZ);
        Song song5 = new Song(5L, artistId, "Canción_5", 122, MusicGenre.ROCK);
        Song song6 = new Song(6L, artistId, "Canción_6", 190, MusicGenre.FUNK);
        Song song7 = new Song(7L, artistId, "Canción_7", 100, MusicGenre.LATIN);
        Song song8 = new Song(8L, artistId, "Canción_8", 112, MusicGenre.POP);
        Song song9 = new Song(9L, artistId, "Canción_9", 140, MusicGenre.REGGAE);

        return new ArrayList<>(Set.of(song1, song2, song3, song4, song5, song6,song7, song8, song9));
    }
}
