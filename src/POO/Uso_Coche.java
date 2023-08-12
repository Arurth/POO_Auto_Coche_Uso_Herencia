package POO;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

public class Uso_Coche {

    public static void main(String[] args) {

        Coche micoche = new Coche();

        micoche.establece_color(JOptionPane.showInputDialog("Introduce un color"));

        System.out.println(micoche.dime_datos_generales());

        System.out.println(micoche.dime_color());
        
        micoche.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));

        System.out.println(micoche.dime_asientos());

        micoche.configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));

        System.out.println(micoche.dime_climatizador());

        System.out.println(micoche.dime_peso_coche());

        System.out.println("El precio final del coche es: " + micoche.precio_coche());


    }

}
