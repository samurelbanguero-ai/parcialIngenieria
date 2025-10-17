// Declaramos el paquete donde se encuentra esta clase.
// "modelo" agrupa las clases que representan los elementos principales del sistema.
package modelo;

// Definición de la clase pública "Cliente".
// Es pública para que pueda ser utilizada desde otras clases (por ejemplo, en Pedido o Main).
public class Cliente {

    // ---------------------------------------------------------------
    // 🔹 Atributos o propiedades de la clase
    // ---------------------------------------------------------------

    // "cedula" representa el número de identificación del cliente.
    // "nombre" almacena el nombre del cliente.
    // Ambos atributos se declaran como "private" para aplicar el principio de ENCAPSULAMIENTO.
    private String cedula;
    private String nombre;

    // ---------------------------------------------------------------
    // 🔹 Constructor
    // ---------------------------------------------------------------

    // El constructor permite crear objetos de tipo Cliente con datos iniciales.
    // Recibe la cédula y el nombre como parámetros y los asigna a los atributos internos.
    // Ejemplo de uso:
    // Cliente cliente = new Cliente("1107842324", "Samuel Banguero");
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // ---------------------------------------------------------------
    // 🔹 Métodos getters (accesores)
    // ---------------------------------------------------------------

    // Método que devuelve el valor del atributo "cedula".
    // Se usa para acceder a la información de un atributo privado desde fuera de la clase.
    public String getCedula() {
        return cedula;
    }

    // Método que devuelve el valor del atributo "nombre".
    public String getNombre() {
        return nombre;
    }

    // ---------------------------------------------------------------
    // 🔹 Método actualizarNombre()
    // ---------------------------------------------------------------

    // Este método permite modificar el nombre del cliente después de haber creado el objeto.
    // Aplica el principio de "mutabilidad controlada": solo se cambia el valor mediante un método.
    // También muestra un mensaje en consola confirmando el cambio.
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        System.out.println("✅ Nombre actualizado: " + nuevoNombre);
    }

    // ---------------------------------------------------------------
    // 🔹 Método mostrarCliente()
    // ---------------------------------------------------------------

    // Imprime la información del cliente en un formato claro y legible.
    // Este método es útil para verificar los datos del cliente en consola.
    public void mostrarCliente() {
        System.out.println("👤 Cliente: " + nombre + " | Cédula: " + cedula);
    }

    // ---------------------------------------------------------------
    // 🔹 Método toString()
    // ---------------------------------------------------------------

    // Sobrescribe el método toString() heredado de la clase Object.
    // Devuelve una representación textual del cliente (nombre y cédula).
    // Esto permite que, si imprimimos directamente el objeto, aparezca con un formato amigable.
    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
