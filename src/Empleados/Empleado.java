package Empleados;

public class Empleado extends Persona.Humane {
    private double salario;
    private String Caja;
    
    public Empleado(String Caja, String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        this.salario = 1000;
        this.Caja = Caja;
    }
    
    public String toString() {
        return super.toString() + "\nSalario: " + this.salario + this.Caja;
    }
}
