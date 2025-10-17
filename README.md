# parcialIngenieria
# 🧩 Patrón Factory Method en Java

Este proyecto implementa el patrón **Factory Method** basado en un sistema de impresión y fotografía.

## 📚 Descripción

El objetivo es permitir que la clase `Pedido` cree distintos tipos de `Producto` (como `Foto` o `Impresion`) sin conocer sus clases concretas.  
La creación de objetos se delega a `PedidoFactory`, que actúa como la fábrica concreta del patrón.

## 🏗️ Clases principales

- **Producto (abstracta):** Clase base para todos los productos.
- **Foto / Impresion:** Implementaciones concretas de Producto.
- **Creator / PedidoFactory:** Implementan el patrón Factory Method.
- **Pedido:** Administra el pedido y utiliza la fábrica para crear productos.
- **Main:** Ejecuta la demostración.

## ⚙️ Ejecución

Compila y ejecuta el proyecto con:

```bash
javac -d bin src/modelo/*.java src/main/Main.java
java -cp bin main.Main
