package java_cp1_javier_guerra.services;

import java_cp1_javier_guerra.entities.Media;

import java.util.Optional;
import java.util.Set;

public interface MediaService {

    Long getArtistId();

    void setArtistId(Long artistId);

    Set<Media> getDiscography();

    void setDiscography(Set<Media> discography);

    Optional<Media> getMediaById(Long id);

    Set<Media> getDiscographyByFormat(String mediaFormat);

    boolean createNewMedia(Media media);

    boolean deleteMedia(Media media);
}
