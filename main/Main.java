// ---------------------------------------------------------------
// 📦 Paquete principal donde se encuentra la clase Main.
// ---------------------------------------------------------------
package main;

// Importamos todas las clases del paquete "modelo".
import modelo.*;

// Importamos la clase Scanner para leer datos desde el teclado.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // 🔹 1. Crear un objeto Scanner para leer la entrada del usuario
        // ---------------------------------------------------------------
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== 📸 SISTEMA DE PEDIDOS DE IMPRESIÓN ===\n");

        // ---------------------------------------------------------------
        // 🔹 2. Ingreso de datos del cliente
        // ---------------------------------------------------------------
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = entrada.nextLine();

        // Se crea el objeto Cliente con los datos ingresados.
        Cliente cliente = new Cliente(cedula, nombre);
        cliente.mostrarCliente();

        // ---------------------------------------------------------------
        // 🔹 3. Creación de la cámara (que se usará para las fotos)
        // ---------------------------------------------------------------
        System.out.print("\nIngrese la marca de la cámara: ");
        String marcaCam = entrada.nextLine();

        System.out.print("Ingrese el modelo de la cámara: ");
        String modeloCam = entrada.nextLine();

        // Se crea el objeto Camara con los datos ingresados por el usuario.
        Camara cam = new Camara(marcaCam, modeloCam);
        cam.mostrarDetalles();

        // ---------------------------------------------------------------
        // 🔹 4. Creación del pedido
        // ---------------------------------------------------------------
        System.out.print("\nIngrese el número de la tarjeta de crédito: ");
        int tarjeta = entrada.nextInt();
        entrada.nextLine(); // limpiar el buffer del teclado

        // Se crea el pedido con el cliente y su número de tarjeta.
        Pedido pedido = new Pedido(cliente, tarjeta);

        // ---------------------------------------------------------------
        // 🔹 5. Menú interactivo de opciones
        // ---------------------------------------------------------------
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE OPCIONES ===");
            System.out.println("1. Agregar Foto");
            System.out.println("2. Agregar Impresión");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Pedido");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    // ---------------------------------------------------------------
                    // 🖼️ Agregar una foto tomada con la cámara real (no de fábrica)
                    // ---------------------------------------------------------------
                    System.out.print("Ingrese el nombre del archivo de la foto: ");
                    String nombreFoto = entrada.nextLine();

                    // Se usa la cámara creada por el usuario para capturar la foto.
                    Foto fotoCapturada = cam.capturarFoto(nombreFoto);

                    // Ahora se agrega directamente la foto al pedido.
                    // Este método respeta el diagrama del profesor (Foto -> Camara).
                    pedido.agregarProductoExistente(fotoCapturada);
                    break;

                case 2:
                    // ---------------------------------------------------------------
                    // 🖨️ Agregar una impresión al pedido
                    // ---------------------------------------------------------------
                    System.out.print("Ingrese el color de la impresión: ");
                    String color = entrada.nextLine();

                    // La impresión sí se crea mediante la fábrica (Factory Method).
                    pedido.agregarProducto("impresion", color);
                    break;

                case 3:
                    // ---------------------------------------------------------------
                    // 🗑️ Eliminar un producto existente
                    // ---------------------------------------------------------------
                    pedido.listarProductos();
                    System.out.print("Ingrese el número del producto a eliminar: ");
                    int indice = entrada.nextInt() - 1; // el usuario ve desde 1
                    pedido.eliminarProducto(indice);
                    break;

                case 4:
                    // ---------------------------------------------------------------
                    // 🧾 Mostrar el resumen del pedido
                    // ---------------------------------------------------------------
                    pedido.mostrarPedido();
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción no válida, intente de nuevo.");
            }

        } while (opcion != 0);

        // ---------------------------------------------------------------
        // 🔹 6. Finalización del programa
        // ---------------------------------------------------------------
        entrada.close();
        System.out.println("\n✅ Programa finalizado correctamente.");
    }
}
