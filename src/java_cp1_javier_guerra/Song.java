package java_cp1_javier_guerra;

import java.util.Objects;

public class Song {

    private Long songId;
    private Long artistId;
    private String title;
    private Integer duration; // segundos
    private MusicGenre genre;

    public Song() {}

    public Song(Long songId, Long artistId, String title, Integer duration, MusicGenre genre) {
        this.setSongId(songId);
        this.setArtistId(artistId);
        this.setTitle(title);
        this.setDuration(duration);
        this.setGenre(genre);
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId.equals(song.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId);
    }

    @Override
    public String toString() {
        return songId + ". «" + title + "» " + duration + "s, " + genre.toString().toLowerCase();
    }
}
