Caso práctico 1
===============

Tema de libre elección: Discografía
-----------------------------------

__Autor__: Javier Guerra  
__Status__: Finalizado  
__Versión__: 1.0.4  
__Fecha__: 2023-01-28

La aplicación gestiona la discografía de un artista musical dado (`Artist`). Cada artista tiene una discografía de distintos tipos de medios (`Analog`, `Digital`). Cada tipo de medio puede tener distintos formatos (_enum_ `MediaFormat`).

Cada medio contiene una lista de canciones (`Song`), y cada canción puede ser de un tipo (_enum_ `MusicGenre`).

La interfaz `MediaInterface` es implementada en la clase `Media` de la que heredan las clases `Analog` y `Digital`. Cada una de estas dos clases tiene propiedades y métodos propios además de los comunes indicados en la clase padre.

Las clases `Analog` y `Digital` sobreescriben los métodos `equals()`, `hashCode()` y `toString()`;

Se utiliza una estructura de datos como base de datos en memoria (`HashSet`). Los datos iniciales de ejemplo se aprovisionan en la clase `ExampleData`. 

La aplicación ofrece las siguientes opciones de menú por consola y solicita datos al usuario que son leídos usando la clase `Scanner`:

1. Listar todos los medios  
2. Buscar un medio por su id  
3. Buscar medios por su tipo  
4. Crear un nuevo medio  
5. Actualizar un medio por su id  
6. Borrar un medio por su id  
0. Salir  

Se han creado funciones de apoyo a las opciones de menú para lectura por consola (`ConsoleInput`) son:

- Obtener un entero largo positivo  
- Obtener un entero largo positivo por rango máximo y mínimo  
- Obtener una cadena de caracteres 
- Obtener un booleano para Sí/No
- Obtener la pulsación de la tecla Intro

Otras funciones de apoyo implementadas son:

- Imprimir un título (Main).
- Obtener un nuevo ID de medio (Media).
- Obtener un medio por el ID (Media).
- Obtener el formato de un medio (MediaFormat).

Se genera la documentación de la aplicación con `JavaDoc` en la carpeta doc.

Se incluye `CHANGELOG.md` con los cambios de versión.
