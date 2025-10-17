// Paquete donde se encuentra la clase.
// "modelo" contiene las clases principales del dominio del sistema.
package modelo;

// Importación de librerías necesarias.
import java.util.ArrayList; // Permite crear listas dinámicas.
import java.util.Date;      // Permite manejar fechas (usada para la fecha del pedido).
import java.util.List;      // Interfaz que define el comportamiento de las listas.

// ---------------------------------------------------------------
// 🔹 Clase Pedido
// ---------------------------------------------------------------

// La clase Pedido representa una orden o solicitud realizada por un cliente.
// Dentro del patrón Factory Method, esta clase cumple el rol de "Cliente del patrón",
// ya que utiliza la fábrica (PedidoFactory) para crear productos sin conocer sus clases concretas.
public class Pedido {

    // ---------------------------------------------------------------
    // 🔹 Atributos o propiedades
    // ---------------------------------------------------------------

    // "cliente": asocia el pedido con la persona que lo realiza.
    private Cliente cliente;

    // "productos": lista donde se almacenan los objetos de tipo Producto (Foto, Impresion...).
    private List<Producto> productos;

    // "fecha": guarda la fecha en la que se crea el pedido.
    private Date fecha;

    // "numeroTarjetaCredito": almacena un número de tarjeta simulado para el pago.
    private int numeroTarjetaCredito;

    // "factory": es el objeto que implementa el método fábrica (Factory Method).
    // Se encarga de crear los productos sin que esta clase conozca sus detalles.
    private PedidoFactory factory;

    // ---------------------------------------------------------------
    // 🔹 Constructor
    // ---------------------------------------------------------------

    // El constructor inicializa el pedido con los datos del cliente y el número de tarjeta.
    // Además, crea una nueva lista vacía de productos, asigna la fecha actual,
    // y crea una instancia de PedidoFactory para usar el patrón Factory Method.
    public Pedido(Cliente cliente, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.fecha = new Date(); // Se toma la fecha actual del sistema.
        this.productos = new ArrayList<>(); // Se inicializa la lista de productos vacía.
        this.factory = new PedidoFactory(); // Se crea una instancia de la fábrica concreta.
    }

    // ---------------------------------------------------------------
    // 🔹 Método agregarProducto()
    // ---------------------------------------------------------------

    // Este método agrega un nuevo producto al pedido.
    // Aquí se aplica directamente el patrón Factory Method:
    // en lugar de crear los objetos directamente con "new", se usa la fábrica.
    // Parámetros:
    // - tipo: tipo de producto ("foto" o "impresion")
    // - parametro: información adicional (nombre de archivo o color)
    public void agregarProducto(String tipo, String parametro) {

        // Se llama al método crearProducto() de PedidoFactory.
        // Este método devuelve un objeto del tipo Producto.
        Producto p = factory.crearProducto(tipo, parametro);

        // Si la fábrica devuelve un objeto válido (no nulo), se agrega a la lista.
        if (p != null) {
            productos.add(p);
            System.out.println("✅ Producto agregado: " + p.getDescripcion());
        }
    }

    // ---------------------------------------------------------------
    // 🔹 Método eliminarProducto()
    // ---------------------------------------------------------------

    // Este método permite eliminar un producto de la lista por su índice.
    // Primero valida que el índice sea válido (dentro de los límites de la lista).
    public void eliminarProducto(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            // Si es válido, se elimina y se muestra el producto eliminado.
            Producto eliminado = productos.remove(indice);
            System.out.println("🗑️ Producto eliminado: " + eliminado.getDescripcion());
        } else {
            // Si el índice no existe, se muestra un mensaje de error.
            System.out.println("❌ Índice inválido.");
        }
    }

    // ---------------------------------------------------------------
    // 🔹 Método listarProductos()
    // ---------------------------------------------------------------

    // Recorre la lista de productos e imprime cada uno con su descripción.
    // Sirve para mostrar visualmente los productos del pedido.
    public void listarProductos() {
        System.out.println("\n📋 Lista de productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getDescripcion());
        }
    }

    // ---------------------------------------------------------------
    // 🔹 Método calcularTotal()
    // ---------------------------------------------------------------

    // Calcula la suma total del precio de todos los productos agregados.
    // Para cada producto en la lista, se llama a su método calcularPrecio().
    // Aquí se demuestra el POLIMORFISMO: cada tipo de producto calcula su precio de forma diferente.
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularPrecio();
        }
        return total;
    }
    // Nuevo método para agregar un producto ya existente (por ejemplo, una Foto capturada con la cámara)
public void agregarProductoExistente(Producto p) {
    productos.add(p);
    System.out.println("✅ Producto agregado manualmente: " + p.getDescripcion());
}


    // ---------------------------------------------------------------
    // 🔹 Método mostrarPedido()
    // ---------------------------------------------------------------

    // Muestra un resumen completo del pedido.
    // Incluye los datos del cliente, la fecha, el número de tarjeta,
    // la lista de productos y el total calculado.
    public void mostrarPedido() {
        System.out.println("\n🧾 Pedido del cliente: " + cliente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Número de tarjeta: " + numeroTarjetaCredito);
        listarProductos(); // Llama al método que imprime los productos.
        System.out.println("💰 Total a pagar: $" + calcularTotal());
    }
}
