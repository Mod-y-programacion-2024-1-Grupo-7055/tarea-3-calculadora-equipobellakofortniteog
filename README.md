Alumnos: 
- Garcia Gomez Eduardo Biali
- Hurtado Aponte Joshua Abel


### Nuevas Clases de Nodos para Operadores Especiales

- **NodoSeno.java**: Hemos implementado el operador seno para ampliar las capacidades matemáticas de nuestra calculadora, permitiendo realizar operaciones trigonométricas.
- **NodoCoseno.java**: Similar al NodoSeno, pero para el cálculo del coseno.
- **NodoTangente.java**: Añadimos soporte para el operador tangente.
- **NodoRaizCuadrada.java**: Introdujimos la funcionalidad de cálculo de raíz cuadrada.

### Modificaciones en Clase Compilador

- **Análisis Léxico y Sintáctico Mejorado**: Actualizamos el compilador para reconocer y procesar los nuevos operadores. Esto incluyo ajustes en la tokenización y en la construcción del árbol de análisis sintáctico.
- **Simplificación de la Lógica de Precedencia**: Modificamos el método `casoOperador` para usar una lógica más clara y concisa en la comparación de precedencia de operadores.

## Transformación de la Interfaz de Usuario

- **De CLI a GUI**: Cambiamos el enfoque de una interfaz de línea de comandos a una interfaz gráfica de usuario. Esto nos dio una reestructuración completa de cómo los usuarios interactúan con la aplicación.
- **Diseño de la Interfaz Gráfica**: Implementamos una interfaz gráfica utilizando Swing, con botones para dígitos, operadores estándar y especiales, y funciones adicionales como borrar y salir.

## Mejoras en la Interactividad y UX

- **Botones con Etiquetas Personalizadas**: Añadimos botones con etiquetas completas para operadores especiales "sin, cos, tan y √ "que insertan sus símbolos cortos en el campo de texto, para que se ubiquen mas facil los operadores.
- **Manejo de Errores y Validaciones**: Implementamos un sistema de manejo de errores para alertar al usuario sobre errores de sintaxis o cálculos inválidos.

## Ajustes en NodoOperador y Clases Relacionadas

- **Soporte para Nuevos Operadores**: Modificamos estas clases para manejar correctamente la representación, evaluación y precedencia de los nuevos operadores matemáticos.


## Compilar y probar el codigo

Se empieza descargando el codigo de nuestro repositorio de GitHub " tarea-3-calculadora-equipobellakofortniteog ", copiamos el link de este mismo y nos dirigimos a la terminal, nos dirigimos a donde queremos que se descargue la carpeta de la tarea, en este caso al escritorio, usando los comandos **- cd Escritorio/**

Posteriormente usamos el comando para clonar el repositorio del Github con " git clone " mas el link que acabamos de copiar del repositorio
**- git clone https://github.com/Mod-y-programacion-2024-1-Grupo-7055/tarea-3-calculadora-equipobellakofortniteog.git**

Ya con la practica en nuestro escritorio procedemos a abrir la carpeta y compilarlo con los comandos
**- cd tarea-3-calculadora-equipobellakofortniteog/** *abrir la carpeta del codigo

Despues para buscar la clase Main, primero nos debemos de meter al src que es donde se encuentra la clase Main para poder correr el programa, usando el comando:
**- ls** *para ver los archivos de la carpeta de la tarea

y al ubicar la carpeta src usando el comando **cd src/**
ahora buscamos el archivo que es el Main de nuestra Tarea que se llama "CalculadoraCLI" usando el comando "**ls**"

al ubicar el archivo compilamos con el siguiente comando:
**javac CalculadoraCLI.java**

despues para correr el programa ponemos el comando:
**java CalculadoraCLI** 






