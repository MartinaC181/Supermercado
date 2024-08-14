 class Humane {

    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }
}
class Empleado extends Humane{
    private double salario;
    private String Caja;

    public Empleado(double salario, String Caja, String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        this.salario = salario;
        this.Caja = Caja;
    }

    public String toString() {
        return super.toString() + "\nSalario: " + this.salario + "\nCaja: " + this.Caja;
    }
}

class Caja {
    private Empleado empleado;

    public Caja(Empleado empleado, int numCaja) {
        this.empleado = empleado;
    }

    public String toString() {
        return String.valueOf(empleado);
    }
}

class Cliente extends Humane {
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
        if (this.saldo >= producto.getPrecio() * cantidad) {
            this.saldo -= producto.getPrecio() * cantidad;
            producto.setCantidad(cantidad);
        }
    }

}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nPrecio: " + this.precio + "\nCantidad: " + this.cantidad;
    }

    public Producto getProducto(){
        return this;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad -= cantidad ;
    }
}

public class Main {
    public static void main(String[] args) {
        Humane a = new Humane("Juan", "Perez", 12345678);
        Empleado b = new Empleado(1000, "Caja1", "Juan", "Perez", 12345678);
        Cliente c = new Cliente(2000, true, "Juana", "Perez", 12346438);
        Producto d = new Producto("Papas", 100, 10);
        Caja e = new Caja(b, 1);
        //System.out.println(c.toString());
        c.comprar(d, 2);
        System.out.println(d.toString());
    }
}