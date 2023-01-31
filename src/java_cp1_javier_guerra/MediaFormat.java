package java_cp1_javier_guerra;

import static java_cp1_javier_guerra.ConsoleInput.getLongIntPosByRange;

public enum MediaFormat {
    DOUBLE_ALBUM, LP, SINGLE, CD, CASSETTE, CARTRIDGE, PLAY_LIST;

    /**
     * Devuelve el formato de medio seleccionado en función de su tipo (analógico o digital).
     * @param type String Tipo de formato (Analog, Digital)
     * @return MediaFormat Formato del medio
     * @see java_cp1_javier_guerra@ConsoleInput#getLongIntPosByRange getLongIntPosByRange
     */
    public static MediaFormat getMediaFormat(String type) {
        MediaFormat mediaFormat = null;
        if (type.trim().equalsIgnoreCase("Analog")) {
            System.out.println("Formatos analógicos (1) Doble álbum, (2) LP, (3) Sencillo, (4) Cinta, (5) Cartucho");
            byte opt = getLongIntPosByRange("Elija un formato: ", 1L, 5L).byteValue();
            switch (opt) {
                case 1 -> mediaFormat = DOUBLE_ALBUM;
                case 2 -> mediaFormat = LP;
                case 3 -> mediaFormat = SINGLE;
                case 4 -> mediaFormat = CASSETTE;
                case 5 -> mediaFormat = CARTRIDGE;
            }
        } else if (type.trim().equalsIgnoreCase("Digital")) {
            System.out.println("Formatos digitales (1) CD, (2) Lista de reproducción");
            byte opt = getLongIntPosByRange("Elija un formato: ", 1L, 2L).byteValue();
            switch (opt) {
                case 1 -> mediaFormat = CD;
                case 2 -> mediaFormat = PLAY_LIST;
            }
        } else {
            mediaFormat = PLAY_LIST;
        }
        return mediaFormat;
    }
}
