package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;


import java.util.HashSet;

import java.util.Set;

public class Source {

    private static Set<IDomain> domain;
    private static Set<IVariable> variables;
    private static Set<IConstraint> constraints;

    public static Set<IVariable> getVariables(){

        variables = new HashSet<>();

       variables.add(new Country(CountryEnum.WA));
       variables.add(new Country(CountryEnum.NT));
       variables.add(new Country(CountryEnum.SA));
       variables.add(new Country(CountryEnum.Q));
       variables.add(new Country(CountryEnum.NSW));
       variables.add(new Country(CountryEnum.V));
       variables.add(new Country(CountryEnum.T));

        return variables;

    }

    public static Set<IDomain> getDomain() {

        Source source = new Source();
        source.domain = new HashSet<>();

        source.domain.add(Color.BLUE);
        source.domain.add(Color.RED);
        source.domain.add(Color.GREEN);

        return source.domain;
    }

    public static Set<IConstraint> getConstraints(){
        Source source = new Source();
        source.constraints = new HashSet<>();

        source.constraints.add(MapColoringConstraint.DIFFERENT_COLOR);

        return source.constraints;

    }

    public static Country getCountry(CountryEnum country){
        for (IVariable var: variables){
            Country ctry = (Country) var;
            if(ctry.getCountry().equals(country)){
                return ctry;
            }
        }
        return null;
    }




}
