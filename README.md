# Análisis de Complejidades: Listas, Pilas y Colas en Java

## Descripción
Este proyecto contiene la implementación desde cero de las estructuras de datos lineales fundamentales en Java (**Listas Enlazadas**, **Pilas** y **Colas**), junto con un entorno de pruebas en la terminal que mide y exporta los tiempos de ejecución en microsegundos (\(ms\)) para validar de manera empírica la complejidad algorítmica (\(O\)).

## Autor
* **Jorge Eduardo Piratoba Tocarruncho** - GitHub: [@jpiratobat]

## Tecnologías y lenguajes utilizados
* **Lenguaje:** Java 17+
* **Herramientas de construcción:** JDK / IDE ( VS Code )
* **Formato de datos de salida:** Terminal
* **Procesamiento de datos y gráficos:**  Microsoft Excel
* **Documentación / Reporte:** LaTeX 

## Estructura del Proyecto
ED_Listas_Pilas_Colas/
├── src/
│   ├── List/                         # Implementaciones de Listas Enlazadas
│   │   ├── MyList.java               # Interfaz genérica MyList
│   │   ├── Node.java                 # Clase Nodo simple
│   │   ├── DoubleNode.java           # Clase Nodo doble
│   │   ├── SinglyLinkedList.java     # Lista simplemente enlazada (sin Tail)
│   │   ├── SinglyLinkedListTail.java # Lista simplemente enlazada (con Tail)
│   │   ├── DoublyLinkedList.java     # Lista doblemente enlazada (sin Tail)
│   │   └── DoublyLinkedListTail.java # Lista doblemente enlazada (con Tail)
│   ├── Stack/                        # Implementaciones de Pilas
│   │   ├── MyStack.java              # Interfaz MyStack
│   │   └── DynamicArrayStack.java    # Pila sobre arreglo dinámico redimensionable
│   ├── Queue/                        # Implementaciones de Colas
│   │   ├── MyQueue.java              # Interfaz MyQueue
│   │   └── DynamicArrayQueue.java    # Cola sobre arreglo circular dinámico
│   └── Main.java                     # Módulo de Benchmark y generación de datos CSV
├── resultados.xls                    # Archivo con las métricas en microsegundos
├── imagenes/                         # Gráficas de rendimiento empírico exportadas
│   ├── DoublyLinkedList.png
|   ├── DoublyLinkedListTail.png
|   ├── SimplyLinkedList.png
|   ├── SimplyLinkedListTail.png
|   ├── DynamicArrayQueue.png
|   ├── DynamicArrayStack.png
├── Informe.tex                      # Documentación del informe en LaTeX
└── README.md                         # Documentación general del repositorio

## Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/jpiratobat/ED_Listas_Pilas_Colas.git
cd ED_Listas_Pilas_Colas
```

### 2. Compilar el proyecto

Desde la carpeta raíz del proyecto, compila todas las clases contenidas en los paquetes:

```bash
javac -d bin src/List/*.java src/Stack/*.java src/Queue/*.java src/Main.java
```

### 3. Ejecutar las pruebas

Ejecuta la clase principal `Main` para iniciar las mediciones y desplegar las tablas de resultados directamente en la terminal:

```bash
java -cp bin Main
```