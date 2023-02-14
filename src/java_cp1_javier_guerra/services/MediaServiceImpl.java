package java_cp1_javier_guerra.services;

import java_cp1_javier_guerra.entities.Artist;
import java_cp1_javier_guerra.repositories.ArtistRepository;
import java_cp1_javier_guerra.entities.Media;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MediaServiceImpl implements MediaService {

    private final Artist artist = new ArtistRepository().getArtist();

    public Long newMediaId() {
        Set<Media> discography = artist.getDiscography();
        Long max = 0L;
        if (discography.size() > 0) {
            for (Media media : discography) {
                Long mediaId = media.getMediaId();
                if (mediaId > max) max = mediaId;
            }
        }
        return ++max;
    }

    @Override
    public Long getArtistId() {
        return artist.getArtistId();
    }

    @Override
    public void setArtistId(Long artistId) {
        artist.setArtistId(artistId);
    }

    @Override
    public Set<Media> getDiscography() {
        return artist.getDiscography();
    }

    @Override
    public void setDiscography(Set<Media> discography) {
        artist.setDiscography(discography);
    }

    @Override
    public Optional<Media> getMediaById(Long id) {
        if (artist.getDiscography().size() > 0)
            for (Media media : artist.getDiscography())
                if (media.getMediaId().equals(id)) return Optional.of(media);
        return Optional.empty();
    }

    @Override
    public Set<Media> getDiscographyByFormat(String mediaFormat) {
        Set<Media> mediaList = new HashSet<>();
        for (Media media : artist.getDiscography())
            if (media.getClass().getSimpleName().equals(mediaFormat)) mediaList.add(media);
        return mediaList;
    }

    @Override
    public boolean createNewMedia(Media media) {
        return artist.addNewMedia(media);
    }

    @Override
    public boolean deleteMedia(Media media) {
        return artist.deleteMedia(media);
    }
}
