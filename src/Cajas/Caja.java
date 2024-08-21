package Cajas;
import Empleados.Empleado;;

public class Caja {
    private Empleado empleado;

    public Caja(Empleado empleado, int numCaja) {
        this.empleado = empleado;
    }

    public String toString() {
        return String.valueOf(empleado);
    }
}
