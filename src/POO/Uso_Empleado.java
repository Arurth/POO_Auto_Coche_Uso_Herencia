package POO;

import java.util.*;



public class Uso_Empleado {

    public static void main(String[] args) {

        Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006, 9, 25);

        jefe_RRHH.estableceIncentivo(2570);

        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("Ana", 30000, 2000, 07, 07);

        misEmpleados[1] = new Empleado("Carlos", 50000, 1995, 06, 15);

        misEmpleados[2] = new Empleado("Paco", 25000, 2005, 9, 25);

        misEmpleados[3] = new Empleado("Antonio", 47500, 2009, 11, 9);

        misEmpleados[4] = jefe_RRHH;

        misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 5, 26);



        for(Empleado e:misEmpleados){

            e.subeSueldo(5);

        }



        for(Empleado e: misEmpleados){

            System.out.println("Nombre: " + e.dameNombre()

                    + "Sueldo: " + e.dameSueldo()

                    + "Fecha de Alta: " + e.dameFechaContrato());

        }



    }

}



class Empleado{

    public Empleado(String nom, double sue, int agno, int mes, int dia){

        nombre = nom;

        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);

        Id = IdSiguiente;

        IdSiguiente++;


    }



    public Empleado(String nom){

        this(nom, 30000, 2000, 01, 01);

    }



    public String dameNombre(){

        return nombre + " Id: " + Id;

    }



    public double dameSueldo(){ //getter

        return sueldo;

    }



    public Date dameFechaContrato(){

        return altaContrato;

    }



    public void subeSueldo(double porcentaje){

        double aumento = sueldo*porcentaje/100;

        sueldo += aumento;

    }

    private String nombre;

    private double sueldo;

    private Date altaContrato;

    private static int IdSiguiente;

    private int Id;

}



class Jefatura extends Empleado{

    public Jefatura(String nom, double sue, int agno, int mes, int dia){

        super(nom, sue, agno, mes, dia);

    }

    public void estableceIncentivo(double b){

        incentivo = b;

    }



    public double dameSueldo(){

        double sueldoJefe = super.dameSueldo();

        return sueldoJefe + incentivo;

    }

    private double incentivo;

}