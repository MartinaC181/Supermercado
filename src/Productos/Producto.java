package Productos;

public class Producto {
    private String nombre;
    private double precioUnidad;
    private double precioTotal;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precioUnidad = precio;
        this.cantidad = cantidad;
        this.precioTotal = precio * cantidad;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nPrecio: " + this.precioUnidad + "\nCantidad: " + this.cantidad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecioUnidad() {
        return this.precioUnidad;
    }

    public double getPrecioTotal() {
        return this.precioTotal;
    }

    public double setPrecioTotal(double precioTotal) {
        return this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad -= cantidad ;
    }
}


