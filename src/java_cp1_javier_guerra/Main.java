package java_cp1_javier_guerra;

import java_cp1_javier_guerra.entities.Artist;

import static java_cp1_javier_guerra.utils.ConsoleInput.*;

public class Main {

    public static void main(String[] args) {

        Artist artist = ExampleData.exampleArtist();

        byte opt;
        String menu = """
            --------------------
            Medios de un artista
            --------------------
            1. Listar todos los medios
            2. Buscar un medio por su id
            3. Buscar los medios por su tipo
            4. Crear un nuevo medio
            5. Actualizar un medio por su id
            6. Borrar un medio por su id
            0. Salir
            """;

        System.out.println(menu);

        while (true) {
            opt = getLongIntPosByRange("Seleccione una opción (0-6): ", 0L, 6L).byteValue();

            if (opt == 0) break;

            switch (opt) {
                case 1 -> { title("Listar todos los medios");       artist.showMediaList();     }
                case 2 -> { title("Buscar un medio por su id");     artist.showMediaById();     }
                case 3 -> { title("Buscar los medios por su tipo"); artist.showMediaByFormat(); }
                case 4 -> { title("Crear un nuevo medio");          artist.createNewMedia();    }
                case 5 -> { title("Actualizar un medio por su id"); artist.updateMediaById();   }
                case 6 -> { title("Borrar un medio por su id");     artist.deleteMediaById();   }
            }

            System.out.println("\nPulse <Intro> para continuar.");
            getEnter();

            clearConsole();
            System.out.println(menu);
        }

        closeScanner();
        System.out.println("La aplicación ha finalizado.");
    }

    /**
     * Muestra un texto subrayado como un título.
     * @param title String Título
     */
    private static void title(String title) {
        System.out.println("\n" + title + "\n" + "-".repeat(title.length()));
    }
}
