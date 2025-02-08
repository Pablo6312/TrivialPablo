# TrivialPablo 🎲  

Este es un programa que ejecuta un juego de **Trivial**, en el que se pedirá el nombre de los jugadores.  
Una vez inicializados los jugadores, comenzará la partida hasta que uno de ellos consiga **todos los quesitos**.

---

## 📌 Observaciones  

### 🔹 Enfoque del desarrollo  
He optado por utilizar **clases y objetos** para representar cada concepto importante del juego.  
Aunque el ejercicio no es muy grande, este enfoque permite **escalabilidad y mantenibilidad**, facilitando futuras mejoras.

---

## 📂 Estructura del Proyecto  

El código está organizado en **paquetes**, agrupando las clases según su funcionalidad:  

### **1️⃣ interfacemain**  
- 🏠 `Trivial.java` → Contiene el código `main`, los bucles principales y el ciclo del juego.

### **2️⃣ game**  
- 👤 `Player.java` → Representa a los jugadores, almacenando atributos como nombre y puntos obtenidos.  
  - *Ejemplo*: Se podría conectar con una base de datos para guardar partidas jugadas, etc.

### **3️⃣ questions**  
- Aquí se maneja toda la lógica de preguntas y respuestas, enlazando `arrays` para una mejor organización.  
  - 📌 Cuantas más preguntas y categorías haya, **más fácil será crear, organizar y buscar objetos**.  
- 📄 `Answer.java`  
- 📂 `Category.java`  
- ❓ `Question.java`  

### **4️⃣ utilities**  
- Almacena clases y métodos de utilidad que **no dependen directamente del juego**, como la gestión de ficheros o inputs.  
- 📁 `FilesManager.java`  

---

## ✍️ Cambio en la lectura de preguntas y respuestas  

He decidido **modificar la forma en que se leen las preguntas y respuestas** desde el archivo de texto.  
Esto se debe a que ya tenía un código optimizado de otro proyecto y pensé que era más organizado.  

### 📌 ¿Cómo funciona?  
- La **primera línea** del bloque de preguntas es la **respuesta correcta**.  
- Gracias a la clase `Answer.java`, se puede almacenar un atributo que indica si una respuesta es correcta.  
- Esto ahorra **una línea por pregunta**, lo cual puede ser **crucial** si se manejan miles de preguntas.

---

## 🗂️ Uso del `HashMap` en `Player.java`  

En la clase `Player.java`, he implementado un **`HashMap<String, Boolean>`** para rastrear las categorías obtenidas.  

### 🚀 ¿Por qué un `HashMap`?  
1. **Eficiencia** → Permite acceder rápidamente a las categorías obtenidas.  
2. **Claridad** → No es necesario manejar múltiples `arrays` para vincular jugadores con categorías.  
3. **Inmutabilidad** → Así la clase `Category` permanece intacta, sin necesidad de replicar datos innecesarios. Separando la `Category` que es donde van las preguntas y los puntos del Player `piePieces`
