package MICASA;

public class Producto {
    public String nombre;
    public String origen;
    public double precio;
    
    public Producto(String nombreProducto, String origenProducto, double precioProducto) {
        nombre = nombreProducto;
        origen = origenProducto;
        precio = precioProducto;
    }
    
   
    public void imprimirProducto() {
        System.out.println("Producto: " + nombre + " | Origen: " + origen + " | Precio: " + precio);
    }
}
