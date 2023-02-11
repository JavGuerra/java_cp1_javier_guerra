Caso práctico 1
===============

Tema de libre elección: Discografía
-----------------------------------

__Autor__: Javier Guerra  
__Status__: Finalizado  
__Versión__: 1.0.5  
__Fecha__: 2023-02-09

La aplicación gestiona la discografía de un artista musical dado (`Artist`). Cada artista tiene una discografía de distintos tipos de medios (`Analog`, `Digital`). Cada tipo de medio puede tener distintos formatos (_enum_ `MediaFormat`).

Cada medio contiene una lista de canciones (`Song`), y cada canción puede ser de un tipo (_enum_ `MusicGenre`).

La interfaz `MediaInterface` es implementada en la clase `Media` de la que heredan las clases `Analog` y `Digital`. Cada una de estas dos clases tiene propiedades y métodos propios además de los comunes indicados en la clase padre.

Las clases `Analog` y `Digital` sobreescriben los métodos `equals()`, `hashCode()` y `toString()`;

Se implementa un servicio de gestión de medios de un artista (`MediaServiceImpl`) y su interfaz (`M̀ediaService`) que es accedido desde la clase `MenuOptions` que contiene los métodos relacionados con las opciones del menú de la aplicación.

Se utiliza una estructura de datos como base de datos en memoria (`HashSet`). Los datos iniciales de ejemplo se aprovisionan en la clase `ArtistRepository` que es usada por el servicio `MediaServiceImpl`. 

La aplicación ofrece las siguientes opciones de menú por consola y solicita datos al usuario que son leídos usando la clase `Scanner`:

1. Listar todos los medios  
2. Buscar un medio por su id  
3. Buscar medios por su tipo  
4. Crear un nuevo medio  
5. Actualizar un medio por su id  
6. Borrar un medio por su id  
0. Salir  

Se han creado funciones de apoyo a las opciones de menú para lectura por consola (`ConsoleInput`):

- Obtener un entero largo positivo  
- Obtener un entero largo positivo por rango máximo y mínimo  
- Obtener una cadena de caracteres 
- Obtener un booleano para Sí/No
- Obtener la pulsación de la tecla Intro
- Imprimir un título (Main)

Otras funciones de apoyo están implementadas en `MenuOptions` y en `MediaServiceImpl`:

Se genera la documentación de la aplicación con `JavaDoc` en la carpeta doc.

Se incluye `CHANGELOG.md` con los cambios de versión.

## Licencias

Sobre el código fuente: [GNU GENERAL PUBLIC LICENSE Version 3](LICENSE)

## Saber más

Artículos informativos elaborados por el autor relacionados con esta práctica:

- [«ConsoleInput», una clase en Java para lectura de datos por consola.](https://javguerra.github.io/2023-01-31-clase-scanner-java/)  
