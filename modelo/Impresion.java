// Paquete donde se encuentra esta clase.
// "modelo" contiene las clases principales del dominio,
// incluyendo las que forman parte del patrón de diseño Factory Method.
package modelo;

// ---------------------------------------------------------------
// 🔹 Clase Impresion (subclase concreta de Producto)
// ---------------------------------------------------------------

// La clase "Impresion" representa otro tipo de producto dentro del sistema.
// Hereda de la clase abstracta "Producto", por lo que debe implementar
// todos los métodos abstractos definidos en ella (print, calcularPrecio, getDescripcion).
public class Impresion extends Producto {

    // ---------------------------------------------------------------
    // 🔹 Atributo de la clase
    // ---------------------------------------------------------------

    // "color" almacena el tipo de impresión: puede ser "Azul", "Rojo",
    // o "Blanco y negro". Este atributo define una característica principal del producto.
    private String color;

    // ---------------------------------------------------------------
    // 🔹 Constructor
    // ---------------------------------------------------------------

    // El constructor recibe un parámetro (el color de impresión)
    // y lo asigna al atributo interno de la clase.
    // Ejemplo: new Impresion("Blanco y negro")
    public Impresion(String color) {
        this.color = color;
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito print()
    // ---------------------------------------------------------------

    // Implementa el método abstracto de la clase Producto.
    // Este método simula la acción de imprimir un documento en el color indicado.
    // Se utiliza @Override porque sobrescribe el método de la superclase.
    @Override
    public void print() {
        System.out.println("🖨️ Imprimiendo documento en color: " + color);
    }

    // ---------------------------------------------------------------
    // 🔹 Método configurarColor()
    // ---------------------------------------------------------------

    // Este es un método propio de la clase Impresion (no proviene de Producto).
    // Permite cambiar el color de impresión de forma dinámica.
    // Representa una acción real del sistema: cambiar las preferencias de impresión.
    public void configurarColor(String nuevoColor) {
        this.color = nuevoColor;
        System.out.println("🎨 Color actualizado a: " + color);
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito calcularPrecio()
    // ---------------------------------------------------------------

    // Implementa el método abstracto de la clase Producto.
    // Determina el precio según el color seleccionado:
    // - Si es "blanco y negro", cuesta 500.0
    // - Si es cualquier otro color, cuesta 1000.0
    //
    // Este uso del operador ternario ( ? : ) es una forma corta de escribir un condicional.
    @Override
    public double calcularPrecio() {
        return color.equalsIgnoreCase("blanco y negro") ? 500.0 : 1000.0;
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito getDescripcion()
    // ---------------------------------------------------------------

    // Devuelve una descripción corta y legible del producto,
    // útil para mostrarla en listas o resúmenes de pedidos.
    @Override
    public String getDescripcion() {
        return "Impresión en color: " + color;
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito toString()
    // ---------------------------------------------------------------

    // Sobrescribe el método toString() de la clase Object.
    // Retorna una cadena con el formato: Impresion{color='Azul'}
    // Esto hace que si imprimimos directamente el objeto en consola,
    // se vea con un formato entendible y no como una referencia de memoria.
    @Override
    public String toString() {
        return "Impresion{" + "color='" + color + '\'' + '}';
    }
}
