PRESENTACIÓN

Mi nombre es Leandro Podestá. Soy estudiante de programación y este proyecto forma parte de mi trabajo final para la materia Java Programación II, donde aplico conocimientos de Programación Orientada a Objetos, manejo de listas, interfaces, herencia, serialización, JSON, CSV, JavaFX y UML.

Qué hace esta aplicación?
Esta aplicación permite gestionar vehículos de diferentes tipos (Autos, Motos y Camiones).
Funciona como un pequeño sistema CRUD completo donde se pueden:

Funcionalidades principales

Crear vehículos (Auto, Moto o Camión)
Listar los vehículos registrados
Actualizar datos de cualquier vehículo
Eliminar un vehículo


Ordenar la lista por diferentes criterios (precio, capacidad, etc.)
Filtrar vehículos según condiciones específicas
Iterar sobre los vehículos usando un iterador personalizado
Modificar atributos usando interfaces funcionales (Consumer, Function, etc.

Exportar e importar datos en:
JSON
CSV
TXT para reportes legibles
Interfaz gráfica con JavaFX para controlar todo desde botones y paneles visuales.


Estructura general del proyecto

El proyecto está basado en:

1)Clase abstracta padre
Vehiculo
Contiene atributos y comportamientos comunes: marca/modelo, tipo, precio y estado

2)Clases hijas:
VehiculoAuto 
VehiculoMoto
VehiculoCamion

Todas añaden atributos propios (puertas, caja de cambios, cilindrada, capacidad, etc.)

3)Enumerados
EstadoVehiculo
TipoDeMoto
CajasDeCambios

4)Interfaz CRUD
Crud<T> con los métodos Create, Read, Update y Delete.

 5) Clase Gestor
GestionVehiculos
Administra la lista interna y se encarga de:
CRUD
iteración
importación/exportación
ordenamientos
filtros
serialización/deserialización

6) Iterator Personalizado
IteradorGestionVehiculos

7) Comparator
ComparadorDeCapacidad para ordenar camiones por capacidad.

8) JavaFX
Interfaz gráfica con botones para operar todo el sistema sin usar consola.
Interfaz Gráfica (imagenes en carpeta)

9)Archivos generados
El sistema genera automáticamente:JSON
ListaVehiculosJSON.json – Guarda toda la lista en formato estructurado
CSV
vehiculos.csv – Exportación compatible con Excel u hojas de cálculo
TXT
reporte_filtrado.txt – Archivo legible para imprimir o enviar.
DAT
vehiculos.dat – Serialización binaria
Diagrama UML

![parte grafica del UML](ÌMAGENES%20JAVA/FINAL%20UML.png)

