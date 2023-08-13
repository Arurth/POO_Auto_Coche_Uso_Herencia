package POO;

import javax.swing.*;

public class BadPractices_and_Static {
    public static void main(String[] args) {

        Empleados empleado1 = new Empleados(JOptionPane.showInputDialog("Ingresa el nombre del empleado"));
        Empleados empleado2 = new Empleados(JOptionPane.showInputDialog("Ingresa el nombre del empleado"));
        Empleados empleado3 = new Empleados(JOptionPane.showInputDialog("Ingresa el nombre del empleado"));


        //Originalmente no se empleaba foreach, ni for, se hacía manualmente ya quela idea era mostrarte de forma
        //practica el uso de 'Static', quise aplicar ceonceptos previos visto



        Empleados[] lista_empleados = { empleado1, empleado2,empleado3};



        for(Empleados i : lista_empleados){

            i.cambiarSeccion(JOptionPane.showInputDialog("Cambia la seccion de " + i.traerNombre() ));
            //Para agregar el nombre del empleado, busque varias formas e incluso re vi foreach para poder indicarle
            //la posicion o el nombre (empleando una variable auxiliar) del empleado pero había olvidado lo mas sencillo
            // podía crear un metodo getter que devuelva el nombre 😬

            System.out.println(i.devuelveDatos());
        }


    }


}
//La clase empleados es por defecto publica al no serle asignada un modificador de acceso
//Java no permite que un archivo .java tenga mas de una clase publica en un mismo archivo.
//Es por esto que no podemos modificador de acceso publico, ademas de que realizar un archivo java con mas de una+
//clase. Esto es algo que no se recomienda, pero siempre es bueno saber el por que.
class Empleados{

    Empleados(String nombre){
        this.nombre = nombre;

        seccion = "Administracion";

        id = idSiguiente;

        idSiguiente++;

    }

    public String traerNombre(){

        return nombre;

    }

    public void cambiarSeccion(String seccion){

        this.seccion=seccion;

    }

    public String devuelveDatos(){
        return "El nombre es " + nombre + ", la seccion " + seccion +  ", y el Id es " +id;
    }
    private String nombre;

    private String seccion;

    private int id;

    static int idSiguiente = 1;
}
