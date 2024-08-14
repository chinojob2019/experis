# Reto Experis
Éste es el reto experis, con esta app se puede ver un listado de lugares turisticos, acceder para ver sus detalles y abrir un mapa de su ubicación.

# Experiencia de usuario
Este proyecto contiene las siguientes características:

* La pantalla principal donde se ve un listado de lugares turisticos.
* Pantalla de detalle de los lugares turisticos
* La vista de un mapa con un marcador de donde es la ubicacion por coordenada.


## BACK
Se ha trabajado con la parte REST de Firebase Realtime Database para simular la parte back
Las imagenes se almacenan en Firebase Storage

### Arquitectura
Este proyecto implementa el patrón de arquitectura MVVM y sigue buenas prácticas de Clean Architecture para hacer un código más independiente, mantenible y sencillo.

#### Capas
* Presentation: Fragments y Activities
* Data: contiene la implementación del repositorio y los sources donde se conecta con la api y con la base de datos local (ROOM)
* Domain: contiene los casos de uso 
Este proyecto usa ViewModel para almacenar y manejar datos, así como comunicar cambios hacia la vista.

### Administrador de solicitudes: Retrofit

Este proyecto utiliza Retrofit para mostrar los productos desde una API.

### Inyección de dependencia - Hilt

Este proyecto utiliza Hilt para gestionar la inyección de dependencia.

### Persistencia de datos - Room

Este proyecto utiliza la base de datos de Room para almacenar los lugares.


### Patrones de diseño

Utilizo algunos patrones de diseño como Observer, Singleton, Repository

# Guía de instalación
En caso de no tener instalado Android Studio, descargue la última versión estable. Una vez que tenemos el programa instalado vamos a Get from Version Control y vamos a pegar https://github.com/chinojob2019/experis.git
