package java_cp1_javier_guerra.entities;

import java_cp1_javier_guerra.interfaces.MediaInterface;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Media implements MediaInterface {

    private Long mediaId;
    private Long artistId;
    private String title;
    private MediaFormat format;
    private Set<Song> songs = new HashSet<>();
    private Integer numberOfSongs;

    public Media() {}

    public Media(Long mediaId, Long artistId, String title, MediaFormat format, Set<Song> songs) {
        this.setMediaId(mediaId);
        this.setArtistId(artistId);
        this.setTitle(title);
        this.setFormat(format);
        this.setSongs(songs);
        this.setNumberOfSongs(songs);
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
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

    public MediaFormat getFormat() {
        return format;
    }

    public void setFormat(MediaFormat format) {
        this.format = format;
    }

    public Integer getNumberOfSongs() {
        return (numberOfSongs == null) ? 0 : numberOfSongs;
    }

    public void setNumberOfSongs(Integer numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public void setNumberOfSongs(Set<Song> songs) {
        this.numberOfSongs = songs.size();
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addNewSong(Song song) {
        this.songs.add(song);
        this.numberOfSongs++;
    }

    public void addNewSongs(Set<Song> songs) {
        this.songs.addAll(songs);
        this.numberOfSongs += songs.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media analog = (Media) o;
        return mediaId.equals(analog.mediaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId);
    }

    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", artistId=" + artistId +
                ", title='" + title + '\'' +
                ", format=" + format +
                ", songs=" + songs +
                ", numberOfSongs=" + numberOfSongs +
                '}';
    }
}
