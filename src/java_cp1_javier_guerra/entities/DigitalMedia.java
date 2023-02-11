package java_cp1_javier_guerra.entities;

import java.util.Set;

public class DigitalMedia extends Media {

    private String compressionFormat; // codec u otros

    public DigitalMedia() {}

    public DigitalMedia(Long mediaId, Long artistId, String title, MediaFormat format, String compressionFormat) {
        super(mediaId, artistId, title, format);
        this.setCompressionFormat(compressionFormat);
    }

    public DigitalMedia(Long mediaId, Long artistId, String title, MediaFormat format, Set<Song> songs, String compressionFormat) {
        super(mediaId, artistId, title, format, songs);
        this.setCompressionFormat(compressionFormat);
    }

    public String getCompressionFormat() {
        return compressionFormat;
    }

    public void setCompressionFormat(String compressionFormat) {
        this.compressionFormat = compressionFormat;
    }

    @Override
    public String toString() {
        Integer numberOfSongs = getNumberOfSongs();
        StringBuilder str = new StringBuilder(getMediaId() + ". «" + getTitle() + "», " + getFormat() + "\n" +
                "Formato de compresión: " + compressionFormat + "\n");
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
