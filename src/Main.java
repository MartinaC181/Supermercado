import Clientes.Cliente;
import Productos.Producto;
import Empleados.Empleado;
//import Cajas.Caja;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Creamos un historial de empleados 
        ArrayList <Empleado> listaEmpleados = new ArrayList <Empleado>();

        //Creamos una lista de cajas

        //Creamos un historial de clientes que compraron
        ArrayList <Cliente> listaClientes = new ArrayList <Cliente>();

        //Creamos una lista de productos en stock por default
        ArrayList <Producto> listaProductos = new ArrayList <Producto>();
        Producto p1 = new Producto("Papas", 100, 10);
        Producto p2 = new Producto("Manzanas", 200, 5);
        Producto p3 = new Producto("Bananas", 50, 20);
        listaProductos.add(p1);
        listaProductos.add(p2); 
        listaProductos.add(p3);

        //Creamos una lista de transacciones donde guardaremos los productos comprados
        ArrayList <Producto> listaTransacciones = new ArrayList <Producto>();

        //Comienza el juego pidiendo al usuario que seleccione su rol
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Bienvenido al supermercado!");
        System.out.println("Seleccione su rol:");
        System.out.println("1. Empleado");
        System.out.println("2. Cliente");
        System.out.print("Ingrese el número correspondiente a su rol: ");
        int rol = input.nextInt();
        input.nextLine(); // salto de linea

        switch (rol) {
            case 1:
                System.out.println("Rol seleccionado: Empleado");
                System.out.println("Bienvenido, empleado! Por favor, ingrese sus datos:");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Ingrese su nombre: ");
                String nombreEmpleado = input.nextLine();

                System.out.println("Ingrese su apellido: ");
                String apellidoEmpleado = input.nextLine();

                System.out.println("Ingrese su DNI: ");
                int dniEmpleado = input.nextInt();
                System.out.println("Ingrese la caja en la que trabajará: ");
                String caja = input.next();

                Empleado nuevoEmpleado = new Empleado( caja, nombreEmpleado, apellidoEmpleado, dniEmpleado);
                listaEmpleados.add(nuevoEmpleado);
                System.out.println("Empleado agregado con éxito!");
                System.out.println(nombreEmpleado.toString());

                System.out.println("-------------------------------------------------------------------------------");

                System.out.println("Puede agregar productos al stock.(1) o ver el historial de transacciones.(2)");
                int decision = input.nextInt();
                System.out.println("Cuantos productos desea agregar?");
                int cant = input.nextInt();

                while (decision <= cant) { 
                    System.out.println("Hora de agregar mas productos en stock!!!");
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = input.next();
                    System.out.println("Ingrese el precio por unidad del producto: ");
                    double precio = input.nextDouble();
                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidad = input.nextInt();

                    Producto producto = new Producto(nombre, precio, cantidad);
                    listaProductos.add(producto);
                    System.out.println("Producto agregado con éxito!");
                }
                System.out.println(listaProductos);

                while (decision == 2) {
                    input.nextLine(); 
                    System.out.println("Historial de transacciones:");
                    System.out.println(listaTransacciones);
                }
                break;

            case 2:
                input.nextLine(); 
                System.out.println("Rol seleccionado: Cliente");
                System.out.println("Bienvenido, cliente!");
                System.out.println("Ingrese su nombre: ");
                String nombreCliente = input.nextLine();
                System.out.println("Ingrese su apellido: ");
                String apellidoCliente = input.nextLine();
                System.out.println("Ingrese su DNI: ");
                int dniCliente = input.nextInt();
                System.out.println("Ingrese su saldo: ");
                double saldoCliente = input.nextDouble();
                System.out.println("Es mayorista?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                System.out.print("Ingrese el número correspondiente a su respuesta: ");
                boolean esMayorista = input.nextInt() == 1 ? true : false;
                Cliente nuevoCliente = new Cliente(saldoCliente, esMayorista, nombreCliente, apellidoCliente, dniCliente);
                System.out.println("Desea realizar una compra?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                System.out.print("Ingrese el número correspondiente a su respuesta: ");
                int respuesta = input.nextInt();

                if (respuesta == 1) {
                    System.out.println("Tenemos en stock los siguientes productos:");
                    System.out.println(listaProductos);
                    System.out.println("Ingrese el nombre del producto que desea comprar: ");
                    String nombreProducto = input.nextLine();
                    System.out.println("Ingrese la cantidad que desea comprar: ");
                    int cantidadProducto = input.nextInt();
                    Producto productoComprado = new Producto(nombreProducto, 0, cantidadProducto);
                    for (Producto product : listaProductos) {
                        if (product.getNombre().equals(productoComprado.getNombre())) {
                            if (product.getCantidad() < productoComprado.getCantidad()) {
                            System.out.println("No hay suficiente stock de " + product.getNombre() + ".");
                            break;
                            }else {
                                System.out.println("El precio de " + product.getNombre() + " es de " + product.getPrecioUnidad() + " por unidad.");
                                System.out.println("calculando el precio total...");
                                double a = product.getPrecioUnidad() * productoComprado.getCantidad();
                                System.out.println("El precio total es de " + a);
                                productoComprado.setPrecioTotal(a);
                                nuevoCliente.comprar(product, cantidadProducto);
                                listaTransacciones.add(productoComprado);
                                listaClientes.add(nuevoCliente);
                                System.out.println("Compra realizada con éxito!");
                            }
                        }
                    
                    }
                } else if (respuesta == 2) {
                    System.out.println("Gracias por visitar nuestro supermercado!");
                } else {
                    System.out.println("Respuesta no válida. Por favor, seleccione 1 o 2.");
                }
            break;

        default:
            System.out.println("Rol no válido. Por favor, seleccione 1 o 2.");
            break;
        }

        input.close();
    }
}