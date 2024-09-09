package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.model.algorithm.AC3Algorithm;
import static ia.iimas.unam.mx.problem.map.coloring.CountryEnum.*;


import java.util.HashSet;


public class MapColoring extends AC3Algorithm {

    HashSet<IConstraint> generalConstraints;
    HashSet<IDomain> generalDomain;
    HashSet<IVariable> countries;


    public MapColoring() {
        this.generalDomain = (HashSet<IDomain>) Source.getDomain();
        this.generalConstraints = (HashSet<IConstraint>) Source.getConstraints();
        configureNodes();
    }

    public HashSet<IConstraint> getGeneralConstraints() {
        return generalConstraints;
    }

    public HashSet<IDomain> getGeneralDomain() {
        return generalDomain;
    }

    public HashSet<IVariable> getCountries() {
        return countries;
    }

    private void configureContries(){
        this.countries = (HashSet<IVariable>) Source.getVariables();


        for (IVariable var: this.countries){
            Country country = (Country) var;
            country.setConstrains(this.generalConstraints);
            country.setDomain(this.generalDomain);
            country.setNeighbors(new HashSet<>());

            switch (country.getCountry()){
                case WA:
                     country.addNeighbor(Source.getCountry(NT));
                     country.addNeighbor(Source.getCountry(SA));
                break;
                case  NT:
                     country.addNeighbor(Source.getCountry(WA));
                     country.addNeighbor(Source.getCountry(Q));
                     country.addNeighbor(Source.getCountry(SA));
                 break;
                case SA:
                     country.addNeighbor(Source.getCountry(NT));
                     country.addNeighbor(Source.getCountry(WA));
                     country.addNeighbor(Source.getCountry(Q));
                     country.addNeighbor(Source.getCountry(NSW));
                     country.addNeighbor(Source.getCountry(V));
                    break;
                case Q:
                    country.addNeighbor(Source.getCountry(NT));
                    country.addNeighbor(Source.getCountry(SA));
                    country.addNeighbor(Source.getCountry(NSW));
                    break;
                case NSW:
                    country.addNeighbor(Source.getCountry(Q));
                    country.addNeighbor(Source.getCountry(SA));
                    country.addNeighbor(Source.getCountry(V));
                    break;
                case V:
                    country.addNeighbor(Source.getCountry(SA));
                    country.addNeighbor(Source.getCountry(NSW));
                    break;
                case T:
                    break;

            }
        }

    }

    @Override
    public void configureNodes() {
        configureContries();
    }


}
