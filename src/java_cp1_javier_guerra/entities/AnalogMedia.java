package java_cp1_javier_guerra.entities;

import java_cp1_javier_guerra.entities.enums.MediaFormat;

import java.util.Set;

public class AnalogMedia extends Media {

    private String speed; // rpm u otros

    public AnalogMedia() {}

    public AnalogMedia(Long mediaId, Long artistId, String title, MediaFormat format, String speed) {
        super(mediaId, artistId, title, format);
        this.setSpeed(speed);
    }

    public AnalogMedia(Long mediaId, Long artistId, String title, MediaFormat format, Set<Song> songs, String speed) {
        super(mediaId, artistId, title, format, songs);
        this.setSpeed(speed);
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        Integer numberOfSongs = getNumberOfSongs();
        StringBuilder str = new StringBuilder(getMediaId() + ". «" + getTitle() + "», " + getFormat() + "\n" +
                "Velocidad de reproducción: " + speed + "\n");
        if (numberOfSongs > 0) {
            str.append("Canciones:");
            for (Song song : getSongs()) str.append("\n- ").append(song);
            str.append("\nTotal: ").append(numberOfSongs).append(numberOfSongs > 1 ? " canciones" : " canción");
        } else {
            str.append("El medio no tiene canciones aún.");
        }
        return str.toString();
    }
}
