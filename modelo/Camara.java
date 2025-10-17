// Declaramos el paquete al que pertenece esta clase.
// En este caso, "modelo" agrupa todas las clases del dominio del sistema,
// es decir, las que representan objetos reales (Cliente, Pedido, Foto, etc.).
package modelo;

// Definición de la clase pública "Camara".
// Es pública para que pueda ser usada desde otras partes del proyecto.
public class Camara {

    // ---------------------------------------------------------------
    //  Atributos o propiedades de la clase
    // ---------------------------------------------------------------

    // "marca" representa la marca comercial de la cámara (por ejemplo, Canon, Nikon...).
    // "modelo" identifica el modelo específico dentro de la marca.
    // Se declaran como "private" para aplicar el principio de ENCAPSULAMIENTO.
    private String marca;
    private String modelo;

    // ---------------------------------------------------------------
    // 🔹 Constructor
    // ---------------------------------------------------------------

    // El constructor permite crear objetos de tipo Camara con valores iniciales.
    // Recibe como parámetros la marca y el modelo, y los asigna a los atributos de la clase.
    // Ejemplo de uso:
    // Camara cam = new Camara("Nikon", "D7500");
    public Camara(String marca, String modelo) {
        // "this" se usa para diferenciar entre los atributos de la clase y los parámetros.
        this.marca = marca;
        this.modelo = modelo;
    }

    // ---------------------------------------------------------------
    // 🔹 Método capturarFoto()
    // ---------------------------------------------------------------

    // Este método simula la acción de tomar una fotografía con la cámara.
    // Recibe como parámetro el nombre del archivo (por ejemplo, "foto_viaje.jpg").
    // Luego, imprime un mensaje en consola para representar la acción
    // y devuelve un nuevo objeto de tipo "Foto", que se considera el resultado de la captura.
    public Foto capturarFoto(String nombreArchivo) {
        // Muestra un mensaje de simulación (no guarda archivos, solo imprime texto).
        System.out.println("📷 Capturando foto con " + marca + " " + modelo + "...");

        // Retorna un nuevo objeto de tipo Foto.
        // Se pasa como parámetro el nombre del archivo y la propia cámara ("this").
        // Esto crea una relación entre Foto y Camara (una foto se toma con una cámara).
        return new Foto(nombreArchivo, this);
    }

    // ---------------------------------------------------------------
    // 🔹 Método mostrarDetalles()
    // ---------------------------------------------------------------

    // Este método imprime en consola la información de la cámara.
    // Es útil para verificar que los datos del objeto son correctos.
    public void mostrarDetalles() {
        System.out.println("📸 Cámara: " + marca + " - Modelo: " + modelo);
    }

    // ---------------------------------------------------------------
    // 🔹 Método toString()
    // ---------------------------------------------------------------

    // Sobrescribe el método toString() heredado de la clase Object.
    // Devuelve una cadena con la marca y el modelo de la cámara.
    // Esto permite que, al imprimir un objeto Camara, se muestre de forma legible.
    @Override
    public String toString() {
        return marca + " " + modelo;
    }
}
