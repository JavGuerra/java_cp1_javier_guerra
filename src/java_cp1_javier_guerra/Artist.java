package java_cp1_javier_guerra;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java_cp1_javier_guerra.ConsoleInput.*;
import static java_cp1_javier_guerra.MediaFormat.getMediaFormat;

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

    /**
     * Obtiene un medio por el ID de la lista de medios de la discografía del artista.
     * @param id Long Identificador del medio
     * @return Media Medio encontrado
     */
    private Media getMediaById(Long id) {
        if (discography.size() > 0)
            for (Media media : discography)
                if (media.getMediaId().equals(id)) return media;
        return null;
    }

    /**
     * Lista un resumen (id título, número de canciones, formato) de la lista de medios de la discografía del artista.
     */
    public void showMediaList() {
        if (discography.size() > 0) {
            for (Media media : discography)
                System.out.println("- " + media.getMediaId() + ". «" + media.getTitle() + "» (" + media.getNumberOfSongs() + "), " + media.getFormat());
            System.out.println("Total: " + discography.size() + (discography.size() > 1 ? " medios" : " medio"));
        }
        else System.out.println("No hay medios.");
    }

    /**
     * Lista un medio de la discografía del artista por el ID y su lista de canciones.
     * @see ConsoleInput#getLongIntPos getLongIntPos
     */
    public void showMediaById() {
        long id = getLongIntPos("Introduzca el ID del medio a mostrar: ");
        if (id > 0) {
            Media media = getMediaById(id);
            System.out.println(media != null ? media : "No se ha encontrado el medio.");
        }
    }

    /**
     * Lista un resumen (id, título, número de canciones, formato) de los medios de la discografía del artista
     * según su tipo de medio (analógico o digital).
     * @see ConsoleInput#getLongIntPosByRange getLongIntPosByRange
     */
    public void showMediaByFormat() {
        long opt = getLongIntPosByRange("Introduzca el tipo de medio: (1) Analógico, (2) Digital: ", 1L, 2L);
        int count = 0;
        String mediaFormat = (opt == 1) ? "AnalogMedia" : "DigitalMedia";
        for (Media media : discography) {
            if (media.getClass().getSimpleName().equals(mediaFormat)) {
                System.out.println("- " + media.getMediaId() + ". «" + media.getTitle() + "» (" + media.getNumberOfSongs() + "), " + media.getFormat());
                count++;
            }
        }
        if (count > 0) System.out.println("Total: " + count + (count > 1 ? " medios" : " medio"));
        else System.out.println("No se ha encontrado ningún medio.");
    }

    /**
     * Crea un nuevo medio (analógico o digital) en la discografía del artista.
     * @see ConsoleInput#getLongIntPosByRange getLongIntPosByRange
     * @see ConsoleInput#getString getString
     * @see #newMediaId newMediaId
     * @see MediaFormat#getMediaFormat getMediaFormat
     */
    public void createNewMedia() {
        String title = getString("Introduzca el título del medio: ");
        long opt = getLongIntPosByRange("Introduzca el tipo de medio: (1) Analógico, (2) Digital: ", 1L, 2L);
        Media media = (opt == 1) ? new AnalogMedia() : new DigitalMedia();
        MediaFormat mediaFormat;
        if (opt == 1) {
            mediaFormat = getMediaFormat("Analog");
            ((AnalogMedia) media).setSpeed(getString("Introduzca la velocidad de reproducción: "));
        } else {
            mediaFormat = getMediaFormat("Digital");
            ((DigitalMedia) media).setCompressionFormat(getString("Introduzca el formato de compresión: "));
        }
        Long mediaId = newMediaId();
        media.setMediaId(mediaId);
        media.setArtistId(artistId);
        media.setTitle(title);
        media.setFormat(mediaFormat);
        if (discography.add(media)) System.out.println("Añadido: " + mediaId + ". «" + title + "» (0), " + mediaFormat);
        else System.out.println("No se ha podido añadir el medio.");
    }

    /**
     * Genera un nuevo identificador de medios que corresponde con el valor máximo de ID existente + 1.
     *
     * @return Long nuevo ID
     */
    private Long newMediaId() {
        Long max = 0L;
        if (discography.size() > 0) {
            for (Media media : discography) {
                Long mediaId = media.getMediaId();
                if (mediaId > max) max = mediaId;
            }
        }
        return ++max;
    }

    /**
     * Actualiza un medio (analógico o digital) seleccionado por el ID en la discografía del artista.
     * @see ConsoleInput#getLongIntPos getLongIntPos
     * @see ConsoleInput#getString getString
     * @see ConsoleInput#getYesNo getYesNo
     */
    public void updateMediaById() {
        long id = getLongIntPos("Introduzca el ID del medio a actualizar: ");
        if (id > 0) {
            Media media = getMediaById(id);
            if (media == null)
                System.out.println("No se ha encontrado el medio.");
            else {
                boolean changes = false;

                if (getYesNo("¿Desea cambiar el título? (S/N): ")) {
                    System.out.println("Título actual del medio: " + media.getTitle());
                    media.setTitle(getString("Introduzca el nuevo título: "));
                    changes = true;
                }

                if (media.getClass().getSimpleName().equals("AnalogMedia")) {
                    if (getYesNo("¿Desea cambiar la velocidad de reproducción? (S/N): ")) {
                        System.out.println("Velocidad actual del medio: " + ((AnalogMedia) media).getSpeed());
                        ((AnalogMedia) media).setSpeed(getString("Introduzca la nueva velocidad: "));
                        changes = true;
                    }
                } else {
                    if (getYesNo("¿Desea cambiar el formato de compresión? (S/N): ")) {
                        System.out.println("Compresión actual del medio: " + ((DigitalMedia) media).getCompressionFormat());
                        ((DigitalMedia) media).setCompressionFormat(getString("Introduzca la nueva compresión: "));
                        changes = true;
                    }
                }

                System.out.println(changes ? "Cambios finalizados." : "No se han realizado cambios.");
            }
        }
    }

    /**
     * Borra un medio de la discografía del artista por el ID.
     * @see ConsoleInput#getLongIntPos getLongIntPos
     * @see ConsoleInput#getYesNo getYesNo
     */
    public void deleteMediaById() {
        long id = getLongIntPos("Introduzca el ID del medio a borrar: ");
        if (id > 0) {
            Media media = getMediaById(id);
            if (media == null)
                System.out.println("No se ha encontrado el medio.");
            else {
                System.out.println("- " + id + ". «" + media.getTitle() + "» (" + media.getNumberOfSongs() + "), " + media.getFormat());
                if (getYesNo("¿Desea confirmar el borrado? (S/N): ")) {
                    if (discography.remove(media)) System.out.println("El medio con ID " + id + " ha sido borrado.");
                    else System.out.println("No se ha podido borrar el medio.");
                }
                else System.out.println("El medio no se borrará.");
            }
        }
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
