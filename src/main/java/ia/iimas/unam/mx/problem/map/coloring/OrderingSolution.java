package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.algorithm.OrderingAlgorithm;

import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;


import java.util.Comparator;
import java.util.PriorityQueue;

import static ia.iimas.unam.mx.problem.map.coloring.Color.BLUE;
import static ia.iimas.unam.mx.problem.map.coloring.Color.GREEN;
import static ia.iimas.unam.mx.problem.map.coloring.CountryEnum.WA;

public class OrderingSolution extends OrderingAlgorithm {

    PriorityQueue<IVariable> leastLegalValues = new PriorityQueue<IVariable> (

            new Comparator<IVariable> () {
                public int compare(IVariable a, IVariable b) {
                    if (a.countLegalValues() > b.countLegalValues()) return 1;
                    if (a.countLegalValues() < b.countLegalValues()) return -1;
                    return 0;
                }
            });

    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;

        for (IVariable var:
                this.csp.getArcs()) {
            Country c =  (Country)var;
            if (c.getCountry().equals(WA)){
                c.removeDomainElement(GREEN);
                c.removeDomainElement(BLUE);
            }
            leastLegalValues.add(var);
        }
    }


    @Override
    public void run() {

        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo Ordenamiento para el problema de seleccion de colores visto en clase:");
        System.out.println("Utiliza un metodo random para seleccionar un color al azar, es configurado a encontrar inconsistencias");
        System.out.println();
        System.out.println("Para demosrtrar si una variable no tiene dominio para elegir, no encuentra solucion es inconsistente.");
        System.out.println("Debido al metodo random a veces encuentra Inconsistencias");
        System.out.println();
        System.out.println("Se eliminan 2 colores (GREEN, BLUE) del dominio para una variable (WA). Para demostrar que el algoritmo busca primero a");
        System.out.println("las variables con menos posibilidades");
        System.out.println();

        for(IVariable var: this.leastLegalValues){

            Country country = (Country) var;

            printDomain(country);

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
