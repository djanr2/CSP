package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.algorithm.BacktrackingAlgorithm;
import ia.iimas.unam.mx.model.Domain;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;

import java.io.IOException;
import java.util.*;

import static ia.iimas.unam.mx.problem.map.coloring.Color.GREEN;

public class BacktrackSolution  extends BacktrackingAlgorithm {

    private HashSet<IVariable> solution;
    PriorityQueue<IVariable> countries = new PriorityQueue<IVariable> (

            new Comparator<IVariable>() {
                public int compare(IVariable a, IVariable b) {
                    if (a.countLegalValues() > b.countLegalValues()) return 1;
                    if (a.countLegalValues() < b.countLegalValues()) return -1;
                    return 0;
                }
            });

    PriorityQueue<IDomain> domain = new PriorityQueue<> (

            new Comparator<IDomain>() {
                public int compare(IDomain a, IDomain b) {
                    if (a.getOrder() > b.getOrder()) return 1;
                    if (a.getOrder() < b.getOrder()) return -1;
                    return 0;
                }
            });

    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;

        for (IVariable var:
                this.csp.getArcs()) {
            Country c =  (Country)var;

            countries.add(var);
        }
    }

    @Override
    public void run() {

        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo BACKTRACKING para el problema de seleccion de colores visto en clase:");
        System.out.println("encontrara todas las soluciones posibles para el problema");
        System.out.println();

        Iterator current = this.csp.getArcs().iterator();
        System.out.println(this.csp.getArcs());

        System.out.println(">>>>>>>>>>>>>>>>");

        backtrack(current, new HashSet<>());

    }

    private void backtrack( Iterator current,  Set<Country> solution){
        Country country = (Country) current.next();
        HashSet<IVariable> n;
        HashSet<IDomain> d;


        for(IDomain color : cloneDomain(country.getDomain())){
            n= cloneNeighbors(country.getNeighbors());
            d= cloneDomain(country.getDomain());
            if(country.setColor(color)){
                System.out.print(country);
                System.out.println(" "+country.getDomain());

                for (IVariable cty: country.getNeighbors()){
                    System.out.println(cty+""+cty.getDomain());

                    backtrack(current, solution);
                }

            }
            country.setDomain(d);
            country.setNeighbors(n);
        }
    }

    private HashSet<IDomain> cloneDomain(Set<IDomain> domain){
        return new HashSet<>(domain);
    }

    private HashSet<IVariable> cloneNeighbors(Set<IVariable> neighbors){
        HashSet<IVariable> clone = new HashSet<>();
        for (IVariable cty:
            neighbors){
            clone.add(cty.cloneElement());
        }
        return clone;
    }

    public static void click(){
        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
