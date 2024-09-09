package ia.iimas.unam.mx;


import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.problem.map.coloring.Country;
import static ia.iimas.unam.mx.problem.map.coloring.CountryEnum.*;
import ia.iimas.unam.mx.problem.map.coloring.MapColoring;
import ia.iimas.unam.mx.problem.map.coloring.Source;


import static ia.iimas.unam.mx.problem.map.coloring.Color.GREEN;
import static ia.iimas.unam.mx.problem.map.coloring.MapColoringConstraint.DIFFERENT_COLOR;

public class Main {
    public static void main(String[] args) {
        MapColoring mcProblem = new MapColoring();

        Country c = Source.getCountry(WA);
        c.setColor(GREEN);
        c.setColor(GREEN);
        printCountry(c);

        c = Source.getCountry(NT);
        c.setColor(GREEN);




        printCountry(c);
        printCountry(Source.getCountry(SA));
    }

    private static void printCountry(IVariable country){
            Country c = (Country) country;
            System.out.println(c);
            System.out.println(c.getNeighbors());
        System.out.println();
    }
}
