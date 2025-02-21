package MICASA;

public class Catalogo {
    public Producto[] productos;
    
    public Catalogo(Producto[] productosRecibidos) {
        productos = productosRecibidos;
    }
    
    public void buscarPorNombre(String textoBusqueda) {
        int contador = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].nombre.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                productos[i].imprimirProducto();
                contador = contador + 1;
            }
        }
        if (contador == 0) {
            System.out.println("No se encontró ningún producto con ese nombre.");
        }
    }
    
    public void buscarPorOrigen(String origenBusqueda) {
        int contador = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].origen.equalsIgnoreCase(origenBusqueda)) {
                productos[i].imprimirProducto();
                contador = contador + 1;
            }
        }
        if (contador == 0) {
            System.out.println("No se encontró ningún producto con ese origen.");
        }
    }
    
    public void ordenarPorPrecioAscendente() {

        Producto[] copia = new Producto[productos.length];
        for (int i = 0; i < productos.length; i++) {
            copia[i] = productos[i];
        }
        /*ordenar de menor a mayor*/
        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = 0; j < copia.length - 1 - i; j++) {
                if (copia[j].precio > copia[j + 1].precio) {
                    Producto temporal = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temporal;
                }
            }
        }
        System.out.println("Productos ordenados por precio (ascendente):");
        for (int i = 0; i < copia.length; i++) {
            copia[i].imprimirProducto();
        }
    }
    
    public void ordenarPorPrecioDescendente() {
        Producto[] copia = new Producto[productos.length];
        for (int i = 0; i < productos.length; i++) {
            copia[i] = productos[i];
        }
        //  ordenar de mayor a menor precio
        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = 0; j < copia.length - 1 - i; j++) {
                if (copia[j].precio < copia[j + 1].precio) {
                    Producto temporal = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temporal;
                }
            }
        }
        System.out.println("Productos ordenados por precio (descendente):");
        for (int i = 0; i < copia.length; i++) {
            copia[i].imprimirProducto();
        }
    }
}
