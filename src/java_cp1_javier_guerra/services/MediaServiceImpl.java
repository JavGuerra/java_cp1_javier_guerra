package java_cp1_javier_guerra.services;

import java_cp1_javier_guerra.ExampleData;
import java_cp1_javier_guerra.entities.Media;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MediaServiceImpl implements MediaService {

    private Long artistId = ExampleData.exampleArtist().getArtistId();
    private Set<Media> discography = ExampleData.exampleArtist().getDiscography();

    @Override
    public Long getArtistId() {
        return artistId;
    }
    @Override
    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @Override
    public Set<Media> getDiscography() {
        return discography;
    }

    @Override
    public void setDiscography(Set<Media> discography) {
        this.discography = discography;
    }

    @Override
    public Optional<Media> getMediaById(Long id) {
        if (discography.size() > 0)
            for (Media media : discography)
                if (media.getMediaId().equals(id)) return Optional.of(media);
        return Optional.empty();
    }

    @Override
    public Set<Media> getDiscographyByFormat(String mediaFormat) {
        Set<Media> mediaList = new HashSet<>();
        for (Media media : discography)
            if (media.getClass().getSimpleName().equals(mediaFormat)) mediaList.add(media);
        return mediaList;
    }

    @Override
    public boolean createNewMedia(Media media) {
        return discography.add(media);
    }

    @Override
    public boolean deleteMedia(Media media) {
        return discography.remove(media);
    }
}
