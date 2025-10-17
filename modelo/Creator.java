// Declaramos el paquete donde se encuentra la clase.
// "modelo" contiene todas las clases principales del sistema,
// incluyendo las que implementan el patrón de diseño.
package modelo;

// ---------------------------------------------------------------
// 🔹 Clase abstracta Creator
// ---------------------------------------------------------------

// Esta clase forma parte del PATRÓN DE DISEÑO FACTORY METHOD.
// Su función principal es definir una INTERFAZ para la creación de objetos,
// pero sin especificar qué tipo exacto de objeto se va a crear.
//
// La idea es que las subclases concretas (como PedidoFactory)
// sean las que decidan qué objeto específico instanciar.
//
// Por eso esta clase es "abstracta": no se puede crear directamente,
// sino que sirve como modelo o guía para otras clases.
public abstract class Creator {

    // ---------------------------------------------------------------
    // 🔹 Método abstracto crearProducto()
    // ---------------------------------------------------------------

    // Este método define la firma del "método fábrica" del patrón Factory Method.
    // Se declara como "abstract" porque no tiene implementación aquí.
    //
    // Recibe dos parámetros:
    // - "tipo": una cadena que indica qué tipo de producto se quiere crear
    //   (por ejemplo: "foto" o "impresion").
    // - "parametro": información adicional que necesita el producto para crearse
    //   (como el nombre del archivo o el color).
    //
    // Devuelve un objeto de tipo "Producto" (la clase abstracta base).
    // Esto permite que cualquier clase que herede de Creator
    // pueda devolver diferentes tipos de productos (Foto, Impresion, etc.),
    // pero siempre bajo la misma referencia genérica (Producto).
    public abstract Producto crearProducto(String tipo, String parametro);
}
