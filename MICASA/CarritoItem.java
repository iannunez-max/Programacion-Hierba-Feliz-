package MICASA;

public class CarritoItem {
    public Producto producto;
    public double cantidad;
    
    public CarritoItem(Producto productoRecibido, double cantidadProducto) {
        producto = productoRecibido;
        cantidad = cantidadProducto;
    }
    
    
    public void imprimirCarritoItem() {
        System.out.println(producto.nombre + " x " + cantidad + " = " + (producto.precio * cantidad));
    }
}
