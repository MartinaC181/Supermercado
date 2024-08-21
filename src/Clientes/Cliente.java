package Clientes;
import Productos.Producto;

public class Cliente extends Persona.Humane {
    private double saldo;
    private boolean IsMayorista;

    public Cliente(double saldo, boolean IsMayorista, String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        this.saldo = saldo;
        this.IsMayorista = IsMayorista;
    }

    public String toString() {
        String s = super.toString() + "\nSaldo: " + this.saldo + "\nEs Mayorista: " + this.IsMayorista;
        return s;
    }

    public void comprar(Producto producto, int cantidad) {
        if (this.saldo >= producto.getPrecioTotal() * cantidad) {
            this.saldo -= producto.getPrecioTotal() * cantidad;
            producto.setCantidad(cantidad);
        }
    }

}
