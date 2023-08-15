package POO;

import javax.swing.*;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.Integer.parseInt;

public class Uso_Empleado {
    public static void main(String[] args) {

        int cantEmpleados = parseInt(JOptionPane.showInputDialog("Cuantos empleados tiene?"));

        Empleados[] misEmpleados = new Empleados[cantEmpleados];

        /* int i = 0; Este codigo busca automatizar la creacion de empleados usando un foreach, como se ve es mas
        'trabajoso' el hacerlo, por eso al final me decidi por el viejo y confiable for.

        for (Empleados empleado : misEmpleados) {
            String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el sueldo"));
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el año"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el mes"));
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el día"));

            empleado = new Empleados(nombre, sueldo, anio, mes, dia);
            misEmpleados[i] = empleado;

            i++;
        } */

        for (int i = 0 ; i < misEmpleados.length; i++){

            misEmpleados[i] = new Empleados(JOptionPane.showInputDialog("Ingresa el nombre"),
                    Double.parseDouble(JOptionPane.showInputDialog("Ingresa el sueldo")),
                    parseInt(JOptionPane.showInputDialog("Ingresa el anio")),
                    parseInt(JOptionPane.showInputDialog("Ingresa el mes")),
                    parseInt(JOptionPane.showInputDialog("Ingresa el día")));

        }

        for (Empleados aumentoEmpleado: misEmpleados) {

            aumentoEmpleado.subeSueldo(Double.parseDouble(JOptionPane.showInputDialog("Ingresa el % a aumentar de " +
                    aumentoEmpleado.dameNombre())));

        }

        for (Empleados datosEmpleados : misEmpleados ){

            System.out.println("Nombre: "+ datosEmpleados.dameNombre() + " | Sueldo: "+datosEmpleados.dameSueldo() +
                    " | Fecha de Alta: "+  datosEmpleados.dameFechaContrato());

        }
    }
}

class Empleados {
    private String nombre;
    private double sueldo;
    private Date altaContrato;

    Empleados(String nombre, double sueldo, int anio, int mes, int dia) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes, dia);
        altaContrato=calendario.getTime();

    }

    public String dameNombre(){

        return nombre;

    }

    public double dameSueldo(){

        return sueldo;

    }

    public Date dameFechaContrato(){

        return altaContrato;

    }

    public void subeSueldo(double porcentaje){

        double aumentoSueldo = sueldo * porcentaje / 100;
        sueldo+=aumentoSueldo;

    }

}