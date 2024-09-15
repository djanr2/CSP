package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.algorithm.BacktrackingAlgorithm;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;

import java.io.IOException;

import java.util.*;


public class BacktrackSolution  extends BacktrackingAlgorithm {

    private ArrayList<IVariable> countries_list;

    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;
    }

    @Override
    public void run() {

        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo BACKTRACKING para el problema de seleccion de colores visto en clase:");
        System.out.println("encontrara todas las soluciones posibles para el problema");
        System.out.println();

        countries_list = new ArrayList<>(this.csp.getArcs());

        System.out.println(countries_list);
        System.out.println();

       backtrack(countries_list.get(0), new HashSet<>());

    }

    private void backtrack( IVariable current_country,  Set<Country> solution){

        int index;

        Country country = (Country) current_country;

        for(IDomain color : cloneDomain(country.getDomain())){
            if(country.setColor(color)){
                index = countries_list.indexOf(country);
                index++;
                solution.add(country);
                if(index<countries_list.size()) {
                    backtrack(countries_list.get(index), solution);
                    country.removeColor();
                    solution.remove(country);
                }else{
                    System.out.println(solution);
                    country.removeColor();
                    solution.remove(country);
                }
            }
        }
    }

    private HashSet<IDomain> cloneDomain(Set<IDomain> domain){
        return new HashSet<>(domain);
    }

    public static void click(){
        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
