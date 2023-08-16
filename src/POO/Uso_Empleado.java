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
        Jefatura jefe_RRHH = new Jefatura("Sergio", 1433.34,2023,6,27);
        jefe_RRHH.estableceIncentivo(500.96);

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

        //Acá empleamos Sobrecarga (override) de constructores, así que teniamos que usar un nuevo empleado
        //y ahora mismo el codigo funciona para pasar por todos los parametros, problemas de automatizacion
        //Se podría poner un condicional para entrar en el Constructor que quiero, pero de momento lo dejare
        //hardcodeado, si el codigo se agrada le colocare el condicional 😁

        Empleados empleado_que_usa_otro_constructor =new Empleados("Juan");
        empleado_que_usa_otro_constructor.dameFechaContrato();
    }
}

class Empleados {
    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int idSiguiente;
    private int id;

    public Empleados(String nombre, double sueldo, int anio, int mes, int dia) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes, dia);
        altaContrato=calendario.getTime();
        id = idSiguiente;
        idSiguiente++;

    }

    public Empleados(String nombre){
        this(nombre,3000,2000,1,1);
    }

    public String dameNombre(){

        return nombre + " Id: " + id;

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

class Jefatura extends Empleados{

    private double incentivo;
    Jefatura(String nombre, double sueldo, int anio, int mes, int dia){

        super(nombre, sueldo, anio, mes, dia);

    }

    public void estableceIncentivo(double b){

        incentivo=b;

    }

    public double dameSueldo(){

        double sueldoJefe = super.dameSueldo();

        return sueldoJefe + incentivo;

    }

}