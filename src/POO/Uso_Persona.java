package POO;

import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Uso_Persona {

    public static void main(String[] args) {

        Persona[] lasPersonas = new Persona[2];
        lasPersonas[0] = new Empleado("Ailyn", 5000, 2009, 2,25);
        lasPersonas[1] = new Alumno("Sergio", "Ingenieria en Sistemas");

        for(Persona i : lasPersonas){

            System.out.println(i.dameNombre() +", " +  i.dameDescripcion());

        }

    }

}

abstract class Persona{

    private String nombre;

    public Persona(String nombre){

        this.nombre = nombre;

    }

    public String dameNombre(){
        return nombre;
    }

    public abstract String dameDescripcion();

}

class Empleado extends Persona{

    private double sueldo;

    private Date altaContrato;

    private static int IdSiguiente;

    private int Id;

    public Empleado(String nom, double sue, int agno, int mes, int dia){

        super(nom);

        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);

        altaContrato = calendario.getTime();

        Id = IdSiguiente;

        IdSiguiente++;


    }

    public String dameDescripcion(){

        return  "Este empleado posee el ID: " + Id + " - y su sueldo es de : " + sueldo;

    }



    public Empleado(String nom){

        this(nom, 30000, 2000, 1, 1);

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

}

class Alumno extends Persona{

    private String carrera;

    Alumno(String nombre, String carrera){

    super(nombre);

    this.carrera = carrera;

    }

    @Override
    public String dameDescripcion() {

        return "el alumno esta en el 7mo cuatrimestre de " + carrera;

    }
}