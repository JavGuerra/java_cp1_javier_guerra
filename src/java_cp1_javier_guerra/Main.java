package java_cp1_javier_guerra;

import static java_cp1_javier_guerra.MenuOptions.*;
import static java_cp1_javier_guerra.utils.ConsoleInput.*;

public class Main {

    public static void main(String[] args) {

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

        clearConsole();
        System.out.println(menu);

        while (true) {
            opt = getLongIntPosByRange("Seleccione una opción (0-6): ", 0L, 6L).byteValue();

            if (opt == 0) break;

            switch (opt) {
                case 1 -> showMediaList();
                case 2 -> showMediaById();
                case 3 -> showMediaByFormat();
                case 4 -> createNewMedia();
                case 5 -> updateMediaById();
                case 6 -> deleteMediaById();
            }

            System.out.println("\nPulse <Intro> para continuar.");
            getEnter();

            clearConsole();
            System.out.println(menu);
        }

        closeScanner();
        System.out.println("La aplicación ha finalizado.");
    }
}
