package MICASA;

import java.util.Scanner;

public class GreenClick {
  
    public static String[] nombres = { "Maria Juana", "Hierba de los Bosques", "La Seta Feliz", "El Oro Verde" };
    public static String[] origenes = { "Mexico", "Andorra", "Marruecos", "Palestina" };
    public static double[] precios = { 1.70, 4.20, 2.47, 1.33 };
    
    public static Producto[] productos;
   
    public static CarritoItem[] carrito = new CarritoItem[10];
    public static int contadorCarrito = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear productos a partir de los datos
        productos = new Producto[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            productos[i] = new Producto(nombres[i], origenes[i], precios[i]);
        }
        
        Catalogo catalogo = new Catalogo(productos);
        String opcion = "";
        
    
        while (true) {
            System.out.println("\n--- Menú Green & Click ---");
            System.out.println("1. Buscar producto por nombre");
            System.out.println("2. Buscar producto por origen");
            System.out.println("3. Ordenar productos por precio (ascendente)");
            System.out.println("4. Ordenar productos por precio (descendente)");
            System.out.println("5. Añadir producto al carrito");
            System.out.println("6. Eliminar producto del carrito");
            System.out.println("7. Finalizar compra");
            System.out.println("Escribe 'salir' para terminar");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();
            
            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            } else if (opcion.equals("1")) {
                System.out.print("Ingrese el nombre o parte del nombre: ");
                String busqueda = scanner.nextLine();
                catalogo.buscarPorNombre(busqueda);
            } else if (opcion.equals("2")) {
                System.out.print("Ingrese el origen: ");
                String busqueda = scanner.nextLine();
                catalogo.buscarPorOrigen(busqueda);
            } else if (opcion.equals("3")) {
                catalogo.ordenarPorPrecioAscendente();
            } else if (opcion.equals("4")) {
                catalogo.ordenarPorPrecioDescendente();
            } else if (opcion.equals("5")) {
                anadirProducto();
            } else if (opcion.equals("6")) {
                eliminarProducto();
            } else if (opcion.equals("7")) {
                finalizarCompra();
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
    
    public static void anadirProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre exacto del producto a añadir: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        double cantidadProducto = scanner.nextDouble();
        scanner.nextLine(); 
        int contadorEncontrados = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].nombre.equalsIgnoreCase(nombreProducto)) {
                if (contadorCarrito < carrito.length) {
                    carrito[contadorCarrito] = new CarritoItem(productos[i], cantidadProducto);
                    contadorCarrito = contadorCarrito + 1;
                    System.out.println("Producto añadido al carrito.");
                } else {
                    System.out.println("El carrito está lleno.");
                }
                contadorEncontrados = contadorEncontrados + 1;
                break;
            }
        }
        if (contadorEncontrados == 0) {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreProducto = scanner.nextLine();
        int contadorEncontrados = 0;
        for (int i = 0; i < contadorCarrito; i++) {
            if (carrito[i].producto.nombre.equalsIgnoreCase(nombreProducto)) {
                for (int j = i; j < contadorCarrito - 1; j++) {
                    carrito[j] = carrito[j + 1];
                }
                contadorCarrito = contadorCarrito - 1;
                System.out.println("Producto eliminado del carrito.");
                contadorEncontrados = contadorEncontrados + 1;
                break;
            }
        }
        if (contadorEncontrados == 0) {
            System.out.println("Producto no encontrado en el carrito.");
        }
    }
    
    public static void finalizarCompra() {
        double total = 0;
        System.out.println("Productos en el carrito:");
        for (int i = 0; i < contadorCarrito; i++) {
            total = total + carrito[i].producto.precio * carrito[i].cantidad;
        }
        System.out.println("Total de la compra: " + total);
    }
}
