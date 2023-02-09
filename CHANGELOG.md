# Cambios en Discografía

## 1.0.5 - 2023-02-09

- Añadido el servicio MediaServide y su implementación.
- Añadido MenuOptions.
- Refactorización de paquetes.

## 1.0.4 - 2023-01-29

- Movido el método getMediaFormat() a la clase enum MediaFormat.
- Movidos los métodos de Menú de la clase Main a la clase Artist.
- Añadido el método getMediaById() a la clase Artist;
- Añadido el método title() a la clase Main.

## 1.0.3 - 2023-01-28

- Renombrada la interfaz Media a MediaInterface.
- Renombradas las clases Analog y Digital a AnalogMedia y DigitalMedia respectivamente, y cambiadas sus implementaciones.
- Añadida la clase Media, que implementa MediaInterface, de la que ahora heredan las clases AnalogMedia y DigitalMedia.
- Eliminadas las propiedades y los métodos innecesarios de las clases AnalogMedia y DigitalMedia que ya están en la clase padre Media, y adaptados sus constructores.

## 1.0.2 - 2023-01-28

- Comprueba que createNewMedia() guarda correctamente el nuevo medio en el HasHSet songs.
- Comprueba que deleteMediaById() borrar correctamente el medio indicado del HashSet songs.
- Cambiado el String que devuelve toString() en las clases Analog y Digital y Song.

## 1.0.1 - 2023-01-27

- Se incluyen los métodos equals() y hashcode() en las clases susceptibles de ser usadas en un HashSet.

## 1.0.0 - 2023-01-26

- Primera versión.