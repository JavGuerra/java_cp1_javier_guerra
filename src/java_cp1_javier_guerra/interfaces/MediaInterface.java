package java_cp1_javier_guerra.interfaces;

import java_cp1_javier_guerra.entities.Song;
import java_cp1_javier_guerra.entities.MediaFormat;

import java.util.Set;

public interface MediaInterface {

    Long getMediaId();

    void setMediaId(Long mediaId);

    Long getArtistId();

    void setArtistId(Long artistId);

    String getTitle();

    void setTitle(String title);

    MediaFormat getFormat();

    void setFormat(MediaFormat format);

    Integer getNumberOfSongs();

    void setNumberOfSongs(Integer numberOfSongs);

    void setNumberOfSongs(Set<Song> songs);

    Set<Song> getSongs();

    void setSongs(Set<Song> songs);

    void addNewSong(Song song);

    void addNewSongs(Set<Song> songs);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    String toString();
}
