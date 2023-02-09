package java_cp1_javier_guerra.entities;

import java_cp1_javier_guerra.utils.ConsoleInput;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java_cp1_javier_guerra.utils.ConsoleInput.*;
import static java_cp1_javier_guerra.entities.MediaFormat.getMediaFormat;

public class Artist {

    private Long artistId;
    private String name;
    private Set<Media> discography = new HashSet<>();

    public Artist() {}

    public Artist(Long artistId, String name) {
        this.setArtistId(artistId);
        this.setName(name);
    }

    public Artist(Long artistId, String name, Set<Media> discography) {
        this.setArtistId(artistId);
        this.setName(name);
        this.setDiscography(discography);
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Media> getDiscography() {
        return discography;
    }

    public void setDiscography(Set<Media> discography) {
        this.discography = discography;
    }

    public void addNewMedia(Media media) {
        this.discography.add(media);
    }

    public void addNewMedias(Set<Media> medias) {
        this.discography.addAll(medias);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artistId.equals(artist.artistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                ", discography=" + discography +
                '}';
    }
}
