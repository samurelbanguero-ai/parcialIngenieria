// Paquete donde se encuentra la clase.
// Agrupa las clases principales del modelo, incluyendo las del patrón Factory Method.
package modelo;

// ---------------------------------------------------------------
// 🔹 Clase abstracta Producto
// ---------------------------------------------------------------

// Esta clase define la estructura general que comparten todos los productos del sistema.
// Forma parte del PATRÓN DE DISEÑO FACTORY METHOD, actuando como la clase "Product" abstracta.
//
// Su propósito es establecer un modelo o contrato que todas las clases hijas deben seguir.
// Es decir, cada producto (Foto, Impresion, etc.) debe implementar los métodos definidos aquí.
public abstract class Producto {

    // ---------------------------------------------------------------
    // 🔹 Atributo protegido
    // ---------------------------------------------------------------

    // "numero" representa un identificador único para cada producto.
    // Se declara como "protected" para que las clases hijas puedan acceder a él directamente,
    // pero sigue estando protegido contra el acceso externo (encapsulamiento).
    protected int numero;

    // ---------------------------------------------------------------
    // 🔹 Métodos abstractos
    // ---------------------------------------------------------------

    // Cada uno de estos métodos define una acción o característica que todos los productos deben tener.
    // Sin embargo, la clase abstracta NO indica cómo se realiza la acción.
    // Esa responsabilidad la tienen las subclases concretas.

    // Método abstracto que representa la acción de imprimir o mostrar el producto.
    // Las clases hijas (Foto, Impresion) lo implementarán de forma diferente.
    public abstract void print();

    // Método abstracto que calcula el precio del producto.
    // Cada tipo de producto tiene un costo distinto, por lo que la implementación cambia.
    public abstract double calcularPrecio();

    // Método abstracto que devuelve una breve descripción del producto.
    // Esto se usa para listar los productos dentro del pedido.
    public abstract String getDescripcion();

    // ---------------------------------------------------------------
    // 🔹 Método concreto mostrarInfo()
    // ---------------------------------------------------------------

    // Este método sí tiene implementación porque es común para todos los productos.
    // Muestra en consola la información general del producto,
    // combinando el número del producto y la descripción devuelta por getDescripcion().
    public void mostrarInfo() {
        System.out.println("🆔 Producto #" + numero + ": " + getDescripcion());
    }

    // ---------------------------------------------------------------
    // 🔹 Métodos de acceso (getters y setters)
    // ---------------------------------------------------------------

    // Devuelve el número del producto.
    public int getNumero() {
        return numero;
    }

    // Permite asignar o cambiar el número del producto.
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
