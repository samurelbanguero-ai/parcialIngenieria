// Paquete donde se encuentra la clase.
// "modelo" agrupa todas las clases que representan los elementos principales del sistema.
package modelo;

// ---------------------------------------------------------------
// 🔹 Clase Foto (subclase de Producto)
// ---------------------------------------------------------------

// La clase Foto representa un tipo de producto específico del sistema.
// Hereda de la clase abstracta Producto, lo que significa que debe implementar
// todos los métodos abstractos definidos allí (print, calcularPrecio, getDescripcion).
public class Foto extends Producto {

    // ---------------------------------------------------------------
    // 🔹 Atributos o propiedades
    // ---------------------------------------------------------------

    // "fichero" almacena el nombre o ruta del archivo de la foto.
    // Por ejemplo: "paisaje_colombia.jpg"
    private String fichero;

    // "camara" representa la cámara con la que se tomó la foto.
    // Este atributo crea una relación directa entre la clase Foto y la clase Camara.
    private Camara camara;

    // ---------------------------------------------------------------
    // 🔹 Constructor
    // ---------------------------------------------------------------

    // El constructor inicializa los atributos de la clase.
    // Recibe el nombre del archivo y el objeto Camara con el que fue tomada.
    // Esto demuestra una relación de COMPOSICIÓN: una foto depende de una cámara.
    public Foto(String fichero, Camara camara) {
        this.fichero = fichero;
        this.camara = camara;
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito print()
    // ---------------------------------------------------------------

    // Este método implementa el comportamiento definido en la clase abstracta Producto.
    // Su propósito es "imprimir" o mostrar en consola la información de la foto.
    // Se usa la anotación @Override porque estamos sobrescribiendo un método abstracto.
    @Override
    public void print() {
        System.out.println("🖼️ Imprimiendo foto: " + fichero + " tomada con " + camara);
    }

    // ---------------------------------------------------------------
    // 🔹 Método propio editarFoto()
    // ---------------------------------------------------------------

    // Este método no proviene de la clase padre.
    // Es una funcionalidad adicional exclusiva de la clase Foto,
    // que simula la acción de editar la imagen antes de imprimirla.
    public void editarFoto() {
        System.out.println("🎨 Editando foto: " + fichero);
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito calcularPrecio()
    // ---------------------------------------------------------------

    // Implementa el método abstracto de la clase Producto.
    // Devuelve el costo fijo de imprimir una foto (en este caso, 1500.0).
    // En un caso real, este valor podría calcularse dinámicamente.
    @Override
    public double calcularPrecio() {
        return 1500.0;
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito getDescripcion()
    // ---------------------------------------------------------------

    // También proviene de la clase Producto.
    // Devuelve una cadena con una descripción legible del producto (la foto).
    @Override
    public String getDescripcion() {
        return "Foto del archivo '" + fichero + "'";
    }

    // ---------------------------------------------------------------
    // 🔹 Método sobrescrito toString()
    // ---------------------------------------------------------------

    // Sobrescribimos el método toString() de Object para personalizar
    // cómo se mostrará el objeto Foto si lo imprimimos directamente.
    @Override
    public String toString() {
        return "Foto{" + "fichero='" + fichero + "', camara=" + camara + '}';
    }
}
