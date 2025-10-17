// Paquete donde está la clase, que agrupa las clases del modelo lógico del sistema.
package modelo;

// ---------------------------------------------------------------
// 🔹 Clase PedidoFactory
//El patrón Factory Method permite delegar la creación de objetos a una clase especializada (la fábrica)
//en lugar de crear los objetos directamente con new.

//En este sistema, hay varios tipos de productos (Camara, Impresion, etc.),
//y el pedido debe poder crearlos sin saber cuál clase concreta usar.

 //Objetivo del patrón:

//Evitar que la clase Pedido esté llena de if o switch para crear productos.
//En su lugar, la clase fábrica (PedidoFactory) decide qué tipo de producto instanciar.

// La clase PedidoFactory hereda de la clase abstracta Creator.
// Implementa el método abstracto crearProducto(), cumpliendo el patrón Factory Method.
// Su función es crear objetos del tipo correcto (Foto o Impresion) según el tipo indicado.
public class PedidoFactory extends Creator {

    // ---------------------------------------------------------------
    // Método sobrescrito crearProducto()
    // ---------------------------------------------------------------

    // Este método es el corazón del patrón Factory Method.
    // Recibe dos parámetros:
    // - tipo: indica qué tipo de producto se desea crear ("foto" o "impresion").
    // - parametro: información adicional que necesita el producto (nombre del archivo o color).
   @Override
public Producto crearProducto(String tipo, String parametro) {
    if (tipo.equalsIgnoreCase("foto")) {
        // ❌ Ya no se crea una cámara genérica aquí
        System.out.println("⚠️ Las fotos deben crearse desde la cámara real (no por la fábrica).");
        return null;
    } else if (tipo.equalsIgnoreCase("impresion")) {
        // ✅ La fábrica solo se encarga de las impresiones
        return new Impresion(parametro);
    }

    System.out.println("⚠️ Tipo de producto desconocido: " + tipo);
    return null;
}

}
