package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.algorithm.AC3Algorithm;
import ia.iimas.unam.mx.model.IVariable;

public class AC3Solution extends AC3Algorithm {

    @Override
    public void run() {

        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo AC3 + Forward para el problema de seleccion de colores visto en clase:");
        System.out.println("Utiliza un metodo random para seleccionar un color al azar, es configurado a encontrar inconsistencias");
        System.out.println();
        System.out.println("Para demosrtrar si una variable no tiene dominio para elegir, no encuentra solucion es inconsistente.");
        System.out.println("Debido al metodo random a veces encuentra Inconsistencias");
        System.out.println("Cada que se asigna un color a una variable se elimina del dominio de los vecinos la variable. Demostrando asi la" );
        System.out.println("implementacion de metodo FORWARD");
        System.out.println();

        for(IVariable var: this.csp.getArcs()){
            Country country = (Country) var;

            if(!country.setColor(country.getRandomColor())){
                System.out.println(country);
                System.out.println();
                System.out.println("No se encontro solucion en esta configuracion de colores. Inconsistencia encontrada");
                break;
            }
            printCountry(country);
        }

    }


}
