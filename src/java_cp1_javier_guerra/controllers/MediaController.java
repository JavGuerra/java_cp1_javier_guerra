package java_cp1_javier_guerra.controllers;

import java_cp1_javier_guerra.entities.*;
import java_cp1_javier_guerra.services.*;

import java.util.Optional;
import java.util.Set;

import static java_cp1_javier_guerra.entities.MediaFormat.getMediaFormat;
import static java_cp1_javier_guerra.utils.ConsoleInput.*;

public abstract class MediaController {

    private static final MediaService mediaService = new MediaServiceImpl();

    /**
     * Lista un resumen (id título, número de canciones, formato) de la lista de medios de la discografía del artista.
     */
    public static void showMediaList() {
        title("Listar todos los medios");

        Set<Media> discography = mediaService.getDiscography();
        if (discography.size() > 0) {
            for (Media media : discography)
                System.out.println(mediaInfo(media.getMediaId(), media.getTitle(), media.getNumberOfSongs(), media.getFormat()));
            System.out.println("Total: " + discography.size() + (discography.size() > 1 ? " medios" : " medio"));
        } else System.out.println("No hay medios.");
    }

    /**
     * Lista un medio de la discografía del artista por el ID y su lista de canciones.
     */
    public static void showMediaById() {
        title("Buscar un medio por su id");

        long id = getLongIntPos("Introduzca el ID del medio a mostrar: ");
        if (id > 0) {
            Optional<Media> media = mediaService.getMediaById(id);
            System.out.println(media.isPresent() ? media.get() : "No se ha encontrado el medio.");
        }
    }

    /**
     * Lista un resumen (id, título, número de canciones, formato) de los medios de la discografía del artista
     * según su tipo de medio (analógico o digital).
     */
    public static void showMediaByFormat() {
        title("Buscar los medios por su tipo");

        long opt = getLongIntPosByRange("Introduzca el tipo de medio: (1) Analógico, (2) Digital: ", 1L, 2L);
        String mediaFormat = (opt == 1) ? "AnalogMedia" : "DigitalMedia";
        Set<Media> discography = mediaService.getDiscographyByFormat(mediaFormat);
        if (discography.size() > 0) {
            for (Media media : discography)
                System.out.println(mediaInfo(media.getMediaId(), media.getTitle(), media.getNumberOfSongs(), media.getFormat()));
            System.out.println("Total: " + discography.size() + (discography.size() > 1 ? " medios" : " medio"));
        } else System.out.println("No se ha encontrado ningún medio.");
    }

    /**
     * Crea un nuevo medio (analógico o digital) en la discografía del artista.
     */
    public static void createNewMedia() {
        title("Crear un nuevo medio");

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
        Long mediaId = mediaService.newMediaId();
        media.setMediaId(mediaId);
        media.setArtistId(mediaService.getArtistId());
        media.setTitle(title);
        media.setFormat(mediaFormat);
        if (mediaService.createNewMedia(media)) System.out.println("Añadido: " + mediaInfo(mediaId, title, 0, mediaFormat));
        else System.out.println("No se ha podido añadir el medio.");
    }

    /**
     * Actualiza un medio (analógico o digital) seleccionado por el ID en la discografía del artista.
     */
    public static void updateMediaById() {
        title("Actualizar un medio por su id");

        long id = getLongIntPos("Introduzca el ID del medio a actualizar: ");
        if (id > 0) {
            Optional<Media> optMedia = mediaService.getMediaById(id);
            if (optMedia.isPresent()) {
                Media media = optMedia.get();

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

            } else System.out.println("No se ha encontrado el medio.");

        }
    }

    /**
     * Borra un medio de la discografía del artista por el ID.
     */
    public static void deleteMediaById() {
        title("Borrar un medio por su id");

        long id = getLongIntPos("Introduzca el ID del medio a borrar: ");
        if (id > 0) {
            Optional<Media> optMedia = mediaService.getMediaById(id);
            if (optMedia.isPresent()) {
                Media media = optMedia.get();
                System.out.println(mediaInfo(id, media.getTitle(), media.getNumberOfSongs(), media.getFormat()));

                if (getYesNo("¿Desea confirmar el borrado? (S/N): ")) {
                    if (mediaService.deleteMedia(media)) System.out.println("El medio ha sido borrado.");
                    else System.out.println("No se ha podido borrar el medio.");
                }
                else System.out.println("El medio no se borrará.");

            } else System.out.println("No se ha encontrado el medio.");
        }
    }

    /**
     * Devuelve una cadena de texto formateada con los datos del medio recibido.
     * @param id Identificador
     * @param title Título
     * @param numSongs Número de canciones
     * @param format Formato del medio
     * @return cadena
     */
    private static String mediaInfo(Long id, String title, Integer numSongs, MediaFormat format) {
        return id + ". «" + title + "» (" + numSongs + "), " + format;
    }
}
